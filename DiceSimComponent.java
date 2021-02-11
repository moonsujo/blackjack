


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
public class DiceSimComponent extends JComponent
{  

   // added instance variable for instrumentation
   private int callCount;
   private int totalTrials;
   
   private int twoCount;
   private int threeCount;
   private int fourCount;
   private int fiveCount;
   private int sixCount;
   private int sevenCount;
   private int eightCount;
   private int nineCount;
   private int tenCount;
   private int elevenCount;
   private int twelveCount;
   private int doublesCount;
   private int singlesCount;

   
   private int twoCountPercent;
   private int threeCountPercent;
   private int fourCountPercent;
   private int fiveCountPercent;
   private int sixCountPercent;
   private int sevenCountPercent;
   private int eightCountPercent;
   private int nineCountPercent;
   private int tenCountPercent;
   private int elevenCountPercent;
   private int twelveCountPercent;
   private int doublesCountPercent;
   private int singlesCountPercent;
   
   // added constructor for instrumentation 
   // Note: for old version without instance variables an empty default 
   // constructor didn't need to be defined explicitly (see:
   // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
   // for rules about this)
   public DiceSimComponent(int trials) {
      callCount = 0;
      totalTrials = trials;
      
      //calling the simulator and running it the specified trials passed through
      
      DiceTossSimulator Simulator = new DiceTossSimulator();
      Simulator.run(totalTrials);
      
      //calculating the percentages of each outcome possibility
      //for label display purpose
      doublesCount = Simulator.doublesCount();
      doublesCountPercent = (int) Math.round((Simulator.doublesCount()*100)/totalTrials);
      
      singlesCount = totalTrials-doublesCount;
      singlesCountPercent = (int) Math.round((singlesCount*100)/totalTrials);
      
      
      twoCount = Simulator.twoCount();
      twoCountPercent = (int) Math.round((Simulator.twoCount()*100)/totalTrials);
      
      threeCount = Simulator.threeCount();
      threeCountPercent = (int) Math.round((Simulator.threeCount()*100)/totalTrials);
      
      fourCount = Simulator.fourCount();
      fourCountPercent = (int) Math.round((Simulator.fourCount()*100)/totalTrials);
      
      fiveCount = Simulator.fiveCount();
      fiveCountPercent = (int) Math.round((Simulator.fiveCount()*100)/totalTrials);
      
      sixCount = Simulator.sixCount();
      sixCountPercent = (int) Math.round((Simulator.sixCount()*100)/totalTrials);
      
      sevenCount = Simulator.sevenCount();
      sevenCountPercent = (int) Math.round((Simulator.sevenCount()*100)/totalTrials);
      
      eightCount = Simulator.eightCount();
      eightCountPercent = (int) Math.round((Simulator.eightCount()*100)/totalTrials);
      
      nineCount = Simulator.nineCount();
      nineCountPercent = (int) Math.round((Simulator.nineCount()*100)/totalTrials);
      
      tenCount = Simulator.tenCount();
      tenCountPercent = (int) Math.round((Simulator.tenCount()*100)/totalTrials);
      
      elevenCount = Simulator.eightCount();
      elevenCountPercent = (int) Math.round((Simulator.elevenCount()*100)/totalTrials);
      
      twelveCount = Simulator.nineCount();
      twelveCountPercent = (int) Math.round((Simulator.twelveCount()*100)/totalTrials);
      
   }
   
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
           
      // the following two lines are for instrumentation
      callCount++;
      System.out.println("Called paintComponent(" + callCount + ")");
      
      
      //Bar location calculations
      
      
      int widthBuffer = 20;
      int heightBuffer = 20;
      int width = 20;
      
      int rowHeight = (getHeight() - (heightBuffer*4))/3;
      
      int bottomRow1 = heightBuffer + rowHeight;
      int bottomRow2 = heightBuffer + (2*rowHeight);
      int bottomRow3 = heightBuffer + (3*rowHeight);
      double scale = (rowHeight)*.01;
      //double scaleSecondRow
      
      
      //Doubles
      int left = (getWidth()/3) - (width/2);   //calculate the x value of left side of bar 
      int barHeight = doublesCountPercent;    //specify the barheight to be the two head percent calculated earlier
      Color color = Color.RED;   //specify the input color
      String label1 = "Doubles: " + doublesCount + " (" + doublesCountPercent+ "%)"; //label
      
      //calling the bar file with the parameters specified in the bar constructor
      Bar bar1 = new Bar(bottomRow3, left, width, barHeight, scale, color, label1);
      
      bar1.draw(g2);
      
      
      //Non Doubles
      left = (2*(getWidth()/3)) - (width/2); //specifying second bar left x value
      barHeight = singlesCountPercent; //specifying the bar heigh to the head tail percent 
      color = Color.GREEN; //changing the color to green
      label1 = "Non-Doubles Count: " + singlesCount + " (" + singlesCountPercent+ "%)"; //label
      //calling the bar file with parameters in the bar constructor 
      Bar bar2 = new Bar(bottomRow3, left, width, barHeight, scale, color, label1);
     
      bar2.draw(g2);
      
      
      //two probability
      left = ((getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = twoCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Two's Count: " + twoCount + " (" + twoCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar3 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar3.draw(g2);
      
    //two probability
      left = (2*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = threeCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Three's Count: " + threeCount + " (" + threeCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar4 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar4.draw(g2);
      
    //two probability
      left = (3*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = fourCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Four's Count: " + fourCount + " (" + fourCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar5 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar5.draw(g2);
      
    //two probability
      left = (4*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = fiveCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Five's Count: " + fiveCount + " (" + fiveCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar6 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar6.draw(g2);
      
    //two probability
      left = (5*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = sixCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Six's Count: " + sixCount + " (" + sixCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar7 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar7.draw(g2);
      
    //two probability
      left = (6*(getWidth()/7)) - (width/2); //specifying x value of left side of bar
      barHeight = sevenCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Seven's Count: " + sevenCount + " (" + sevenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar8 = new Bar(bottomRow1, left, width, barHeight, scale, color, label1);
     
      bar8.draw(g2);
      
      // ROW 2 -------------------------------------------------------------------
    //two probability
      left = ((getWidth()/6)) - (width/2); //specifying x value of left side of bar
      barHeight = eightCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Eight's Count: " + eightCount + " (" + eightCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar9 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);
     
      bar9.draw(g2);
      
    //two probability
      left = ((getWidth()/3)) - (width/2); //specifying x value of left side of bar
      barHeight = nineCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Nine's Count: " + nineCount + " (" + nineCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar10 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);
     
      bar10.draw(g2);
      
    //two probability
      left = ((getWidth()/2)) - (width/2); //specifying x value of left side of bar
      barHeight = tenCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Ten's Count: " + tenCount + " (" + tenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar11 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);
     
      bar11.draw(g2);
      
    //two probability
      left = (2*(getWidth()/3)) - (width/2); //specifying x value of left side of bar
      barHeight = elevenCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Eleven's Count: " + elevenCount + " (" + elevenCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar12 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);
     
      bar12.draw(g2);
      
    //two probability
      left = (5*(getWidth()/6)) - (width/2); //specifying x value of left side of bar
      barHeight = twelveCountPercent; //two tails percent set to barheight 
      color = Color.BLUE; //change color to blue
      label1 = "Twelve's Count: " + twelveCount + " (" + twelveCountPercent+ "%)";
      //calling third bar to be drawn
      Bar bar13 = new Bar(bottomRow2, left, width, barHeight, scale, color, label1);
     
      bar13.draw(g2);
   }
}
