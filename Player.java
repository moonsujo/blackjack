import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.net.URL;


public class Player{
    private int score;
    private int score1;

    private int aceCount;
    private int startCount;

    private int[] scoreKey = {1,2,3,4,5,6,7,8,9,10,10,10,10};

    private String faces = "a23456789tjqk";
    private String suites = "shdc";

    //private int ace11score;
    private ArrayList<String> stringCards;
    private ArrayList<Card> hand;



    public Player(){
      score = 0;
      //cards = new ArrayList<Integer>();
      stringCards = new ArrayList<String>();
      aceCount = 0;
      score1 = 0;
      hand = new ArrayList<Card>();
    }

    public ArrayList<String> getStringCards(){
      return stringCards;
    }
    public ArrayList<Card> getCardsArrayList(){
      return hand;
    }
    public int getStartScore(){

      return startCount;
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
    public void add(int cardDrawn, int suiteDrawn) {
      //fix for array index



      if(cardDrawn == 0){
        aceCount++;
      }




      String imagePath = "cards/" + faces.charAt(cardDrawn) + suites.charAt(suiteDrawn) + ".gif";

      String cardPath = String.valueOf(faces.charAt(cardDrawn)) + String.valueOf(suites.charAt(suiteDrawn));
      stringCards.add(cardPath);
      int cardValue = scoreKey[cardDrawn];
      //save the value of the beginning card
      if(score == 0){
        startCount = cardValue;
      }
      score+=cardValue;

      ClassLoader cldr = this.getClass().getClassLoader();
      URL imageURL = cldr.getResource(imagePath);
      ImageIcon img = new ImageIcon(imageURL);
      Card card = new Card(img);
      hand.add(card);

    }
    public void reset(){
      aceCount = 0;
      score1 = 0;
      score = 0;

      stringCards.clear();
      hand.clear();


    }
}
