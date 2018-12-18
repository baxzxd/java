//Project Name: Game of Craps
//Date: 12/6/2018
//Name: Adam Mason
/*   Project Description 
   test
   */
import java.util.Scanner;
import java.util.Random;
public class crapsProject
{
    public static void main(String [] args)
    {
        //Initialize Random number and Scanner
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
        //Initialize Variables
            char progRun = 'p';
            int diceSum, point, rollCounter, currentBet = 0;
            int playerBalance = 1000;
        //Greet player and ask for name
            System.out.print("Welcome to Adam's casino! Please enter your name to get started:");
            String playerName = scan.nextLine();
            System.out.println();
        while( progRun == 'p' )
        {   
            currentBet = -1;
            while(currentBet <= 0 || currentBet > playerBalance)
            {
                System.out.print("Enter a bet from your $" + playerBalance + " balance: ");
                currentBet = scan.nextInt();
            }
            if( progRun == 'p')
            {
                //Set roll count to 1, get new diceSum and print
                    playerBalance -= currentBet;
                    rollCounter = 1;
                    diceSum = rand.nextInt(11) + 2;
                    System.out.print("Roll 1: " + playerName + " rolls a " + diceSum + ". ");
                if ( diceSum == 2 || diceSum == 3 || diceSum == 12 )
                    System.out.println("You lost!");
                else if ( diceSum == 7 || diceSum == 11 )
                {
                    System.out.println("You won $" + (currentBet * 2) + "!");
                    playerBalance += currentBet * 2;
                }
                else 
                {
                    //If diceSum does not make player win or lose set point equal to diceSum
                        point = diceSum;
                        System.out.print( "The point becomes " + point );
                    //Roll until you get to break statement and break out
                    while(true)
                    {
                        //Set roll count and diceSum
                            rollCounter++;
                            diceSum = rand.nextInt(11) + 2;
                            System.out.print("\nRoll " + rollCounter + ": " + playerName + " rolls a " + diceSum + ". ");
                        //Check if player lost or got the point, and then break
                        if (diceSum == 7)
                        {   
                            System.out.println("You lost!");
                            break;
                        }
                        else if (diceSum == point)
                        {   
                            System.out.println("You won $" + (currentBet * 2) + "!");
                            playerBalance += currentBet * 2;
                            break;
                        }
                    }
                }
            }
            if(playerBalance <= 0)
            {
                System.out.println("You're broke!");
                break;
            }
            progRun = ' ';
            while(progRun != 'p' && progRun != 'q')
            {
                System.out.print("Would you like to (p)lay or (q)uit?: ");
                scan.nextLine();
                progRun = scan.nextLine().toLowerCase().charAt(0);
                System.out.println();
            }
        }
        System.out.println("Goodbye, " + playerName + "!");
    }   
}
//End-of-file