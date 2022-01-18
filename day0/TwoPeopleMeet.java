package day0;

public class TwoPeopleMeet {
    /**
     * @param s1
     * @param s2
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isMet(int s1, int s2, int v1, int v2) {
        if (s1 > s2 && v1 >= v2) {
            System.out.println("They do not meet!");
            return false; // They will never meet
        }
        if (s2 > s1 && v2 >= v1) {
            System.out.println("They do not meet!");
            return false; // They will never meet
        }

        while (s1 >= s2) {
            if (s1 == s2) {
                System.out.println("They have met!");
                return true;
            }

            s1 += v1;
            s2 += v2;
        }

        return false;
    }

    // O(1) as we are not using any iteration here.
    public static boolean isMetEquation(int s1, int s2, int v1, int v2) {
        if (s1 > s2 && v1 >= v2) {
            System.out.println("They do not meet!");
            return false; // They will never meet
        }
        if (s2 > s1 && v2 >= v1) {
            System.out.println("They do not meet!");
            return false; // They will never meet
        }

        int relativeDistance = Math.abs(s1 - s2);
        int relativeSpeed = Math.abs(v1 - v2);

        if (relativeDistance % relativeSpeed == 0) {
            System.out.println("They Met");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int s1 = 6;
        int s2 = 4;

        int v1 = 6;
        int v2 = 8;

//        System.out.println(isMet(s1, s2, v1, v2));
        System.out.println(isMetEquation(s1, s2, v1, v2));
    }
}
