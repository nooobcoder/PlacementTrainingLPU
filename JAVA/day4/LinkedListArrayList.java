package JAVA.day4;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListArrayList {
    public static void main(String[] args) {
        // The LinkedList and ArrayList are both part of the Collection framework in Java.
        // Video Explanation: https://www.youtube.com/watch?v=5dscMs2hnDI
        // The difference is between their implementations and have their own trade offs.
        // Getting an element by it's index is very fast in case of array based structures, because arrays allow
        // random accessing of it's elements. This is not the case for LinkedLists. But it stores references to next nodes.
        // There is a lot of overhead in getting an element by it's index in case of a LinkedList.
        // Insertion of an element in a LinkedList is faster though as it has references to the node where it needs to insert.
        // Unfortunately, for an ArrayList this is a difficult task, as it would copy the existing values and make a new ArrayList
        // to get the value inserted.
        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("name1");
        namesLinkedList.add("name2");
        namesLinkedList.add("name3");
        namesLinkedList.add("name4");
        namesLinkedList.add("name5");
        System.out.println(namesLinkedList.get(2)); // Indices start from 0
        namesLinkedList.add(4, "name6");

        String[] names = new String[4];
        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("name1");
        namesArrayList.add("name2");
        namesArrayList.add("name3");
        namesArrayList.add("name4");
        namesArrayList.add("name5");
        System.out.println(namesArrayList.get(2));
        namesArrayList.add(4, "name6");
    }
}
