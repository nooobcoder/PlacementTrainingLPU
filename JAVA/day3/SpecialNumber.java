package JAVA.day3;

public class SpecialNumber {

    public static boolean isSpecial(int num) {
        long squareValue = (long) Math.pow(num, 2);
        String stringValue = String.valueOf(squareValue);

        float mid = (float) stringValue.length() / 2;
        int leftHalfIndex = (int) (float) Math.floor(mid);
        int rightHalfIndex = (int) (float) Math.ceil(mid);

        int leftHalf = Integer.parseInt(stringValue.substring(0, leftHalfIndex));
        int rightHalf = Integer.parseInt(stringValue.substring(leftHalfIndex));

        return leftHalf + rightHalf == num;
    }

    public static void main(String[] args) {
        System.out.println(isSpecial(9));
        System.out.println(isSpecial(297));
    }
}
