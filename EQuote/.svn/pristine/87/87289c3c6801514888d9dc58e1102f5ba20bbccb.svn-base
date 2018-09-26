package com.wave.core.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
/**
 * 图像处理工具类
 * @author jinfeng
 * @date   2014-1-15
 * @pack   com.hoosen.base.utils
 */
public class ImageUtil {
	protected transient final  Logger log = LogManager.getLogger(getClass());  
	private int newWidth; // 默认输出图片宽
	private int newHeight; // 默认输出图片高
	private boolean eqRatio = true; // 是否等比缩放标记(默认为等比缩放)
	/**
	 * 图像处理类构造方法，默认设置输出图片宽newWidth = 100,输出图片高newHeight = 100
	 * 图片默认为等比缩放
	 */
	public ImageUtil() { 
		this.newWidth = 100;
		this.newHeight = 100;
	}
	/**
	 * 图片处理类构造方法，自动设置图片输出宽newWidth，输出图片高度newHeight
	 * 图片默认等比缩放
	 */
	public ImageUtil ( int Width , int Height) {
		this.newWidth = Width ;
		this.newHeight = Height ;
	}
	/**
	 * 缩放图像，根据参数返回新的图像数据对象
	 * @param fileUrl	原图片url路径
	 * @return 缩放后的图像数据
	 */
	public BufferedImage resizeImage(String fileUrl)  {
		BufferedImage bi = null;
		try {
			//获得源文件
			File file = new File(fileUrl);
			if (!file.exists()) {
				throw new FileNotFoundException();
			}
			Image img = ImageIO.read(file);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				throw new Exception("图片格式错误");
			} else {
				bi = resizeImage(img,this.newWidth,this.newHeight,eqRatio);
			}
		} catch (IOException ex) {
			log.error("出现IO流错误，请检查系统软件！",ex);
		} catch (Exception e) {
			log.error("出现未知异常请重试！",e);
		}
		return bi;
	}

	/**
	 * 缩放图像，根据参数返回新的图像数据对象
	 * @param img 图像对象
	 * @param newWidth 新图像宽度
	 * @param newHeight 新图像高度
	 * @param eqRatio 	是否等比缩放
	 * @return 缩放后的图像
	 */
		public  BufferedImage resizeImage(Image img,float newWidth,float newHeight,boolean eqRatio) {
			//获取这个图片的宽和高  
	        int width = img.getWidth(null);  
	        int height = img.getHeight(null);  
	        log.debug("old img==w="+width+" ==h=="+height);
			// 是否等比缩放
			if (eqRatio) {
				//计算缩放率，新尺寸除以原始尺寸  
				float scaleWidth = newWidth/ width;  
		        float scaleHeight = newHeight/ height;
				// 根据缩放比率大的进行缩放控制
		        float rate= Math.min(scaleWidth , scaleHeight);
		        log.debug(" rate:"+rate);
				newWidth = (float)width * rate;
				newHeight = (float)height * rate;
			}  
			// 创建操作图片用的BufferedImage对象  
			BufferedImage buffIMG  = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
			/*
			 * 缩放图片动作  
			 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的
			 * 优先级比速度高 生成的图片质量比较好 但速度慢
			 */
			buffIMG.getGraphics().drawImage(img.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH), 0, 0, null);
			System.out.println("r==w="+newWidth+" ==h=="+newHeight);
			return buffIMG;
		}
		
		public static void main(String[] arg) {
			String fileUrl="D:\\20131221102817.png";
			ImageUtil mypic = new ImageUtil(100,100);
			BufferedImage buffIMG = mypic.resizeImage(fileUrl);
			FileOutputStream out;
			
			try {
				out = new FileOutputStream("d://test1.jpeg"); 
				/*
				 * 0.75 high quality 高品质转换
	             * 0.5  medium quality
	             * 0.25 low quality
				 */  
				//默认品质转换 
				ImageIO.write(buffIMG, "jpeg", out);
				
				out.flush();
				out.close(); 
				
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}

		}
		
}
