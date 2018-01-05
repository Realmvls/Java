import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Test {

	public static void main(String[] args) throws Exception{
		BufferedImage bi = ImageIO.read(new File("imgs/fish14_00.png"));
		int width = bi.getWidth();
		int height = bi.getHeight();

		AffineTransform trans = new AffineTransform();
		trans.rotate(Math.PI/2,width/2,height/2);
		trans.rotate(Math.PI/2,width/2,height/2);
		
		
		BufferedImage bi2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi2.createGraphics();
		g.setTransform(trans);
		
		g.drawImage(bi,null,null);
		
		ImageIO.write(bi2, "png", new File("c:/xxx.png"));
	}
}
