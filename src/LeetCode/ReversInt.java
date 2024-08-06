package LeetCode;

public class ReversInt {
    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            sb.append(x);
            long res = Long.parseLong(sb.reverse().toString());
            return res > 2_147_483_647 ? 0 : (int) res;
        } else {
            String temp = String.valueOf(x);
            sb.append(temp.substring(1, temp.length()));
            long res = Long.parseLong("-" + sb.reverse());
            return res < -2_147_483_647 ? 0 : (int) res;
        }
    }
}
