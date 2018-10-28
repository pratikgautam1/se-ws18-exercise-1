

import java.io.FileOutputStream;
import java.io.IOException;


public class Image {	
	int width, height, val, position;
	// byte array to hold the raw image data
	byte[] data;

	//constructor to create image object with specified height and width
	public Image(int width,int height) {
		this.width = width;
		this.height = height;
		this.data = new byte[width*height*3];
	}

	//sets method to set the rgb values to single pixel
	public void set(int x, int y, int val) {
		//evaluate at runtime
		assert(val< 0x1000000);
		//3 bytes per pixel throughout the width 
		position=x*width*3+y*3;
		//colors pixels with lower 24 bit rgb
		data[position]=(byte)((val &  0xFF0000)>>16); 
		data[position+1]=(byte)((val & 0x008000)>>8);
		data[position+2]=(byte)(val & 0x0000FF);	

	}

	//writes image data into file
	// throws IOException for handling file writing errors
	public void write(String filename) throws IOException{

		//uses try catch blocks for exception handling in case of file writing problems 	
		//try {
			FileOutputStream f=new FileOutputStream(filename);

			//writes header file for the image with specified height and width
			String content =String.format("P6\t", width , height ,255);
			f.write(content.getBytes());
			//Writes throughout the image for pixel value
			for(int i=0; i<data.length; i++)
			{
				f.write(data[i]);
			}


			f.close();
		//}

	//catch(Exception e) {
			//System.out.println("Error writing file");
		//}

	}



}
