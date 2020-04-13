package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String regex = "[a-z][a-z0-9:]*/[a-z0-9]+\\Q\\E[a-z]+";
    private static final String regex1 = "[a-z][a-z0-9:]*/[a-z0-9]+\\[a-z]+";

    public static List<Integer> commandCount(List<String> commands) {
        List<Integer> result = new ArrayList<>();
        for (String cmd : commands) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cmd);
            int count = 0;
            while (matcher.find())
                count++;
            result.add(count);
        }
        return result;
    }

    public static List<Integer> commandCount1(List<String> commands) {
        List<Integer> result = new ArrayList<>();
        for (String cmd : commands) {
            Matcher m = Pattern.compile(regex).matcher(cmd);
            List<String> allMatches = new ArrayList<>();
            if (m.find()) {
                do {
                    allMatches.add(m.group());
                } while (m.find(m.start(1)));
            }
            result.add(allMatches.size());
        }
        return result;
    }

    public static List<Integer> commandCount2(List<String> commands) {
        List<Integer> result = new ArrayList<>();
        for (String cmd : commands) {
            result.add(cmd.split(Pattern.quote(regex1)).length);
        }
        return result;
    }

//    public static List<Integer> commandCount3(List<String> commands) {
//        List<Integer> result = new ArrayList<>();
//        for (String cmd : commands) {
//            cmd.indexOf()
//        }
//        return result;
//    }

    public static void main(String[] args) {
        assert (commandCount2(List.of("abc:/b1c\\xy")).equals(List.of(6)));
        assert (commandCount2(List.of("w:/a\\bc/23a\\d:e:/12\\xyz")).equals(List.of(10)));
        assert (commandCount2(List.of("w::/a\\b")).equals(List.of(1)));
        assert (commandCount2(List.of("w:/a\\bc::/12\\xyz")).equals(List.of(8)));
        assert (commandCount2(List.of("w::/a\\b", "w:/a\\bc::/12\\xyz")).equals(List.of(1, 8)));
        assert (commandCount2(List.of("a/b\\c/d\\e:f:/1\\g", "a/a\\a/a\\a:a:/a\\a", "a/a", "a/a\\a/a\\a:b:/t9\\xyz")).equals(List.of(4, 4, 0, 8)));
    }
}