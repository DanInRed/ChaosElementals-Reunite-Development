
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.core;

import java.util.Scanner;
/**
 *
 * @author Dash
 */
public class InputValidator {
    
    public static String getValidString(String prompt, Scanner scanf){
        String input = "";
        
        while(true){
            try{
                System.out.print(prompt);
                input = scanf.nextLine().trim();
                
                break;
                
            }catch(Exception e){
                System.out.println("Invalid Input! Please Try again!");
            }
        }
        
        return input;
    }
    
    public static int getValidElement(String prompt, Scanner scanf) {
            while (true) {
                System.out.print(prompt);
                String input = scanf.nextLine().trim();
                try {
                    // Filter 1: Remove common non-digit impurities (like currency or units)
                    input = input.replaceAll("[^0-9.-]", ""); 

                    // Filter 2: Check if it's empty after cleaning
                    if (input.isEmpty()) {
                        System.out.println("Error: No numbers detected. Please try again.");
                        continue;
                    }

                    int value = Integer.parseInt(input);
                    // Logic Exception: Range Check
                    if ( value < 0 || value > 7){
                        System.out.println("Error: Input must be 0 to 7 only!.");
                        continue;
                    }
                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + input + "' is not a valid decimal number.");
                } 
            }
        }
    public static int getValidAttack(String prompt, Scanner scanf) {
            while (true) {
                System.out.print(prompt);
                String input = scanf.nextLine().trim();
                try {
                    // Filter 1: Remove common non-digit impurities (like currency or units)
                    input = input.replaceAll("[^0-9.-]", ""); 

                    // Filter 2: Check if it's empty after cleaning
                    if (input.isEmpty()) {
                        System.out.println("Error: No numbers detected. Please try again.");
                        continue;
                    }

                    int value = Integer.parseInt(input);
                    // Logic Exception: Range Check
                    if ( value < 0 || value > 3){
                        System.out.println("Error: Input must be 0 to 3 only to activate your Attack!.");
                        continue;
                    }
                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + input + "' is not a valid decimal number.");
                } 
            }
        }
    
    
}
/*
import java.util.Scanner;

    /**
     * @author Dash with gemini
     * @version 1
     * Intent: Centralized input handling to prevent JVM crashes and 
     * ensure data integrity for your system.
     */
/*
    public class InputValidator {

        private static final Scanner sc = new Scanner(System.in);
        
        //Inside InputValidator add a close method and call at the very last line in main
        public static void closeScanner() {
            sc.close();
        }
        
        // 1. Handles Double parsing and NumberFormatException
        public static double getValidDouble(String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                try {
                    // Filter 1: Remove common non-digit impurities (like currency or units)
                    input = input.replaceAll("[^0-9.-]", ""); 

                    // Filter 2: Check if it's empty after cleaning
                    if (input.isEmpty()) {
                        System.out.println("Error: No numbers detected. Please try again.");
                        continue;
                    }

                    double value = Double.parseDouble(input);
                    // Logic Exception: Range Check
                    if (value <= 0) {
                        System.out.println("Error: Financial values cannot be negative.");
                        continue;
                    }
                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + input + "' is not a valid decimal number.");
                }
            }
        }

        //Int handler derived from the code above

        public static int getValidInt(String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                try {
                    // Filter 1: Remove common non-digit impurities (like currency or units)
                    input = input.replaceAll("[^0-9.-]", ""); 

                    // Filter 2: Check if it's empty after cleaning
                    if (input.isEmpty()) {
                        System.out.println("Error: No numbers detected. Please try again.");
                        continue;
                    }

                    int value = Integer.parseInt(input);
                    // Logic Exception: Range Check
                    if (value <= 0) {
                        System.out.println("Error: Int values cannot be negative.");
                        continue;
                    }
                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + input + "' is not a valid decimal number.");
                } 
            }
        }

        // 2. Handles String validation and Empty-Input "Pseudo-Exceptions"
        public static String getValidString(String prompt) {
            while (true) {
                System.out.print(prompt);
                if (sc.hasNextLine()) {
                    String input = sc.nextLine().trim();

                    // Logic Exception: Empty or whitespace-only strings
                    if (input.isEmpty()) {
                        System.out.println("Error: This field is mandatory and cannot be blank.");
                        continue;
                    }
                    return input;
                } else {
                    // Technical Exception: NoSuchElementException
                    throw new IllegalStateException("System input stream was unexpectedly closed.");
                }
            }
        }

        // 3. Handles Char parsing and StringIndexOutOfBoundsException
        public static char getValidChar(String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = sc.nextLine().trim().toUpperCase();

                // Logic Exception: Checking if the user typed more or less than one char
                if (input.length() != 1) {
                    System.out.println("Error: Please enter a single character (e.g., Y/N).");
                    continue;
                }
                char result = input.charAt(0);
                //switch below is reserved only for this(CampusSecurity) file
                switch(result){
                    case 'S':
                    case 'I':
                    case 'L':
                        break;
                    default:
                        System.out.println("Error: '" + result + "' is not a valid category (S, I, or L).");
                }

                //commented above from switch until end is only for (CampusSecurity) file
                return input.charAt(0); // Safe from StringIndexOutOfBounds because we checked length
            }
            
        }
    }
*/