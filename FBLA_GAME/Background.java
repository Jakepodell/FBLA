import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;
public class Background{
	Image desk;
	Image eraser;
	public Background(Dimension d){
		try{
			desk = ImageIO.read(new File("desk.png"));
			eraser = ImageIO.read(new File("EraserSmall.png"));
		}catch(IOException e){}
		desk = desk.getScaledInstance(d.width-17,d.height-35,1);
	//	eraser= eraser.getScaledInstance(160,75,1); MANUAL SHRINK
	}
	public void drawDesk(Graphics2D g2){
		g2.drawImage(desk,0,0,null);
		/*AffineTransform oldForm = g2.getTransform();
		g2.rotate(-Math.PI/20);      MANUAL ROTATION*/
		g2.drawImage(eraser,75,100,null);
		//g2.setTransform(oldForm);
	}
}