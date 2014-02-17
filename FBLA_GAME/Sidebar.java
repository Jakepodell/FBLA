// HOLDS THE LEVELTIMER, LOGOTIMER, AND LEVELPANEL
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
public class Sidebar{
	LogoTimer lt;
	LevelPanel lp;
	LevelTimer t;
	Rectangle2D.Double r;
	int x;
	int y;

	public Sidebar(int levelNumber, int x2, int y2){
		x =x2;
		y =y2;
		lt = new LogoTimer(levelNumber);
		lp = new LevelPanel(levelNumber,x+40,y+190);
		t = new LevelTimer(3600);
		r = new Rectangle2D.Double(x,y,250,550);
	}

	public void drawSidebar(Graphics2D g2){
		lt.drawLogoTimer(x+34,y+480,g2);
		lp.drawLevelPanel(g2);
		t.drawLevelTimer(x,y+8,g2);
		t.tick();
	}
}