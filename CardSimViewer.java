

import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Scanner;
import java.lang.Character;



public class CardSimViewer
{


   public static void main(String[] args)
   {
      //creating a new frame
      JFrame frame = new JFrame();
      //this is where the user interacts with the program

      //set intial the size of the frame
      frame.setSize(1200, 800);
      frame.setTitle("Blackjack Simulator");
      //keep running until closed so bars are resized

      Scanner in = new Scanner(System.in);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //call the coinsim component with the parameter as the number of trials that was previously inputed

      CardSimComponent component = new CardSimComponent();
      frame.add(component);
      frame.setVisible(true);


      char userInput = 'y';
      while(userInput == 'y'){
        System.out.println("Welcome to Black Jack!");
        frame.setVisible(true);
        //starting the game
        component.hit("player");
        component.hit("dealer");
        component.hit("player");
        component.hit("dealer");

        //player's turn

        System.out.println("Player: " + component.getPlayer1Score());

        while(component.getPlayer1Score() < 21){
            //ask the player if he wants to hit

            System.out.println("Player 1... hit or pass?  Enter [y/n]");
            char reply = in.next().charAt(0);
            if (Character.toLowerCase(reply) == 'y') {
                frame.setVisible(false);
                component.hit("player");

                System.out.println("Player: " + component.getPlayer1Score());
                frame.setVisible(true);

            }
            else{
              break;
            }
        }

        //if he busted, the dealer wins
        //else, dealer's turn

        //dealer's turn
        //he hits until his score is 16 or lower

        System.out.println("Dealer: " + component.getDealerScore());
        while(component.getDealerScore()<17 && component.getPlayer1Score()<22){

          if (component.getDealerScore()<17){
            component.hit("dealer");

            System.out.println("Dealer: " + component.getDealerScore());
          }
        }

      
        System.out.println("Dealer: " + component.getDealerScore());
        System.out.println("Player: " + component.getPlayer1Score());
        //declare who won


        System.out.println("Wanna play again?? [y/n]");
        userInput = in.next().charAt(0);
        component.reset();
        frame.setVisible(false);
      }


      frame.dispose();
      //draw twice each one by one for player 1 and the dealer
      //coinsimcomponent draw
      //scores kept track of in card sim viewer
      //while loop keeps calling probability



      //add the component that was created above





   }
}
