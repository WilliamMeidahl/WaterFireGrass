// Her har vi bare addet nogle ting til Dokumentet
import java.util.Scanner;

import sun.awt.Win32ColorModel24;

import java.util.List;
import java.util.ArrayList; 
import java.util.Random;
class Simple{
    /* Her laver vi nogle static Strings så det ser pænere
    ud og man ikke skal ændre alle tingene, men bare ændre 3 ord,
    så man kunne lave det til Water, Fire Grass istedet for Rock, paper scissors */
    static String rock = "water";
    static String paper = "grass";
    static String scissors = "fire";
    /*Her laver vi static Strings. Grundet til de er static er pga 
    methoden er static*/
    static String win = "You've won!";
    static String tie = "You've tied!";
    static String lose = "You've lost!";

    public static void main(String args[]){
        System.out.println(String.format("This is Williams %s, %s, %s game!", rock, paper, scissors));
        Random rand = new Random();
        //Vi laver en ny liste som kan modtage strings
        //I java kalder man den altid ArrayList
        List<String> list = new ArrayList<>();
        // Vi laver en score så man kan se hvad den står
        int humanScore = 0;
        int computerScore = 0;
        // Vi laver en liste så computeren ved hvad den kan vælge imellem
        list.add(rock);
        list.add(paper);
        list.add(scissors);
        Scanner scanner = new Scanner(System.in);
        // Vi laver et while loop som betyder at den bliver ved med at køre
        while(true){
            // %s betyder at den tar den første string som vi har skrevet til højre og sætter den ind i stedet for
            System.out.println(String.format("Please pick either %s, %s or %s!", rock, paper, scissors));
            // Her gør vi så Spilleren kan skrive sit ord
            String action = scanner.next();
            /* action.toLowerCase betyder at vi gør alle
            bogstaverne små istedet for store */ 
            String actionLowerCase = action.toLowerCase();
            // Hvis listen indeholder brugerindputet i små bogstaver så går den ind 
            // i if sætningen
            if(list.contains(actionLowerCase)){
            //    Her laver vi en random generator så computeren også kan vælge imellem de 3 ting
            //    NextInt tager et input som her er 3(Størrelsen af listen), uf fra det giver den en af værdierne 0,1,2.
               String computerAction = list.get(rand.nextInt(list.size()));
                System.out.println("The computer picked "+ computerAction + "!");
                
                Result result = compareActions(actionLowerCase, computerAction);

                // Både if else og switch casen udføre den samme logik.
                
                // if(result.equals(Result.TIE)){
                //     System.out.println(tie);
                // }
                // else if(result.equals(Result.WIN)){
                //     System.out.println(win);
                //     humanScore++;
                // }
                // else if(result.equals(Result.LOSE)){
                //     System.out.println(lose);
                //     computerScore++; 
                // }
                switch(result) {
                    case WIN:
                        System.out.println(win);
                        humanScore++;
                        break;
                    case LOSE:
                        System.out.println(lose);
                        computerScore++; 
                        break;
                    default:
                        System.out.println(tie);
                        break;
                  }

                  System.out.println(String.format("Your score %s | Computers score %s", humanScore, computerScore));
            }
            else{
                System.out.println(String.format("I just told you to write %s, %s or %s!!!!", rock, paper, scissors));
            }
        }
    }
 
    private static Result compareActions(String user, String computer){
        if(user.equals(computer)){
            return Result.TIE;
        }
        if( user.equals(rock) && computer.equals(scissors) || user.equals(scissors) && computer.equals(paper) ||  user.equals(paper) && computer.equals(rock)){
            return Result.WIN;
        }
        return Result.LOSE;
    }
    // En måde at lave kategorier på. Så i dette tilfælde har vi resultaterne WIN, LOSE, TIE
    enum Result {
        WIN,
        LOSE,
        TIE
    }
}