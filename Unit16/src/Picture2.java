import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture2 extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture2 ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture2(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
    System.out.println("Tyler Jones P2 4/24/18 CA-SU-F101-19");
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture2(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture2(Picture2 copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
    System.out.println("Tyler Jones P2 4/24/18 CA-SU-F101-19");
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture2(BufferedImage image)
  {
    super(image);
    System.out.println("Tyler Jones P2 4/24/18 CA-SU-F101-19");
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getBlue() > 160 && pixelObj.getGreen() < 170)
        {
        	pixelObj.setRed(pixelObj.getRed() + 200);
        }
      }
    }
  }
  
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  pixelObj.setRed((int)pixelObj.getAverage());
    	  pixelObj.setBlue((int)pixelObj.getAverage());
    	  pixelObj.setGreen((int)pixelObj.getAverage());
      }
    }
  }
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0); pixelObj.setGreen(0);
		  }
	  }
	  
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(255 - pixelObj.getRed());
			  pixelObj.setBlue(255 - pixelObj.getBlue());
			  pixelObj.setGreen(255 - pixelObj.getGreen());
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int len = pixels.length;
	  for (int row = 0; row < len / 2; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[len - 1 - row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  public void mirrorHorizontalBotToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int len = pixels.length;
	  for (int row = 0; row < len / 2; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[len - 1 - row][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
      count++;
    }
    System.out.println(count);
  }
  public void mirrorArms()
  {
    int mirrorPoint = 294;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 159; row < 197; row++)
    {
      for (int col = 102; col < mirrorPoint; col++)
      {
    	  pixels[row + 35][col].setRed(pixels[row][col].getRed());
    	  pixels[row + 35][col].setBlue(pixels[row][col].getBlue());
    	  pixels[row + 35][col].setGreen(pixels[row][col].getGreen());
      }
    }
  }
  
  public void blur(int x, int y, int w, int h)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] newpixels = pixels;

    for (int row = y; row < y + h; row++)
    {
      for (int col = x; col < x + w; col++)
      {
    	  if (row != pixels.length - 1 && row != 0)
    	  {
    		  if (col != pixels[row].length - 1 && col != 0)
    		  {
    			  int blurredav = (pixels[row + 1][col].getRed() + 
    					pixels[row - 1][col].getRed() + 
    					pixels[row][col + 1].getRed() +
    					pixels[row][col - 1].getRed()) / 4;
    			  int blurblueav = (pixels[row + 1][col].getBlue() + 
      					pixels[row - 1][col].getBlue() + 
      					pixels[row][col + 1].getBlue() +
      					pixels[row][col - 1].getBlue()) / 4;
    			  int blurgreenav = (pixels[row + 1][col].getGreen() + 
      					pixels[row - 1][col].getGreen() + 
      					pixels[row][col + 1].getGreen() +
      					pixels[row][col - 1].getGreen()) / 4;
    			  newpixels[row][col].setRed(blurredav);
    			  newpixels[row][col].setBlue(blurblueav);
    			  newpixels[row][col].setGreen(blurgreenav);
    		  }
    	  }
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 349;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 231; row < 322; row++)
    {
      for (int col = 234; col < mirrorPoint; col++)
      {
    	  pixels[row + 100][col + 150].setRed(pixels[row][col].getRed());
    	  pixels[row + 100][col + 150].setBlue(pixels[row][col].getBlue());
    	  pixels[row + 100][col + 150].setGreen(pixels[row][col].getGreen());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture2 fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  public void copy(Picture2 fromPic, int fR, int fC,  
          int startRow, int startCol)
{
Pixel fromPixel = null;
Pixel toPixel = null;
Pixel[][] toPixels = this.getPixels2D();
Pixel[][] fromPixels = fromPic.getPixels2D();
for (int fromRow = fR, toRow = startRow; 
  fromRow < fromPixels.length &&
  toRow < toPixels.length; 
  fromRow++, toRow++)
{
for (int fromCol = fC, toCol = startCol; 
    fromCol < fromPixels[0].length &&
    toCol < toPixels[0].length;  
    fromCol++, toCol++)
{
 fromPixel = fromPixels[fromRow][fromCol];
 toPixel = toPixels[toRow][toCol];
 toPixel.setColor(fromPixel.getColor());
}
}   
}

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture2 flower1 = new Picture2("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\flower1.jpg");
    Picture2 flower2 = new Picture2("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture2 flowerNoBlue = new Picture2(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\collage.jpg");
  }
  
  public void createMyCollage()
  {
    Picture2 flower1 = new Picture2("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\flower1.jpg");
    Picture2 flower2 = new Picture2("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\flower2.jpg");
    this.copy(flower1,50,50,0,0);
    this.copy(flower2,50,50,100,0);
    this.copy(flower1,20,20,200,0);
    Picture2 flowerNoBlue = new Picture2(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,40,40,300,0);
    this.copy(flower1,10,10,400,0);
    this.copy(flower2,5,5,500,0);
    this.mirrorVertical();
    this.write("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
        	if (row < pixels.length - 1)
        	{
            	if (pixels[row][col].colorDistance(pixels[row+1][col].getColor()) > edgeDist)
            	{
            		pixels[row][col].setColor(Color.BLACK);
            	}
            	else
            	{
                    leftPixel.setColor(Color.WHITE);
            	}
        	}
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture2 beach = new Picture2("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
