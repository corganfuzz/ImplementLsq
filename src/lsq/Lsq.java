package lsq;

import java.io.FileReader;
import java.io.PrintWriter;
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
            System.out.println("Convert function");
        } else if (selection == 3) {
            System.out.println("Compare function");
        } else {
            System.out.println("Invalid Option only 1, 2 or 3 allowed");
        }

    }

    static void writeToFile(Stack<Character> data, String filename) {
            try {
                PrintWriter output = new PrintWriter(filename);
                output.println(data);
                output.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
    }

    static void reversePopStack() throws Exception {
        String filename = "reversedStack.txt";
        Scanner sc = new Scanner(new FileReader("states.txt"));
        String stringFromFile = sc.nextLine();
        Stack<Character> myStack = new Stack<>();
        for(char c: stringFromFile.toCharArray()) {
            myStack.push(c);
        }
        myStack.pop();
        String outputChar = "";
        while(!myStack.isEmpty()) {
            outputChar += myStack.pop();
        }
        Stack<Character> reverseResult = new Stack<>();
        for(char o: outputChar.toCharArray()) {
            reverseResult.push(o);
        }
        System.out.println(reverseResult);
        System.out.println("\nThis content have been written to " + filename + ", located at the root folder");
        writeToFile(reverseResult, filename);
    }

    static void dequeueUperLinked() {

    }

    public static void main(String[] args) throws Exception {
        userSelection();
    }

}
