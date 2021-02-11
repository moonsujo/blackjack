

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private final int width;
   private final int heightInPixels;
   private final int bottom;
   private final int left;
   private final Color color;
   private static final Color STRING_COLOR = Color.BLACK;
   private final String label; 
   
   private int xLocationOfLabel;
   private int yLocationOfLabel;
   private int xLocationOfRect;
   private int yLocationOfRect;
   
   
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).
  
      @param bottom  location of the bottom bar
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label under the bar
   */
   public Bar(int bottom, int left, int width, int barHeight, 
              double scale, Color color, String label) 
   {
      //setting the inputs from the constructor of BAR equal to the 
      //the private member variables to be used in the draw class.
      this.bottom = bottom;
      this.left = left;
      this.width = width;
      this.color = color;
      this.label = label;
      
      //the scale needed to be multiplied by 100, rounded, and converted to int
      //to reduce the error since java double struggles with multiplication
      //due to the size of the number
      //this yields two decimal place precision.
      int iScale = (int) (Math.round(scale * 100)); 
      
      //set the height in pixels of the bar to the 
      //int barheight(percentage) multiplied by the converted int scale      
      //The product is then divided by 100 and rounded
      this.heightInPixels = (int) (Math.round((barHeight*iScale)/100));
      
   }
   
   /**
      Draw the labeled bar.
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) 
   {
      //Rectangle bar = new Rectangle(); 
      
      //code to get the width and height of the label text
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label, context);
      int widthOfLabel = (int) labelBounds.getWidth();
      int heightOfLabel = (int) labelBounds.getHeight();
      
      //the following two variables use the width and height of label
      //to determine the location at which the text is placed
      xLocationOfLabel = left + (width/2) - (widthOfLabel/2);
      yLocationOfLabel = bottom + heightOfLabel;
      
      //setting the color to string color so previous bar color does not
      //carry over
      g2.setColor(STRING_COLOR);   
      g2.drawString(label, xLocationOfLabel, yLocationOfLabel);
      
      //following two variables are for determining the top right corner 
      //of the rectangle which is the bar
      xLocationOfRect = left;
      yLocationOfRect = bottom - heightInPixels;
      
      //calling on a rectangle bar to be created at the calculated location above,
      //the inputted width, and the height of the bar based on the data value.
      Rectangle bar = new Rectangle(xLocationOfRect, yLocationOfRect, width, heightInPixels);
      
      //set the color to fill the bar and fill
      g2.setColor(color);
      g2.fill(bar);
      

   }
}
