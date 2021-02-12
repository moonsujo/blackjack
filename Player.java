import java.util.ArrayList;
//import java.util.Dictionary<K,V>;

/*Dictionary scoreDict = new Hashtable();
scoreDict.put(1, 1);
scoreDict.put(2, 2);
scoreDict.put(3, 3);
scoreDict.put(4, 4);
scoreDict.put("5", 5);
scoreDict.put("6", 6);
scoreDict.put("7", 7);
scoreDict.put("8", 8);
scoreDict.put("9", 9);
scoreDict.put("10", 10);
scoreDict.put("Jack", 10);
scoreDict.put("Queen", 10);
scoreDict.put("King", 10);*/

public class Player{
    private int score;
    private int score2;
    private int score3;
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
      score2 = 0;
      score3 = 0;

    }

    public ArrayList<String> getStringCards(){
      return stringCards;
    }

    public int getScore() {
      if(aceCount>0){

        score1 = score+10;
        if(){
          
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
}
