package JAVA.day5;

import java.util.LinkedList;

public class LL2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);

        list.addFirst("this");
        list.add("list"); // This shall add a node at the end of the list.
        System.out.println(list);

        // Get Size of the linked list
        System.out.println(list.size());

        for (String s : list) {
            System.out.print(s + " -> ");
        }
        System.out.println("null");

        /*list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);*/
        list.remove(3);
        System.out.println(list);
    }
}
