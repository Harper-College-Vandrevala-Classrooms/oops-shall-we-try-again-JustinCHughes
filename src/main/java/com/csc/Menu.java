package com.csc;
import java.util.Scanner;

// Your code goes here!
public class Menu
{
    // Aggregated all function manager options at the top
    // LOWER_BOUND_ACTIVE and UPPER_BOUND_ACTIVE dictate if bounds will be placed on user input
    // LOWER_BOUND and UPPER_BOUND state bound criterias
    // Messages dictate what user sees when being prompted and the program's responses
    private static boolean LOWER_BOUND_ACTIVE = true;
    private static boolean UPPER_BOUND_ACTIVE = true;
    private static int LOWER_BOUND = 0;
    private static int UPPER_BOUND = 12;
    private static String inputMessage = "Please enter a value: \n";
    private static String errorMessage = "Input was invalid. Please try again.\n\n";
    private static String successMessage = "Thank you. That input is valid. Have a nice day.\n";

    public static void main(String[] args)
    {
        // Initializing check and Scanner
        boolean check = false;
        
        Scanner in = new Scanner(System.in);
        System.out.print(inputMessage);
        
        while (check == false)
        {
            // Check if value if is int. If it is, call inputCheck to see if meets bound requirements
            if(in.hasNextInt())
            {
                check = inputCheck(in.nextInt());
            }

            // If check is still false, re-request for input
            if(check == false)
            {
                System.out.print(errorMessage + inputMessage);
                in.nextLine();
            }
        }
        // Value was true, terminate program
        System.out.print(successMessage);
    }

    // Check if value submitted meets bound requirements
    // Can always add more checks in here if needed such as divisibility
    public static boolean inputCheck(int userInput)
    {
        if (UPPER_BOUND_ACTIVE && LOWER_BOUND_ACTIVE)
        {
            return userInput > LOWER_BOUND && userInput < UPPER_BOUND;
        }
        else if (UPPER_BOUND_ACTIVE)
        {
            return userInput < UPPER_BOUND;
        }
        else if (LOWER_BOUND_ACTIVE)
        {
            return userInput > LOWER_BOUND;
        }
        else
        {
            return true;
        }
    }
}