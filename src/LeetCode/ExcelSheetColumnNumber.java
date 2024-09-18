package LeetCode;

//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String t1 = "FXSHRXW";
        String t2 = "BC"; //55
        String t3 = "ZY";

        System.out.println(columnNumber(t1));
        System.out.println(columnNumber(t2));
        System.out.println(columnNumber(t3));
    }

    public static int columnNumber(String columnTitle) {
        int pow = columnTitle.length() - 1;
        int i = 0;
        int res = 0;
        do {
            int charIndex = columnTitle.charAt(i) - 64;
            res += (int) (charIndex * (Math.pow(26, pow)));
            i++;
            pow--;
        } while (pow >= 0);
        return res;
    }

}
