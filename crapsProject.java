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
            int diceSum = 0;
            int point = 0;
            int rollCounter = 0;
        //Greet player and ask for name
            System.out.print("Welcome to Adam's casino! Please enter your name to get started:");
            String playerName = scan.nextLine();
            System.out.println();
        while( progRun == 'p' )
        {   
                //Ask user if they want to play again or quit and wait for input
                    progRun = ' ';
                while(progRun != 'p' && progRun != 'q')
                {
                    System.out.print("Would you like to (p)lay or (q)uit?: ");
                    progRun = scan.nextLine().toLowerCase().charAt(0);
                    System.out.println();
                }
                if( progRun == 'p')
                {
                    //Set roll count to 1, get new diceSum and print
                        rollCounter = 1;
                        diceSum = rand.nextInt(12) + 1;
                        System.out.print("Roll 1: " + playerName + " rolls a " + diceSum + ". ");
                    if ( diceSum == 2 || diceSum == 3 || diceSum == 12 )
                        System.out.println("You lost!");
                    else if ( diceSum == 7 || diceSum == 11 )
                        System.out.println("You won!");
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
                                diceSum = rand.nextInt(12) + 1;
                                System.out.print("\nRoll " + rollCounter + ": " + playerName + " rolls a " + diceSum + ". ");
                            //Check if player lost or got the point, and then break
                            if (diceSum == 7)
                            {   
                                System.out.println("You lost!");
                                break;
                            }
                            else if (diceSum == point)
                            {   
                                System.out.println("You won!");
                                break;
                            }
                        }
                    }
                }
        }
        System.out.println("Goodbye, " + playerName + "!");
    }   
}
//End-of-file