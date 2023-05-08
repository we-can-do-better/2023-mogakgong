package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.DateUtils.FORMAT_TODAY_DATE;

public class ReaderUtils {

    private static final String README_PATH = "./README.md";

    public static List<String> getReadmeFile() {
        File file = new File(README_PATH);
        List<String> lines = toListByReadme(file);

        return lines;
    }

    private static List<String> toListByReadme(File file) {
        try {
            List<String> lines = new ArrayList<>();

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("README 파일이 존재하지 않습니다.", e);
        }
    }

    public static String[] getFileListInMemberDirectory(String member) {
        File file = new File("./" + member); // ./깨비
        return file.list();
    }

    public static void addLineWithDate(int joinMember) {
        System.out.println("====> CREATE LINE WITH NOW DATE");

        try {
            File file = new File(README_PATH);
            String newLine = createNewLine(joinMember);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(newLine);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("날짜 칸 추가에 실패하였습니다.", e);
        }
    }

    private static String createNewLine(int joinMember) {
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(FORMAT_TODAY_DATE);
        for (int i = 0; i < joinMember; i++) {
            sb.append("|").append(" ");
        }
        System.out.println("==> Create New Line");
        return sb.append("|").toString();
    }

    public static void applyMemberBoard(List<String> lines) {
        for (String line : lines) {
            System.out.println("line = " + line);
        }

        try {
            Path path = Paths.get(README_PATH);
            Files.write(path, lines, StandardCharsets.UTF_8);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==> Success overwritten README");
    }
}
