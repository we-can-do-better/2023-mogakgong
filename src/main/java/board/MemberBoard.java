package board;

import utils.DateUtils;
import utils.ReaderUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static utils.DateUtils.FORMAT_TODAY_DATE;
import static utils.FixtureUtils.*;

public class MemberBoard {

    private static final Pattern pattern = Pattern.compile("\\d{1,2}월\\s*\\d{1,2}일");

    private List<String> members;

    public MemberBoard(List<String> members) {
        this.members = members;
    }

    public static List<String> extractMemberName(List<String> lines) {
        int boardLine = extractMemberBoardLine(lines);

        String line = lines.get(boardLine + NEXT_LINE_POINTER);
        String[] boardColumns = line.split(VERTICAL_SLASH);

        return Arrays
                .stream(boardColumns, 2, boardColumns.length)
                .map(col -> col.trim())
                .collect(Collectors.toList());
    }

    private static int extractMemberBoardLine(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).equals(STUDY_MEMBER_HEADER)) return i;
        }
        throw new RuntimeException("스터디 멤버 정보를 가져올 수 없습니다.");
    }

    public void updateBoard(List<String> lines) {
        String lastLine = getLastLine(lines);
        validateLatestDate(lastLine);

        // TODO: f(n^2) -> f(n) 으로 변경 가능한 지 고민해보기
        for (int i = 0; i < members.size(); i++) {
            String[] files = ReaderUtils.getFileListInMemberDirectory(members.get(i)); // 멤버 폴더안 파일 목록

            for (String file : files) { // 특정 멤버 파일 목록 전체 루프
                Matcher matcher = pattern.matcher(file);

                // 날짜가 일치할 경우 쓰기 작업
                // 파일 이름이 [0416.md] 인 것은 Match 되지 않음
                if (DateUtils.isMatchDate(matcher)) {
                    refreshBoard(i, ReaderUtils.getReadmeFile());
                }
            }
        }
    }

    private static String getLastLine(List<String> lines) {
        return lines.get(lines.size() - 1);
    }

    private void validateLatestDate(String lastLine) {
        String latestDate = lastLine.split(VERTICAL_SLASH)[1].trim();

        // 오늘 날짜의 테이블이 없는 경우 생성
        if (!isSameLatestDateAndNowDate(latestDate)) {
            ReaderUtils.addLineWithDate(members.size());
        }
    }

    public boolean isSameLatestDateAndNowDate(String latestDate) {
        return latestDate.equals(FORMAT_TODAY_DATE) ? true : false;
    }

    private void refreshBoard(int member, List<String> lines) {
        String[] separateBoardStatus = getLastLine(lines).split(VERTICAL_SLASH);

        for (int i = 0; i < separateBoardStatus.length; i++) {
            if(sameIndex(member, i)) separateBoardStatus[i + 2] = "■";
        }

        String result = Arrays
                .stream(separateBoardStatus)
                .collect(Collectors.joining("|"));

        lines.set(lines.size() - 1, result + "|");

        ReaderUtils.applyMemberBoard(lines);
        //System.out.println("result = " + getLastLine(lines));
    }

    private static boolean sameIndex(int member, int i) {
        return i == member;
    }
}
