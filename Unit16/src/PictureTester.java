/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  public static void testGrayscale()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }
  
  public static void testEncodeDecode()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.Encoder();
    beach.explore();
    beach.Decoder().explore();
  }
  
  public static void testEncodeExample()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.encodetest(beach);
    beach.explore();
    beach.decodetest().explore();
  }
  
  public static void testFixUnderwater()
  {
    Picture beach = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\water.jpg");
    beach.explore();
    beach.fixUnderwater();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testBlur()
  {
    Picture2 caterpillar = new Picture2("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.blur(1, 1, 400, 400);
    caterpillar.explore();
  }
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
    Picture temple = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  
  public static void testMirrorGull()
  {
    Picture temple = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testCopy()
  {
    Picture canvas = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\640x480.jpg");
    canvas.createMyCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit16\\src\\images\\beach.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
	//testBlur();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testEncodeExample();
	  testEncodeDecode();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}