package lectures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Lecture2 {
    public static void main(String[] args) {

//        ArrayList<String> students = new ArrayList<>();
//
//        students.add("Amit");
//        students.add("Rahul");
//        students.add("Priya");
//        students.add("Sneha");
//        students.add("Rohan");
//
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.get(i));
//        }
//    }
    	
    	
//    	  ArrayList<Integer> numbers = new ArrayList<>();
//
//          numbers.add(10);
//          numbers.add(45);
//          numbers.add(20);
//          numbers.add(70);
//          numbers.add(35);
//
//          int largest = numbers.get(0);
//
//          for (int i = 1; i < numbers.size(); i++) {
//
//              if (numbers.get(i) > largest) {
//                  largest = numbers.get(i);
//              }
//          }
//
//          System.out.println("Largest number: " + largest);
      
    
    
    
//    LinkedList<String> students = new LinkedList<>();
//
//    students.add("Amit");
//    students.add("Rahul");
//    students.add("Priya");
//    students.add("Sneha");
//
//    System.out.println("Queue: " + students);
//
//    String removedStudent = students.removeFirst();
//
//    System.out.println("Removed: " + removedStudent);
//    System.out.println("Remaining: " + students);
    
    
    //-------------------------------------------------
    
//    LinkedList<Integer> numbers = new LinkedList<>();
//
//    numbers.add(20);
//    numbers.add(30);
//
//    numbers.addFirst(10);
//    numbers.addLast(40);
//
//    System.out.println("Original: " + numbers);
//
//    numbers.removeFirst();
//    numbers.removeLast();
//
//    System.out.println("After removal: " + numbers);
    
    
    
//    Set<Integer> numbers = new HashSet<>();
//
//    numbers.add(10);
//    numbers.add(20);
//    numbers.add(10);
//    numbers.add(30);
//    numbers.add(20);
//    numbers.add(40);
//
//    System.out.println("Unique numbers:");
//
//    for (int number : numbers) {
//        System.out.println(number);
//    }
    
    
//    	
//        Set<Integer> groupA = new HashSet<>();
//        Set<Integer> groupB = new HashSet<>();
//
//        groupA.add(101);
//        groupA.add(102);
//        groupA.add(103);
//        groupA.add(104);
//
//        groupB.add(103);
//        groupB.add(104);
//        groupB.add(105);
//        groupB.add(106);
//
//        groupA.retainAll(groupB);
//
//        System.out.println("Common roll numbers: " + groupA);

    
    	
//    	int[] numbers = {10, 20, 10, 30, 20, 10};
//
//        Map<Integer, Integer> frequency = new HashMap<>();
//
//        for (int number : numbers) {
//
//            if (frequency.containsKey(number)) {
//                frequency.put(number, frequency.get(number) + 1);
//            } else {
//                frequency.put(number, 1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
//            System.out.println(entry.getKey() + " appears "
//                    + entry.getValue() + " times");
//        }
        
        
        
        Map<String, Integer> marks = new HashMap<>();

        marks.put("Amit", 75);
        marks.put("Rahul", 90);
        marks.put("Priya", 85);

        String topper = "";
        int highest = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            if (entry.getValue() > highest) {
                highest = entry.getValue();
                topper = entry.getKey();
            }
        }

        System.out.println("Topper: " + topper);
        System.out.println("Marks: " + highest);
    }
    
}