public class LastNumberInString {
    public static void main(String[] args) {
        String input = "In 2020, Sofia found seven numbers on an abandoned road: 1, 2, 3, 4, 5, 6 and 9. In 2021..";
        System.out.println(lastNumber(input));
    }

    public static char lastNumber(String inputString) {
        char result = ' ';
        for (Character c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                result = c;
            }
        }
        return result;
    }
}