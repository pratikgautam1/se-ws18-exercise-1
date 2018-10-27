import TinyTestJ.Test;

import java.util.Set;

import TinyTestJ.RunTests;

public class TestSuite {

  @Test public static void ImageTest1() {
    Image i = new Image(100,100);
    assert (i.data.length == 30000);
  }

  @Test public static void ImageTest2() {
    Image i = new Image(100,100);
    i.set(0,0,0x123456);
    assert (i.data[0] == (byte)0x12);
    assert (i.data[1] == (byte)0x34);
    assert (i.data[2] == (byte)0x56);
    assert (i.data[3] == (byte)0x00);
  }

  @Test public static void ImageTest3() {
    Image i = new Image(100,100);
    i.set(99,99,0x123456);
    int len = i.data.length;
    //assert (false);
    assert (i.data[29996] == (byte)0x00);
    assert (i.data[29997] == (byte)0x12);
    assert (i.data[29998] == (byte)0x34);
    assert (i.data[29999] == (byte)0x56);  
  }

  @Test public static void ImageTest4() throws java.io.FileNotFoundException,java.io.IOException {
    String filename = "test.ppm";
    Image i = new Image(100,100);
    i.write(filename);
    java.io.File f = new java.io.File(filename);
    boolean exists = f.exists() && f.isFile();
    assert (exists);
  }

  @Test public static void ImageTest5() throws java.io.InterruptedIOException,java.io.IOException {
	  String AddTest = "AdditionalTest.ppm";
	    Image i = new Image(100,100);
	    i.writeAddTest(AddTest);    	    
	    java.io.File f = new java.io.File(AddTest);	    
	    boolean exists = f.exists() && f.isFile();
	    assert (exists);  
  }
}
