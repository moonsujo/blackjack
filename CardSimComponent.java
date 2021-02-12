

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
   This component draws two car shapes.

   Note: this version modified from textbook version.  It is instrumented
   so as you run the program it indicates in the console window every time
   paintComponent gets called.
*/
public class CardSimComponent extends JComponent
{

   // added instance variable for instrumentation
   private int callCount;
   private int totalCardCount;

   private int aceCount;
   private int twoCount;
   private int threeCount;
   private int fourCount;
   private int fiveCount;
   private int sixCount;
   private int sevenCount;
   private int eightCount;
   private int nineCount;
   private int tenCount;
   private int jackCount;
   private int queenCount;
   private int kingCount;

   private int aceCountPercent;
   private int twoCountPercent;
   private int threeCountPercent;
   private int fourCountPercent;
   private int fiveCountPercent;
   private int sixCountPercent;
   private int sevenCountPercent;
   private int eightCountPercent;
   private int nineCountPercent;
   private int tenCountPercent;
   private int jackCountPercent;
   private int queenCountPercent;
   private int kingCountPercent;

   private Player player;
   private Player dealer;
   private ArrayList<String> cards;

   private CardDrawSimulator simulator;

   // added constructor for instrumentation
   // Note: for old version without instance variables an empty default
   // constructor didn't need to be defined explicitly (see:
   // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
   // for rules about this)

   //play game
   //expand with game functions
   public CardSimComponent() {
      callCount = 0;
      simulator = new CardDrawSimulator();
      player = new Player();
      dealer = new Player();

   }

   public void hit(String playerType) {
     if(playerType=="player"){
       int cardDrawn = simulator.draw();
       player.add(cardDrawn);
     }
     else{
       int cardDrawn = simulator.draw();
       dealer.add(cardDrawn);
     }

   }

   public int getPlayer1Score() {
     return player.getScore();
   }

   public int getDealerScore() {
     return dealer.getScore();
   }

   public String getPlayerCards(String playerType) {
     if(playerType=="player"){
       cards = player.getStringCards();
     }

     else{
       cards = dealer.getStringCards();
     }
     String hand = "(";
     for(int i=0; i<cards.size(); i++){
       hand+=cards.get(i);
       hand+="  ";
     }
     hand+=")";
     return hand;
   }

