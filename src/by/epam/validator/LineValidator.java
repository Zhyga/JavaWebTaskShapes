package by.epam.validator;

public class LineValidator {
    private static final String LINE_REGEX = "^(([\\d]+\\.[\\d]+)\\s){23}" + "([\\d]+\\.[\\d]+)$";

        public static boolean isLineConformCube(String line){
            boolean result = false;
            if(line != null){
                result = line.matches(LINE_REGEX);
            }
            return result;
        }
}
