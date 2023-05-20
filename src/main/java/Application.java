import board.MemberBoard;
import utils.ReaderUtils;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		List<String> lines = ReaderUtils.getReadmeFile();
		List<String> members = MemberBoard.extractMemberName(lines); // [성재, 테스터]

		MemberBoard board = new MemberBoard(members);
		board.updateBoard(lines);
	}
}
