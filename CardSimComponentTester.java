//test the methods in card sim component.

public class CardSimComponentTester {
  public static void main(String[] args) {

    CardSimComponent component = new CardSimComponent();

    //test component after  it's constructed
    System.out.println("After constructor:");
    //System.out.println("player's score [exp: 0]: " + component.player.getScore());
    //System.out.println("player's score1 [exp: 0]: " + component.player.getScore());
    System.out.println("player's hand [exp: ()]: ");
    component.printPlayerCards("player");
    System.out.println();
    System.out.println("did the player win? [exp: 'This game resulted in a push']: " + component.displayWin());

    //player draws one card
    //0 = ace, 1 = two, ... 12 = king
    //0 = spades, 1 = hearts, 2 = diamonds, 3 = clubs
    System.out.println("Add a card to the player's hand:");
    component.manualAddCard("player",0,2); //ace of diamonds
    System.out.println("player's hand [exp: (ad)]: ");
    component.printPlayerCards("player");
    //test the win
    System.out.println("did the player win? [exp: 'win']: " + component.displayWin());


  }
}
