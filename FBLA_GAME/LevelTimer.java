import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
public class LevelTimer{
	int timeLeft;
	double bigTime;
	Font f;
	Font bigF;
	Image sticky;

	public LevelTimer(int initTime){
		timeLeft=initTime;
		bigTime = timeLeft*1000; // represents time left in miliseconds
		f = new Font("Lucida Handwriting", Font.BOLD, 17);
		bigF = new Font("Lucida Handwriting", Font.BOLD, 40);
		sticky = Toolkit.getDefaultToolkit().getImage("sticky.png").getScaledInstance(175,175,1);
	}

	public void drawLevelTimer(int x, int y, Graphics2D g2){
		g2.drawImage(sticky,x,y,null); // draw sticky note
		drawHeader(x,y,g2);
		drawTime(x,y,g2);
	}

	private void drawHeader(int x, int y,Graphics2D g2){
		g2.setColor(new Color(75,75,75));
		g2.setFont(f);
		g2.drawString("Class ends in",x+16,y+50);
	}

	private void drawTime(int x, int y,Graphics2D g2){
		g2.setFont(bigF);	//draw time left
		if(timeLeft/60>9 && timeLeft%60 >9)
			g2.drawString((int)(Math.floor(timeLeft/60.0))+":"+timeLeft%60, x+20,y+100);
		else if(timeLeft/60<=9 && timeLeft%60 <=9)
			g2.drawString((int)(Math.floor(timeLeft/60.0))+":0"+timeLeft%60, x+20,y+100);
		else if(timeLeft/60<=9)
			g2.drawString((int)(Math.floor(timeLeft/60.0))+":"+timeLeft%60, x+20,y+100);
		else if(timeLeft%60 <=9)
			g2.drawString((int)(Math.floor(timeLeft/60.0))+":0"+timeLeft%60, x+20,y+100);//cause fuck numberformat again
	}

	public void tick(){
		//timeLeft--;
		bigTime-=60;
		timeLeft = (int)(bigTime/1000.0); //rate is slower than realTime
	}
}