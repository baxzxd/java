import java.util.Scanner;
import java.util.Random;
public class blackJackNew
{
    public static void main(String [] args)
    {
        boolean progEnd = false;
        //Initialize Variables/////////////////////////////////////////////
        while( progEnd == false )
        {
            int playerCardTotal, dealtCard, dealerCardTotal = 0;
            int playerBalance = 100;
            String cardSuit, input = "";
			
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            
            String cardType[] = {"Ace","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Jack","Queen", "King"} ;
            String suitArray[] = { "Hearts", "Clubs", "Spades", "Diamonds" };
            String hand[] = { "", "", "", "", "", "", "", "", "", "", "", "", "", ""  };
			
            //Betting
            System.out.print("Enter bet from your $" + playerBalance + " balance:");
            int playerBet = scan.nextInt();
			System.out.println();
			
            //Draw Cards until Max Hand Size Possible
            for( i = 0; i < 14; i++)
            {
                //Check if Players card total is equal to 21 or greater than 21
                if( playerCardTotal > 21 ) { System.out.println("You Busted!"); break; }
                else if( playerCardTotal == 21 ) { System.out.println("You Win!"); break;}
                //If player has not busted or won continue
                if( playerCardTotal < 21)
                {
                    //Set random card
                    dealtCard = rand.nextInt(12);
                    cardSuit = suitArray[rand.nextInt(3)];
                    System.out.println("Hit or Stand?");
                    input = scan.nextLine();
                    if (!input.equals( "hit" ) && !input.equals( "stand" ) && !input.equals( "help" ) )
                    {
                        System.out.println("Wrong input, please enter Hit or Stand.");
                        i += -1;
                    }
                    else if (input.equals("hit"))
                    {
                        //give dealer random card
                        dealerCardTotal += rand.nextInt(12) + 1;

                        if (dealtCard == 0 && playerCardTotal <= 10)
                        {
                            hand[i] = cardType[dealtCard];
                            playerCardTotal += 11;
                            System.out.println("Hit!\n\"You drew an Ace worth eleven cards!\n" + "Card Total: " + playerCardTotal);
                        }
                        else if (dealtCard == 0 && playerCardTotal > 10)
                        {
                            hand[i] = cardType[dealtCard];
                            playerCardTotal += 1;
                            System.out.println("Hit!\n\"You drew an Ace worth one card!\n" + "Card Total: " + playerCardTotal);
                        }
                        else if ( dealtCard != 0 )
                        {
                            System.out.println("Hit");
                            playerCardTotal += dealtCard + 1;
                            hand[i] = cardType[dealtCard];
                            System.out.println("You drew a " + cardType[dealtCard] + " of " + cardSuit + "!\n" + "Card Total is: " + playerCardTotal);
                        }
                    }
                    else if (input.equals ("stand"))
                    {
                        //Print Input
                        System.out.println("stand");
                        //give dealer random card
                        dealerCardTotal += rand.nextInt(12) + 1;
                        //Test Dealer's cards
                        if ( dealerCardTotal > 21 ) 
                        { 
                            System.out.println("Dealer busted!" + "\nYou Win!"); 
                            playerBalance += playerBet; 
                            break;
                        }
                        else if ( dealerCardTotal >= playerCardTotal ) 
                        { 
                            System.out.println("Dealer's card count is " +  dealerCardTotal + "!\n" + "You Lose!"); 
                            playerBalance -= playerBet; 
                            break;
                        }
                        else if ( playerCardTotal >= dealerCardTotal ) 
                        { 
                            System.out.println("Dealer's card count is " +  dealerCardTotal + "!\n" + "You Win!"); 
                            playerBalance += playerBet; 
                            break;
                        }   
                        else if ( dealerCardTotal == 21 ) 
                        { 
                            System.out.println("Dealer Wins!");  
                            playerBalance -= playerBet; 
                            break;
                        }
                    }
                    else if (input.equals("help"))
                    {
                        System.out.println("stand");
                        for( j = 0; j < i+1; j++)
                        {
                            if (!hand[j].equals(""))
                            {
                                System.out.println("Card at position " + j + " is a " + hand[j]);
                                i += -1;
                            }
                        }
                    }
                }
            }
        }
    }
}