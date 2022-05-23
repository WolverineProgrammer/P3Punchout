
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	private double scale = 8;

	public Background(int x, int y) {
		img = getImage("title.png"); 
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	} 
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);

	}
	public void setX(int val) {
		x = val;
	}
	
	public int getX() {
		return x;
	}
	
	public void setScale(double val) {
		scale = val;
	}
	
	public void compLab() {
		img = getImage("compLab.png");
		setScale(9.5);	
	}
	
	public void endGame1() {
		img = getImage("player1wins.png");
	}
	public void endGame2() {
		img = getImage("player2wins.png");
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(scale, scale);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	public static Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
     
	public void setImg(Image yuh) {
		 img = yuh;
	}
}
