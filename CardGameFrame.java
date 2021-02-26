import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.Scanner;
import java.lang.Character;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardGameFrame extends JFrame{
  public CardGameFrame(){

    setVisible(true);
    CardSimComponent component = new CardSimComponent();
    add(component);
    MouseListener listener = new MousePressListener();
    component.addMouseListener(listener);
    setSize(1200, 800);

    Scanner in = new Scanner(System.in);

    char userInput = 'y';
    while (userInput == 'y') {
      System.out.println("Welcome to Black Jack!");

      // starting the game
      // frame.setVisible(false);
      component.hit("player");
      component.hit("dealer");
      component.hit("player");
      component.hit("dealer");
      // frame.setVisible(true);

      repaint();
      // player's turn

      System.out.println("Player: " + component.getPlayer1Score());

      while (component.getPlayer1Score() < 21) {
        // ask the player if he wants to hit

        System.out.println("Player 1... hit or pass?  Enter [y/n]");
        char reply = in.next().charAt(0);
        if (Character.toLowerCase(reply) == 'y') {
          // frame.setVisible(false);
          component.hit("player");

          System.out.println("Player: " + component.getPlayer1Score());
          // frame.setVisible(true);
          repaint();

        }
        else {

          //create a way to pass player is done parameter into the component
          break;

        }
      }
      component.updateTurn();


      // if he busted, the dealer wins
      // else, dealer's turn

      // dealer's turn
      // he hits until his score is 16 or lower

      System.out.println("Dealer: " + component.getDealerScore());
      while (component.getDealerScore() < 17 && component.getPlayer1Score() < 22) {


        component.hit("dealer");
        //frame.setVisible(true);
        repaint();

        System.out.println("Dealer: " + component.getDealerScore());

      }


      // frame.setVisible(false);
      // frame.setVisible(true);



      System.out.println("Dealer: " + component.getDealerScore());
      System.out.println("Player: " + component.getPlayer1Score());
      // declare who won
      component.updateStatus();
      repaint();
      System.out.println("Wanna play again?? [y/n]");
      userInput = in.next().charAt(0);
      component.reset();
      // frame.setVisible(false);

    }

    dispose();
    // draw twice each one by one for player 1 and the dealer
    // coinsimcomponent draw
    // scores kept track of in card sim viewer
    // while loop keeps calling probability

    // add the component that was created above

  }




  class MousePressListener implements MouseListener{
    public void mousePressed(MouseEvent event){}
    public void mouseReleased(MouseEvent event) {}
    public void mouseClicked(MouseEvent event) {
      int x = event.getX();
      int y = event.getY();
    }
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
  }







}
