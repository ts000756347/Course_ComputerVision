package hw2;

import java.awt.image.BufferedImage;

import cv1.util.common.FileUtil;
import cv1.util.cv.ImgUtil;
import cv1.util.cv.cclabeling.ClassicalAlgorithm;

public class BasicImageManipulation {
	public static final String inputFolder="input/";
	public static final String inputFileName="lena.bmp";
	public static final String outputFolder="output/";
	
	
	public static void main(String[] args) {
		//read image
		System.out.println("read img ...");
		BufferedImage lena = FileUtil.readImg(inputFolder+inputFileName);
		
		//image binarize with threashold 128
		System.out.println("binarizing ...");
		BufferedImage bin_lena = ImgUtil.imgBinarize(lena, 128);
		FileUtil.writeImg(bin_lena, outputFolder+"lena_binarize.png");
		
		//histogram
		System.out.println("histogram ...");
		int histArray[]=ImgUtil.getImgHistogramMatrix(lena);
		BufferedImage hist = ImgUtil.getHistogramImg(histArray);
		FileUtil.writeImg(hist, outputFolder+"histogram.png");
		
		//connected componedt
		System.out.println("find bounding box ...");
		BufferedImage bound = ImgUtil.drawBoundingBox(bin_lena, 500,ClassicalAlgorithm.COMPONENT_4);
		FileUtil.writeImg(bound, outputFolder+"boudingBox.png");
		
		System.out.println("done");
	}

}
