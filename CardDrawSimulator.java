

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


   private int[] scoreKey = {1,2,3,4,5,6,7,8,9,10,10,10,10};
   private int[][] deck;

   private Random generator;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CardDrawSimulator() {
      //initialize all private member variables
      //create a generator that will give us our random number associated with a coinflip

      generator = new Random();

      deck = new int[13][4];
      for (int i = 0; i < 13; i++) {
        for (int j = 0; j < 4; j++) {
          deck[i][j] = 1;
        }
      }
      totalCardCount = 52;

   }



   public int[] draw(){
     //while the deck is not empty
     //for i < length of deck
     //iterate through index of deck
     //if index is 0
     //remove the element in that index
     //keep picking if no more suits of that type

     boolean cardValid = false;
     int cardResult=0;
     int suiteResult=0;
     while (cardValid == false){
       cardResult = generator.nextInt(13);
       suiteResult = generator.nextInt(4);
       if (deck[cardResult][suiteResult] == 0) {
         continue;
       }
       else {
         cardValid = true;
         totalCardCount--;
         deck[cardResult][suiteResult]=0;
       }
     }



     int[] numberAndSuite = {cardResult, suiteResult};
     return numberAndSuite;

   }



   public int getNumCards() {
      //return the number of cards remaining
      return totalCardCount;
   }

   public int getCardTypeCount(int card){
     int suiteCount = 0;
     for(int i = 0; i<4; i++){
       suiteCount += deck[card][i];
     }
     return suiteCount;
   }


   public int getNumCardsLessThan(int value) {
      //return the number of cards remaining
      //value is the difference to get 21
      int cardCount=0;
      if(value>10){
        //all cards should give 21 or under
        return totalCardCount;
      }
      else{
        for(int i=0; i<value; i++){
          cardCount+=getCardTypeCount(i);
        }
        return cardCount;
      }

   }
   /*
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset()
   {

      for (int i = 0; i < 13; i++) {
        for (int j = 0; j < 4; j++) {
          deck[i][j] = 1;
        }
      }
      totalCardCount = 52;

   }

}
