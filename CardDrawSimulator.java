

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
   private int[] deck;

   private Random generator;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CardDrawSimulator() {
      //initialize all private member variables
      //create a generator that will give us our random number associated with a coinflip

      generator = new Random();
      deck = new int[13];
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

      deck[0]=aceCount;
      deck[1]=twoCount;
      deck[2]=threeCount;
      deck[3]=fourCount;
      deck[4]=fiveCount;
      deck[5]=sixCount;
      deck[6]=sevenCount;
      deck[7]=eightCount;
      deck[8]=nineCount;
      deck[9]=tenCount;
      deck[10]=jackCount;
      deck[11]=queenCount;
      deck[12]=kingCount;
      //deck = {aceCount, twoCount, threeCount, fourCount, fiveCount, sixCount, sevenCount, eightCount, nineCount, tenCount, jackCount, queenCount, kingCount};

   }



   public int draw()
   {
     //while the deck is not empty
     //for i < length of deck
     //iterate through index of deck
     //if index is 0
     //remove the element in that index

     int cardResult = generator.nextInt(13);
     //keep picking if no more suits of that type
     while(deck[cardResult] == 0) {
       cardResult = generator.nextInt(13);
     }

     totalCardCount--;

     deck[cardResult]--;

     return cardResult+1;

   }



   public int getNumCards() {
      //return the number of cards remaining
      return totalCardCount;
   }

   public int aceCount() {

      return deck[0];
   }

   public int twoCount() {
      return deck[1];
   }

   public int threeCount() {
      return deck[2];
   }

   public int fourCount() {
	  return deck[3];
   }

   public int fiveCount() {
	  return deck[4];
   }

   public int sixCount() {
	  return deck[5];
   }

   public int sevenCount() {
      return deck[6];
   }

   public int eightCount() {
	  return deck[7];
   }

   public int nineCount() {
	  return deck[8];
   }

   public int tenCount() {
      return deck[9];
   }

   public int jackCount() {
	  return deck[10];
   }

   public int queenCount() {
	  return deck[11];
   }

   public int kingCount() {
    return deck[12];
   }


   public int[] getDeck() {
      //return the number of cards remaining
      return deck;
   }

   public int getNumCardsLessThan(int value) {
      //return the number of cards remaining
      //value is the difference to get 21
      int cardCount=0;
      if(value>10){
        //all cards should give 21 or under
        return totalCardCount;
      }
      else if(value>9){
        //10
        cardCount = totalCardCount-aceCount;
      }
      else if(value<=9)
      for(int i=1; i<value; i++){
        cardCount+=deck[i];
      }
      return cardCount;
   }
   /*
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

      deck[0]=aceCount;
      deck[1]=twoCount;
      deck[2]=threeCount;
      deck[3]=fourCount;
      deck[4]=fiveCount;
      deck[5]=sixCount;
      deck[6]=sevenCount;
      deck[7]=eightCount;
      deck[8]=nineCount;
      deck[9]=tenCount;
      deck[10]=jackCount;
      deck[11]=queenCount;
      deck[12]=kingCount;
   }

}
