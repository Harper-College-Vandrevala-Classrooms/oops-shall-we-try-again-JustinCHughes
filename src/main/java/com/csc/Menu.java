package com.csc;
import java.util.Scanner;

// Your code goes here!
public class Menu
{ 
    public static int promptResponse(boolean upperBoundActive, boolean lowerBoundActive
                                    ,int lowerBound, int upperBound, String inputMessage
                                    ,String errorMessage, String successMessage)
    {
        // Initializing variables
        boolean check = false;
        Scanner in = new Scanner(System.in);
        System.out.print(inputMessage);
        int userInput = 0;
        
        do {
            // Check if value if is int. If it is, call inputCheck to see if meets bound requirements
            if(in.hasNextInt())
            {
                userInput = in.nextInt();
                if (lowerBoundActive && upperBoundActive)
                {
                    check = userInput > lowerBound && userInput < upperBound;
                }
                else if (upperBoundActive)
                {
                    check = userInput < upperBound;
                }
                else if (lowerBoundActive)
                {
                    check = userInput > lowerBound;
                }
                else
                {
                    check = true;
                }
            }
            
            // If check is still false, re-request for input
            if(check == false)
            {
                System.out.print(errorMessage + inputMessage);
                in.nextLine();
            }
        } while (check == false);
        // Value was true, terminate program
        System.out.print(successMessage);
        
        in.close();
        return userInput;
    }

    public static void main(String[] args)
    {
        promptResponse(false, false, 0,100
                        ,"Please enter a value: \n"
                        ,"Input was invalid. Please try again.\n\n"
                        ,"Thank you. That input is valid. Have a nice day.\n");
    }
}