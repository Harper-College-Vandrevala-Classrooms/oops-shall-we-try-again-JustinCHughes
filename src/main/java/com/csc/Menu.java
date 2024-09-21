package com.csc;
import java.util.Scanner;

// Your code goes here!
public class Menu
{
    // Calls Integer instead of int so that function can return null 
    public static Integer promptResponse(boolean lowerBoundActive, boolean upperBoundActive
                                    ,int lowerBound, int upperBound, String inputMessage
                                    ,String errorMessage, String successMessage)
    {
        // Initializing variables
        boolean check = false;
        Scanner in = new Scanner(System.in);
        System.out.print(inputMessage);
        int userInput = 0;
        String userStringInput;
        
        do {
            // Check if value if is int. If it is, call inputCheck to see if meets bound requirements
            if(in.hasNextInt())
            {
                userInput = in.nextInt();
            } else {

                userStringInput = in.next().toLowerCase();
                
                if(userStringInput.equals("exit"))
                {
                    return null; // Terminates program if user wants to exit
                }
                else if(userStringInput.equals("default"))
                {
                    userInput = 100;
                }
            }

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
        promptResponse(true, true, 0,100
                        ,"Please enter a value: \n"
                        ,"Input was invalid. Please try again.\n\n"
                        ,"Thank you. That input is valid. Have a nice day.\n");
    }
}