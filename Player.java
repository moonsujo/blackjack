import java.util.ArrayList;
//import java.util.Dictionary<K,V>;



public class Player{
    private int score;
    private int score1;

    private int aceCount;

    private int[] scoreKey = {1,2,3,4,5,6,7,8,9,10,10,10,10};
    private String[] stringKey = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    //private int ace11score;
    private ArrayList<String> stringCards;



    public Player(){
      score = 0;
      //cards = new ArrayList<Integer>();
      stringCards = new ArrayList<String>();
      aceCount = 0;
      score1 = 0;


    }

    public ArrayList<String> getStringCards(){
      return stringCards;
    }

    public int getScore() {
      //creating second score option by counting one ace as 11
      if(aceCount>0){
        score1 = score+10;
        if(score1==21){
          return score1;
        }
        else{
          //if the higher value of the ace option is not bust
          if(score1<21){
            return score1;
          }
          else{
            //if the higher value of ace option busts
            return score;
          }
        }
      }
      return score;

      //find the greatest score that is under 21
    }
    public void add(int cardDrawn) {
      //fix for array index
      cardDrawn -= 1;

      String cardName = stringKey[cardDrawn];
      if(cardName == "Ace"){
        aceCount++;
      }
      stringCards.add(cardName);
      int cardValue = scoreKey[cardDrawn];
      score+=cardValue;


    }
    public void reset(){
      aceCount = 0;
      score1 = 0;
      score = 0;

      stringCards.clear();


    }
}
