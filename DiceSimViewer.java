


import javax.swing.JFrame;
import java.util.Scanner;

public class DiceSimViewer
{
   public static void main(String[] args)
   {
      //creating a new frame
      JFrame frame = new JFrame();
      //scanning for the input and verification of trials
      Scanner in = new Scanner(System.in);
      int trials = 0;
      int i = 0;
      while (i == 0)
      {
         System.out.println("Enter number of trials: ");
         trials = in.nextInt();
         if (trials > 0)
         {
            i++;
            //trials must be greater than 0 to break out of loop that asks for input 
         }
         else
         {
            //error message if number inputted is below 0
            System.out.println("ERROR: Number entered must be greater than 0.");
         }
         
         
      }
      
      //set intial the size of the frame 
      frame.setSize(1200, 800);
      frame.setTitle("Dice Simulator");
      //keep running until closed so bars are resized
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      //call the coinsim component with the parameter as the number of trials that was previously inputed
      DiceSimComponent component = new DiceSimComponent(trials);
      //add the component that was created above
      frame.add(component);
      
      frame.setVisible(true);
   }
}