   public void reset() {
     simulator.reset();
     player.reset();
     dealer.reset();
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;


      // the following two lines are for instrumentation
      callCount++;
      System.out.println("Called paintComponent(" + callCount + ")");

      totalCardCount = simulator.getNumCards();
      //calculating the percentages of each outcome possibility
      //for label display purpose
      aceCount = simulator.aceCount();
      aceCountPercent = (int) Math.round((aceCount*100)/totalCardCount);

      twoCount = simulator.twoCount();
      twoCountPercent = (int) Math.round((twoCount*100)/totalCardCount);

      threeCount = simulator.threeCount();
      threeCountPercent = (int) Math.round((threeCount*100)/totalCardCount);

      fourCount = simulator.fourCount();
      fourCountPercent = (int) Math.round((fourCount*100)/totalCardCount);

      fiveCount = simulator.fiveCount();
      fiveCountPercent = (int) Math.round((fiveCount*100)/totalCardCount);

      sixCount = simulator.sixCount();
      sixCountPercent = (int) Math.round((sixCount*100)/totalCardCount);

      sevenCount = simulator.sevenCount();
      sevenCountPercent = (int) Math.round((sevenCount*100)/totalCardCount);

      eightCount = simulator.eightCount();
      eightCountPercent = (int) Math.round((eightCount*100)/totalCardCount);

      nineCount = simulator.nineCount();
      nineCountPercent = (int) Math.round((nineCount*100)/totalCardCount);

      tenCount = simulator.tenCount();
      tenCountPercent = (int) Math.round((tenCount*100)/totalCardCount);

      jackCount = simulator.jackCount();
      jackCountPercent = (int) Math.round((jackCount*100)/totalCardCount);

      queenCount = simulator.queenCount();
      queenCountPercent = (int) Math.round((queenCount*100)/totalCardCount);

      kingCount = simulator.kingCount();
      kingCountPercent = (int) Math.round((kingCount*100)/totalCardCount);

      //probability
      int score = player.getScore();
      int difference = 21-score;
      int hitCount = simulator.getNumCardsLessThan(difference);
      int hitPercent = (int) Math.round((hitCount*100)/totalCardCount);
      int stayCount = totalCardCount-hitCount;
      int stayPercent = (int) Math.round((stayCount*100)/totalCardCount);


      int widthBuffer = 20;
      int heightBuffer = 20;
      int width = 20;

      int rowHeight = (getHeight() - (heightBuffer*4))/3;

      int bottomRow1 = heightBuffer + rowHeight;
      int bottomRow2 = (2 * heightBuffer) + (2*rowHeight);
      int bottomRow3 = (3 * heightBuffer) + (3*rowHeight);
      double scale = (rowHeight)*.01;
      //double scaleSecondRow

      //ace probability
      int left = ((getWidth()/7)) - (width/2); //specifying x value of left side of bar
      int barHeight = aceCountPercent; //two tails percent set to barheight
      Color color = Color.BLUE; //change color to blue
      String label1 = "Ace's Count: " + aceCount + " (" + aceCountPercent+ "%)";
      //calling third bar to be drawn
      Bar barAce = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      barAce.draw(g2);

      left = ((2*getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = twoCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Two's Count: " + twoCount + " (" + twoCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar2 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      bar2.draw(g2);


      left = (3*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = threeCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Three's Count: " + threeCount + " (" + threeCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar3 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      bar3.draw(g2);


      left = (4*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = fourCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Four's Count: " + fourCount + " (" + fourCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar4 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      bar4.draw(g2);


      left = (5*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = fiveCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Five's Count: " + fiveCount + " (" + fiveCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar5 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      bar5.draw(g2);

      left = (6*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = sixCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Six's Count: " + sixCount + " (" + sixCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar6 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);

      bar6.draw(g2);

      // ROW 2 -------------------------------------------------------------------

      left = ((getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = sevenCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Seven's Count: " + sevenCount + " (" + sevenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar7 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      bar7.draw(g2);



      left = (2*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = eightCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Eight's Count: " + eightCount + " (" + eightCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar8 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      bar8.draw(g2);


      left = (3*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = nineCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Nine's Count: " + nineCount + " (" + nineCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar9 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      bar9.draw(g2);


      left = ((4*getWidth())/7) - (width/2); //specifying x value of left side of bar
      barHeight = tenCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Ten's Count: " + tenCount + " (" + tenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar10 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      bar10.draw(g2);


      left = (5*(getWidth())/7) - (width/2); //specifying x value of left side of bar
      barHeight = jackCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Jack Count: " + jackCount + " (" + jackCountPercent+ "%)";
      //calling third bar to be drawn
      Bar barJack = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      barJack.draw(g2);


      left = (6*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = queenCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Queen's Count: " + queenCount + " (" + queenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar barQueen = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);

      barQueen.draw(g2);

      // ROW 3 -------------------------------------------------------------------

      left = (1*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = kingCountPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "King's Count: " + kingCount + " (" + kingCountPercent+ "%)";
      //calling third bar to be drawn
      Bar barKing = new Bar(bottomRow3, left, width, barHeight, scale, color, label1);

      barKing.draw(g2);

      left = (2*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = hitPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Hit card's Count: " + hitCount + " (" + hitPercent+ "%)";
      //calling third bar to be drawn
      Bar barHit = new Bar(bottomRow3, left, width, barHeight, scale, color, label1);

      barHit.draw(g2);

      left = (3*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = stayPercent; //two tails percent set to barheight
      color = Color.BLUE; //change color to blue
      label1 = "Stay card's Count: " + stayCount + " (" + stayPercent+ "%)";
      //calling third bar to be drawn
      Bar barStay = new Bar(bottomRow3, left, width, barHeight, scale, color, label1);

      barStay.draw(g2);
   }
}
