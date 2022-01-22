package JAVA.day2;

public class MaxUsingRecursion {
    public static int maximumElement(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[arr.length - 1];

        int currentMax = arr[index];
        int recursionMax = maximumElement(arr, index + 1);

        return Math.max(currentMax, recursionMax);
    }

    public static void main(String[] args) {
        System.out.println(maximumElement(new int[]{5, 12, 7, 1, 6, 8}, 0));
    }
}
