package cv1.util.common;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileUtil {	
	public static BufferedImage readImg(String path){
		/*
		 * read image from path
		 * return type BufferedImage
		 */
		BufferedImage result = null;
		try {
			result  = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("readImg fail!");
		}
		return result;
	}
	public static void writeImg(BufferedImage img,String path) {
		/*
		 * write image to the path
		 * auto split format name from path
		 */
		String splitPath[] = path.split("\\.");
		try {
			ImageIO.write(img, splitPath[splitPath.length-1], new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeImg(BufferedImage img,String formatName,String path){
		/*
		 * write image to the path with specify type (formatName)
		 */
		try {
			ImageIO.write(img, formatName, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write2DMatrix(int matrix[][],String path){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					bw.write(String.format("%4d ", matrix[i][j]));
				}
				bw.write("\n");
			}
			
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
