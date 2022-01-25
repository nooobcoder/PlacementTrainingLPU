package JAVA.day2;

import java.util.ArrayList;
import java.util.List;

// Source: https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {

    public static ArrayList<String> list;

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        printBalancedParentheses(n, n, "");
        return list;
    }

    public static void printBalancedParentheses(int open, int close, String output) {
        if (close < open) {
            return;

        }
        if (open == 0 && close == 0) {
            list.add(output);
            return;
        }

        if (open > 0) {
            String newString = output + "(";
            printBalancedParentheses(open - 1, close, newString);
        }
        if (close > 0) {
            String newString = output + ")";
            printBalancedParentheses(open, close - 1, newString);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);

        for (String a : list)
            System.out.println(a);
    }
}
