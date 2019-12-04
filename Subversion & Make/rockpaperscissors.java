import java.util.Scanner;

public class rockpaperscissors {

    public static void main(String[] args) {

        String userinput1;
        String userinput2;
        String input;
        char replay; 

        Scanner scanner = new Scanner(System.in);

        do{
        System.out.print("You are player1, Enter Rock, Scissors or Paper: ");
        userinput1 = scanner.nextLine();

        System.out.print("You are player2, Enter Rock, Scissors or Paper: ");
         userinput2 = scanner.nextLine();

         
        System.out.println(gameplay(userinput1, userinput2));

        
        System.out.println("Do you want to play again? Enter Y or N: "); 
        input = scanner.nextLine();
        replay = input.charAt(0);

        } while (replay == 'Y' || replay == 'y');
 
    }

    public static String gameplay(String userinput1, String userinput2) {
        String winner = " ";
        String a1 = "Rock";
        String a2 = "Scissors";
        String a3 = "Paper";

        
        if ((userinput1.equals(a1) && userinput2.equals(a2)) || (userinput1 .equals(a3) && userinput2.equals(a1)) || (userinput1.equals(a2) && userinput2.equals(a3)))
        {
            winner = "Player 1 win";
        } 
        else if ((userinput1.equals(a1) && userinput2.equals(a3)) || (userinput1.equals(a3) && userinput2.equals(a2)) || (userinput1.equals(a2) && userinput2.equals(a1))) 
        {
            winner = "Player 2 win";
            
        } 
        else if (userinput1.equals(userinput2))
        {
            winner = "Tie";  
        }

        return winner;

    }
}









