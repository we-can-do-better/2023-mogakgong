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

public final class ReaderUtils {

    private static final String README_PATH = "./README.md";

    private ReaderUtils() {}

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
