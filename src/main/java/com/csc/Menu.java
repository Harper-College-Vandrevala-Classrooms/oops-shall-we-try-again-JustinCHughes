package com.csc;
import java.util.Scanner;

// Your code goes here!
public class Menu
{
    // Declaring bounds at the top so they stand out for user
    private static int LOWER_BOUND = 0;
    private static int UPPER_BOUND = 12;

    public static void main(String[] args)
    {
        // Initializing check and Scanner
        boolean check = false;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a value: \n");
        
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
                System.out.print("Input was invalid. Please try again\n\n" +
                                "Please enter a value: \n");
                in.nextLine();
            }
        }
        // Value was true, terminate program
        System.out.print("Thank you. That input is valid. Have a nice day\n");
    }

    // Check if value submitted meets bound requirements
    // Can always add more checks in here if needed such as divisibility
    public static boolean inputCheck(int userInput)
    {
        return userInput > LOWER_BOUND && userInput < UPPER_BOUND;
    }
}