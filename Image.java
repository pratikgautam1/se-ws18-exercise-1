
/*  Submitted to Dr. Florian Echtler  and  Christopher Getschmann
    Submitted by Pratik Gautam(119500) and Abdelrahman Refaie(119495) 
 	Bauhaus University Weimar
 	Digital Engineering 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//importing packages and libraries for image and color

public class Image {	
	//image with specified width and height
	int width, height;
	int rgb_value;
	int pixel_position;
	byte[] data;
	//	public static byte[] data = new byte[3];
	//private BufferedImage image;
	
	public Image(int width,int height) {
		//we create constructor for creating image with specified height and width

		this.width = width;
		this.height = height;
		this.data = new byte[width*height*3];
		
		//image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		//data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();


	}

	public void set(int x, int y, int rgb_value) {
		// TODO Auto-generated method stub
		//setting RGB values to single pixel in specified pixel_position
		int rgbvalmax=0xFFFFFF;
		rgb_value=rgbvalmax & rgb_value;
		String strValue="0x"+ Integer.toHexString(rgb_value);
		//determining the pixel position
		pixel_position=x*width*3+y*3;
		//Assigning pixel at different position
		data[pixel_position]=(byte)Integer.parseInt(strValue.substring(2,4),16); 
		data[pixel_position+1]=(byte)Integer.parseInt(strValue.substring(4,6),16);
		data[pixel_position+2]=(byte)Integer.parseInt(strValue.substring(6,8),16);	
	
		//image.setRGB(x,y,val);
		//data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			
	}

	//write method to file
	public void write(String filename) throws IOException{
		// throwing exception if there is any error while writing the file
		
		//File f = new File(filename);
		FileWriter filewriter = new FileWriter(filename);
		BufferedWriter bf= new BufferedWriter(filewriter);
		//setting ppm header file
		String assignment = "P6\t" + width + "\t" + height + "\t";
		bf.write(assignment);
		//setting pixel value in specified position
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				int pixel_position1= i*width*3+j*3;
				bf.write((Byte.toUnsignedInt((byte)(data[pixel_position1])) + "\t"));
				bf.write((Byte.toUnsignedInt((byte)(data[pixel_position1+1])) + "\t"));
				bf.write((Byte.toUnsignedInt((byte)(data[pixel_position1+2])) + "\t"));


			}
		}
		bf.close();


	}
	
	//Path path = Paths.get(f.getAbsolutePath());
			//try {
			//  Files.write(path, image_data);
			//} catch (IOException e) {
			//System.out.println(e);
			// }

	
}

