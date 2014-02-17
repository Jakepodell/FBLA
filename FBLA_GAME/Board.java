import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Board{
	Rectangle2D.Double r;
	int x, y;
	Image deskTexture;
	Ellipse2D.Double[] circles = new Ellipse2D.Double[3];
	Image block1, block2, block3, block4,block5; // for demos, not actual use

	public Board(int x2, int y2){
		x = x2;
		y = y2;
		r = new Rectangle2D.Double(x,y,450,550);
		deskTexture = Toolkit.getDefaultToolkit().getImage("deskTexture.png");
		circles[0]= new Ellipse2D.Double(x+10, y+50, 25,25);
		circles[1]= new Ellipse2D.Double(x+10, y+253, 25,25);
		circles[2]= new Ellipse2D.Double(x+10, y+455, 25,25);
		//block demos
		block1 = Toolkit.getDefaultToolkit().getImage("FBlock.png");
		block2 = Toolkit.getDefaultToolkit().getImage("BBlockSmall.png");
		block3 = Toolkit.getDefaultToolkit().getImage("LBlockSmall.png");
		block4 = Toolkit.getDefaultToolkit().getImage("ABlockSmall.png");
		block5 = Toolkit.getDefaultToolkit().getImage("LogoBlockSmall.png");

	}

	public void drawBoard(Graphics2D g2){
		drawPaper(g2);
		drawLines(g2);
		drawCircles(g2);
		//block demos
		g2.drawImage(block1,x+150, y+350, null);
		g2.drawImage(block2,x+250, y+150, null);
		g2.drawImage(block3,x+50, y+300, null);
		g2.drawImage(block4,x+350, y+50, null);
		g2.drawImage(block5,x+300, y+250, null);


	}

	private void drawCircles(Graphics2D g2){
		g2.setClip(circles[0]);
		g2.drawImage(deskTexture,x+5,y+45, null);
		g2.setClip(circles[1]);
		g2.drawImage(deskTexture,x+5,y+250, null);
		g2.setClip(circles[2]);
		g2.drawImage(deskTexture,x+5,y+450, null);
		g2.setClip(null);
		g2.setColor(Color.gray);
		for(Ellipse2D.Double circ : circles){
			g2.draw(circ);
		}
	}

	private void drawLines(Graphics2D g2){
		// Big Lines
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(182,227,250,175));
		//horiz
		for(int i=50; i<450; i+=50){
			g2.drawLine(x+i,y+2,x+i,y+548);
		}
		//vert
		for(int i=50; i<550; i+=50){
			g2.drawLine(x+2,y+i,x+448,y+i);
		}

		// Small Lines
		g2.setStroke(new BasicStroke(1));
		g2.setColor(new Color(182,227,250,150));
		//horiz
		for(int i=10; i<450; i+=10){
			g2.drawLine(x+i,y,x+i,y+548);
		}
		//vert
		for(int i=10; i<550; i+=10){
			g2.drawLine(x,y+i,x+448,y+i);
		}
	}

	private void drawPaper(Graphics2D g2){
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(2));
		g2.draw(r);
		g2.setColor(new Color(252,242,205));//paper color
		g2.fill(r);
	}
}