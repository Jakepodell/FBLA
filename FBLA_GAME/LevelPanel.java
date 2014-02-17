// DISPLAYS THE CURRENT LEVEL ON A FOLDER
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
public class LevelPanel{
	String level;
	String levelNumber;
	Font textFont;
	Font numberFont;
	int x,y;
	Image folder, dots;
	AffineTransform oldForm;

	public LevelPanel(int levelNum, int x2, int y2){
		textFont = new Font("Serif",Font.BOLD, 35);
		numberFont = new Font("Serif",Font.BOLD, 35);
		level = "LEVEL";
		if(levelNum>=10)
		levelNumber = ""+levelNum;
		else
		levelNumber = "0"+levelNum; // cause fuck numberformat
		x=x2;
		y=y2;
		folder = Toolkit.getDefaultToolkit().getImage("Folder.png").getScaledInstance(240,240,1);
		dots = Toolkit.getDefaultToolkit().getImage("dots.png").getScaledInstance(240,240,1);
	}

	public void drawLevelPanel( Graphics2D g2){
		oldForm = g2.getTransform();
		drawFolder(g2);
		drawText(g2);
		drawDots(g2);
	}
	private void drawFolder(Graphics2D g2){
		g2.rotate(-Math.PI/22);
		g2.drawImage(folder,x-90,y+80,null);
		g2.setTransform(oldForm);
	}

	private void drawText(Graphics2D g2){
		g2.rotate(-Math.PI/10);
		g2.setFont(textFont);
		g2.setColor(Color.red);
		g2.drawString(level,x-155,y+303);
		g2.setFont(numberFont);
		g2.drawString(levelNumber,x-25,y+303);
		g2.setTransform(oldForm);
	}

	private void drawDots(Graphics2D g2){ //provides faded effect
		g2.rotate(-Math.PI/22);
		g2.drawImage(dots,x-90,y+80,null);
		g2.setTransform(oldForm);
	}
}