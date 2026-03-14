
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
                    input = input.replaceAll("[^0-9]", ""); 

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