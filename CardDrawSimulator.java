

import java.util.Random;

public class CardDrawSimulator {

   private int totalCardCount;
   private int doublesCount;
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

   private Random generator;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CardDrawSimulator() {
      //initialize all private member variables
      //create a generator that will give us our random number associated with a coinflip

      generator = new Random();

      totalCardCount = 52;
      aceCount=4; //1
      twoCount=4; //2
      threeCount=4;  //3
      fourCount=4; ///4
      fiveCount=4;//5
      sixCount=4; //6
      sevenCount=4; //7
      eightCount=4; //8
      nineCount=4; //9
      tenCount=4; //10
      jackCount=4; //11
      queenCount=4; //12
      kingCount=4; //13


   }



   public int draw()
   {

     int cardResult = generator.nextInt(13)+1;
     totalCardCount--;
     if (cardResult == 1)
     {
       aceCount--;
     }
     else if (cardResult == 2)
     {
       twoCount--;
     }
     else if (cardResult == 3)
     {
       threeCount--;
     }
     else if (cardResult == 4)
     {
       fourCount--;
     }
     else if (cardResult == 5)
     {
       fiveCount--;
     }
     else if (cardResult == 6)
     {
       sixCount--;
     }
     else if (cardResult == 7)
     {
       sevenCount--;
     }
     else if (cardResult == 8)
     {
       eightCount--;
     }
     else if (cardResult == 9)
     {
       nineCount--;
     }
     else if (cardResult == 10)
     {
       tenCount--;
     }
     else if (cardResult == 11)
     {
       jackCount--;
     }
     else if (cardResult == 12)
     {
       queenCount--;
     }
     else if (cardResult == 13)
     {
       kingCount--;
     }
     return cardResult;

   }



   public int getNumCards() {
      //return the number of cards remaining
      return totalCardCount;
   }

   public int aceCount() {
      return aceCount;
   }

   public int twoCount() {
      return twoCount;
   }

   public int threeCount() {
      return threeCount;
   }

   public int fourCount() {
	  return fourCount;
   }

   public int fiveCount() {
	  return fiveCount;
   }

   public int sixCount() {
	  return sixCount;
   }

   public int sevenCount() {
      return sevenCount;
   }

   public int eightCount() {
	  return eightCount;
   }

   public int nineCount() {
	  return nineCount;
   }

   public int tenCount() {
      return tenCount;
   }

   public int jackCount() {
	  return jackCount;
   }

   public int queenCount() {
	  return queenCount;
   }

   public int kingCount() {
    return kingCount;
   }

   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset()
   {
      //reseting all private member variables
      totalCardCount = 52;
      aceCount=4;
      twoCount=4;
      threeCount=4;
      fourCount=4;
      fiveCount=4;
      sixCount=4;
      sevenCount=4;
      eightCount=4;
      nineCount=4;
      tenCount=4;
      jackCount=4;
      queenCount=4;
      kingCount=4;
   }

}
