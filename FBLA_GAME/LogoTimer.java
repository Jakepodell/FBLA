/* CREATES AN FBLA LOGO INSIDE AN IPHONE
LOGO HAS A WAVE ANIMATION AND DECREASING HEIGHT
HEIGHT DECREASES WITH THE STEP VARIABLE
USE TO SHOW WHEN A NEW SET OF BLOCKS ARE COMING
*/
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
public class LogoTimer{
	Image img;
	Image phone;
	double y;
	int r;
	Toolkit tk;
	Font f;
	String s;
	int w, h;
	double time;
	AffineTransform transform;
	int initialTime;
	double step;

	public LogoTimer(int levelNumber){
		transform = new AffineTransform();
		tk = Toolkit.getDefaultToolkit();
		phone=tk.createImage("IPhone2.png");
		phone = phone.getScaledInstance(300,150,1);
		img=tk.createImage("waves.gif");
		y = 400;
		r=40;
		w = 700;
		h = 700;
		f = new Font("Verdana", Font.BOLD+Font.ITALIC, 65);
		s = new String("FBLA");
		time=-30;
		initialTime=(int)time;
		step = 0.1+(0.01*levelNumber);
	}

	public void drawLogoTimer(int x, int y, Graphics2D g2){
		time+=step;

		//draw phone
		g2.drawImage(phone,x-50,y-45,null); // MANUAL ROTATION

		AffineTransform oldForm = g2.getTransform();//rotate
		g2.rotate(Math.PI/99);

		FontRenderContext frc = g2.getFontRenderContext();//create outline
		TextLayout textTl = new TextLayout(s, f, frc);
		Shape outline = textTl.getOutline(null);
		Rectangle r = outline.getBounds();

		transform = g2.getTransform();//translate
		transform.translate(x+40, r.height+y-40);
		g2.transform(transform);

		g2.setColor(new Color(25,175,235)); //set color and clipping mask
		g2.setStroke(new BasicStroke(2));
		g2.setClip(outline);

		g2.drawImage(img,r.x,(int)(r.y+time),r.width*3,(int)(r.height*1.5),null);	//draw waves
		g2.fillRect(0,(int)time-24,500,500);//<<-- solves lag problem by covering extra area

		g2.setClip(null);	//remove graphics transformations
		g2.setTransform(oldForm);

		if(time>=64+initialTime){ //check if waves have fallen. USE A SIMILAR METHOD TO SEE IF A NEW WAVE OF BLOCKS SHOULD RISE
			System.out.println("done?");
			time=-30;
		}
	}
}