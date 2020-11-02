package lsq;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Lsq {

    static void userSelection() throws Exception {
        System.out.println("\n======BASIC OPTIONS=======");
        Scanner input = new Scanner(System.in);
        System.out.println("1. Reverse \n2. Convert \n3. Compare");
        System.out.print("\nPlease select an option: ");
        int selection = input.nextInt();
        System.out.println("\nThe selected file is states.txt");

        if (selection == 1) {
            System.out.println("The file contents have been popped and reversed");
            reversePopStack();
        } else if (selection == 2) {
            System.out.println("The file contents have been dequeue and converted");
            dequeueUpperLinked();
        } else if (selection == 3) {
            System.out.println("Compare function");
        } else {
            System.out.println("Invalid Option only 1, 2 or 3 allowed");
        }

    }

    static String readTextFile() throws Exception {
        Scanner sc = new Scanner(new FileReader("states.txt"));
        return sc.nextLine();
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
        String stringFromFile = readTextFile();
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
        String stringFromFile = readTextFile();
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

    public static void main(String[] args) throws Exception {
        userSelection();
    }

}
