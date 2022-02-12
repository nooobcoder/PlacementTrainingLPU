import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in) ;
        Integer n = scanner.nextInt() ;
        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException("1 <= n <= 100000") ;
        }

        DecimalFormat fmt = new DecimalFormat("#.#") ;
        SplitedNumberSet set = new SplitedNumberSet() ;
        for (int i=0;i<n;i++) {
            String operation = scanner.next() ;
            if (operation.equals("a") ) {
                set.addNum(scanner.nextInt());
            } else if  (operation.equals("r")) {
                if (!set.removeNum(scanner.nextInt())) {
                    System.out.println("Wrong!") ;
                    continue ;
                }
            } else {
                throw new IllegalArgumentException("Operation must be a or r") ;
            }
            Double median = set.getMedian() ;
            if (median != null) {
                //System.out.println(fmt.format(median)+" "+set) ;
                System.out.println(fmt.format(median)) ;
            } else {
                System.out.println("Wrong!") ;
            }
       }       
    }
    
    private static class SplitedNumberSet {
        private NumberSet smallSet = new NumberSet() ;
        private NumberSet largeSet = new NumberSet() ;
        
        public void addNum(Integer num) {
            if (smallSet.getLastNum() >= num) {
                smallSet.addNum(num) ;
            } else {
                largeSet.addNum(num) ;
            }
            balanceTree() ;
        }
        
        public boolean removeNum(Integer num) {
            boolean removed = false ;
            if (smallSet.getLastNum() >= num) {
                removed = smallSet.removeNum(num) ;
            } else {
                removed = largeSet.removeNum(num) ;
            }
            if (removed) {
                balanceTree() ;
            }
            return removed ;
        }
        
        public void balanceTree() {
            if (smallSet.getNumberCnt()-largeSet.getNumberCnt()>1) {
                // Push last number in smallSet to large
                Integer middleNum = smallSet.getLastNum() ;
                smallSet.removeNum(middleNum);
                largeSet.addNum(middleNum) ;
            } else if (largeSet.getNumberCnt()>smallSet.getNumberCnt()) {
                // Push first number in largeSet to small
                Integer middleNum = largeSet.getFirstNum() ;
                largeSet.removeNum(middleNum);
                smallSet.addNum(middleNum) ;
            }
         }
        
        
        public Double getMedian() {
            if (smallSet.getNumberCnt()<=0 && largeSet.getNumberCnt() <=0) {
                return null ;
            }

            if (smallSet.getNumberCnt() > largeSet.getNumberCnt()) {
                return (double)smallSet.getLastNum() ;
            } else if (smallSet.getNumberCnt() < largeSet.getNumberCnt()) {
                return (double)largeSet.getFirstNum() ;
            } else {
                return (((long)smallSet.getLastNum()+(long)largeSet.getFirstNum())/2d) ;
            }
        }
        
        public String toString() {
            return "small:"+smallSet+" large:"+largeSet ;
        }
    }
    
    private static class NumberSet {
        private SortedMap<Integer,Integer> map = new TreeMap<Integer,Integer>() ;
        private int numberCnt = 0;

        public void addNum(Integer num) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1) ;
            } else {
                map.put(num,1) ;
            }
            numberCnt++ ;
        }

        public boolean removeNum(Integer num) {
            Integer current = map.get(num) ;
            if (current == null) {
                return false ;
            }
            if (current==1) {
                map.remove(num) ;
            } else {
                map.put(num,current-1) ;            
            }
            numberCnt-- ;
            return true ;
        }
        
        public Integer getFirstNum() {
            if (map.isEmpty()) {
                return Integer.MIN_VALUE ;
            }
            return map.firstKey() ;
        }
        
        public Integer getLastNum() {
            if (map.isEmpty()) {
                return Integer.MAX_VALUE ;
            }
            return map.lastKey() ;
        }
        
        public Integer getNumberCnt() {
            return numberCnt ;
        }
        
        public String toString() {
            return map+":"+numberCnt ;
        }
    }

}