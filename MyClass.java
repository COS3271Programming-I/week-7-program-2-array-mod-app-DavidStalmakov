package projectdavid;

import java.util.Scanner;
import java.util.Arrays;

////// This program allows the user to enter and edit integers
public class MyClass {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        int size = 0;

        System.out.println("Enter up to 20 integers (type done to finish):");
        while (size < 20) {
            System.out.print("Number " + (size + 1) + ": ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                numbers[size] = Integer.parseInt(input);
                size++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter an integer.");
            }
        }

        boolean editing = true; 
        while (editing) {
            System.out.println("\nCurrent array:");
            for (int i = 0; i < size; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println("\nDo you want to edit a number? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter the position (1 to " + size + ") you want to edit: ");
                int position = scanner.nextInt();
                scanner.nextLine(); // clear newline
                if (position < 1 || position > size) {
                    System.out.println("Invalid position.");
                    continue;
                }
                System.out.print("Enter the new value: ");
                numbers[position - 1] = scanner.nextInt();
                scanner.nextLine(); // clear newline
            } else {
                editing = false;
            }
        }

        Arrays.sort(numbers, 0, size);

        System.out.println("\nSorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }

        scanner.close();
    }
}
