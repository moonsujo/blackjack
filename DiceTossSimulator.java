

import java.util.Random;

public class DiceTossSimulator {

   private int totalTrialCount;
   private int doublesCount;
   
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
   
   
   private Random generator;
   
   
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public DiceTossSimulator() {
      //initialize all private member variables 
      //create a generator that will give us our random number associated with a coinflip
      totalTrialCount = 0;
      generator = new Random();
      twoCount=0;
      threeCount=0;
      fourCount=0;
      fiveCount=0;
      sixCount=0;
      sevenCount=0;
      eightCount=0;
      nineCount=0;
      tenCount=0;
      elevenCount=0;
      twelveCount=0;
      
      doublesCount=0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) 
   {
      totalTrialCount = totalTrialCount + numTrials;
      
      for (int i = 1; i <= numTrials; i++) 
      {
         int diceResult1 = generator.nextInt(6)+1;
         int diceResult2 = generator.nextInt(6)+1;
         int diceSum = diceResult1 + diceResult2;
         
         if (diceResult1 == diceResult2)
         {
            doublesCount++;
         }
         
         if (diceSum == 2)
         {
            twoCount++;
         }
         
         if (diceSum == 3)
         {
            threeCount++;
         }
         
         if (diceSum == 4)
         {
            fourCount++;
         }
         
         if (diceSum == 5)
         {
            fiveCount++;
         }
         
         if (diceSum == 6)
         {
            sixCount++;
         }
         
         if (diceSum == 7)
         {
            sevenCount++;
         }
         
         if (diceSum == 8)
         {
            eightCount++;
         }
         
         if (diceSum == 9)
         {
            nineCount++;
         }
         
         if (diceSum == 10)
         {
            tenCount++;
         }
         
         if (diceSum == 11)
         {
            elevenCount++;
         }
         
         if (diceSum == 12)
         {
            twelveCount++;
         }
      }
      
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
      //return the number of trials that were run
      return totalTrialCount;
   }

   public int doublesCount() {
      return doublesCount;   
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
   
   public int elevenCount() {
	  return elevenCount; 
   }

   public int twelveCount() {  
	  return twelveCount; 
   }
   
   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() 
   {
      //reseting all private member variables
      totalTrialCount = 0;
      twoCount=0;
      threeCount=0;
      fourCount=0;
      fiveCount=0;
      sixCount=0;
      sevenCount=0;
      eightCount=0;
      nineCount=0;
      tenCount=0;
      elevenCount=0;
      twelveCount=0;
      doublesCount=0;
   }

}
