public class CesarsCipher {
    public static void main(String[] args) {
        int code = 25;
        String input = "Cipher testing string";
        String cipher = toCipher(input, code);

        System.out.println("Cipher - " + cipher + "\n Original - " + fromCipher(cipher, code));
    }

    private static String toCipher(String string, int code) {
        StringBuilder result = new StringBuilder();
        for (Character c : string.toCharArray()) {
            if (c < 91 && c > 64) {
                char upperCase = (char) ((c + code) % 91);
                if (upperCase <= 26) {
                    upperCase += 65;
                }
                result.append(upperCase);
            } else if (c < 123 && c > 96) {
                char lowerCase = (char) ((c + code) % 123);
                if (lowerCase <= 26) {
                    lowerCase += 97;
                }
                result.append(lowerCase);
            } else {
                char otherChar = c;
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String fromCipher(String string, int code) {
        StringBuilder result = new StringBuilder();
        for (Character c : string.toCharArray()) {
            if (c < 91 && c > 64) {
                char upperCase = (char) ((c - code) % 91);
                if (upperCase <= 65) {
                    upperCase += 26;
                }
                result.append(upperCase);
            } else if (c < 123 && c > 96) {
                char lowerCase = (char) ((c - code) % 123);
                if (lowerCase <= 97) {
                    lowerCase += 26;
                }
                result.append(lowerCase);
            } else {
                char otherChar = c;
                result.append(c);
            }
        }
        return result.toString();
    }
}
