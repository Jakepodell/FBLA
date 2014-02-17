import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class FBLAGame extends JFrame implements ActionListener, KeyListener{
	Sidebar sb;
	Board b;
	Timer t;
	Background bg;
	int levelNumber;
	private final static Dimension FRAMESIZE = new Dimension(900,850);
	public FBLAGame(){
		setVisible(true);
		levelNumber=2;
		b = new Board(50,200);
		bg = new Background(FRAMESIZE);
		sb = new Sidebar(levelNumber, 550,180);
		setContentPane(new drawingPanel());
		setFocusable(true);
		setSize(FRAMESIZE);
		t = new Timer(60,this);
		t.start();
		setBackground(Color.white);
	}

	public class drawingPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			bg.drawDesk(g2);
			b.drawBoard(g2);
			sb.drawSidebar(g2);
			setBackground(Color.white);

		}
	}

	public static void main(String[] args){
		new FBLAGame();
	}

	public void actionPerformed(ActionEvent e){
		repaint();
	}

	public void keyPressed(KeyEvent k){
	}
	public void keyTyped(KeyEvent k){
	}
	public void keyReleased(KeyEvent k){
	}

}