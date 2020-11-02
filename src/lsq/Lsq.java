package lsq;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Lsq {

    static void userSelection() throws Exception {
        System.out.println("\n======BASIC OPTIONS=======\n");
        Scanner input = new Scanner(System.in);
        System.out.println("1. Reverse \n2. Convert \n3. Compare");
        System.out.print("\nMake your selection: ");
        int selection = input.nextInt();
        System.out.println("\nThe selected file is states.txt");

        if (selection == 1) {
            System.out.println("The file contents have been popped and reversed");
            reversePopStack();
        } else if (selection == 2) {
            System.out.println("The file contents have been dequeue and converted");
            dequeueUpperLinked();
        } else if (selection == 3) {
            compareQ();
        } else {
            System.out.println("Invalid Option only 1, 2 or 3 allowed");
        }

    }

    static void writeToFile(String data, String filename) {
            try {
                PrintWriter output = new PrintWriter(filename);
                output.println(data);
                output.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
    }

    static void dequeueUpperLinked() throws Exception {
        String queueSavedFile = "queueUpper.txt";
        String stringFromFile = readTextFile("states.txt");

        Queue<Character> myQ = new LinkedList<>();

        for(char c: stringFromFile.toCharArray()) {
            myQ.add(c);
        }

        String qOutput = "";
        while (myQ.peek() != null) {
            qOutput = (qOutput + myQ.remove());
            System.out.println(qOutput.toUpperCase());
        }
        writeToFile(qOutput.toUpperCase(), queueSavedFile);
        System.out.println("\nThis content have been written to " + queueSavedFile + ", located at the root folder");
    }

    static void reversePopStack() throws Exception {
        String reversedSavedFile = "reversedStack.txt";
        String stringFromFile = readTextFile("states.txt");
        Stack<Character> myStack = new Stack<>();
        for(char c: stringFromFile.toCharArray()) {
            myStack.push(c);
        }
        String outputChar = "";
        while(!myStack.isEmpty()) {
            outputChar += myStack.pop();
            System.out.println(outputChar);
        }
        writeToFile(outputChar, reversedSavedFile);
        System.out.println("\nThis content have been written to " + reversedSavedFile + ", located at the root folder");
    }

    static String readTextFile(String filename) throws Exception {
        Scanner sc = new Scanner(new FileReader(filename));
        return sc.nextLine();
    }

    static void compareQ() throws Exception {
        String stringOne = readTextFile("reversedStack.txt");
        String stringTwo = readTextFile("queueUpper.txt");

        PriorityQueue<Character> firstQ = new PriorityQueue<>();
        for (char c: stringOne.toCharArray()) {
            firstQ.add(c);
        }

        System.out.println("The first Queue is: " + firstQ);

        PriorityQueue<Character> secondQ = new PriorityQueue<>();
        for (char c: stringTwo.toCharArray()) {
            secondQ.add(c);
        }

        System.out.println("The second Queue is: " + secondQ);

        if(firstQ.equals(secondQ)) {
            System.out.println("The Queues are identical");
        } else {
            System.out.println("""

                    THE QUEUES ARE NOT THE SAME
                    Yes and No indicate identical queue elements""");
            for (Character element : firstQ) {
                System.out.println(secondQ.contains(element) ? "Yes" : "No");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        userSelection();
    }

}
