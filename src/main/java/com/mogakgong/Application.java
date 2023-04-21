package com.mogakgong;

import com.mogakgong.board.MemberBoard;
import com.mogakgong.utils.ReaderUtils;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		List<String> lines = ReaderUtils.getReadmeFile();
		List<String> members = MemberBoard.extractMemberName(lines); // [깨비, 성재]

		MemberBoard board = new MemberBoard(members);
		board.updateBoard(lines);
	}
}
