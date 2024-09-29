public class RLEReverse {
    public static void main(String[] args) {
        String test = "a3B2c4e1"; //aaaBBcccce
        System.out.println(RLERevers(test));
    }

    private static String RLERevers(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i += 2) {
            char letter = string.charAt(i);
            int count = Character.getNumericValue(string.charAt(i + 1));

            while (count > 0) {
                sb.append(letter);
                count--;
            }
        }
        return sb.toString();
    }
}
