import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.net.URL;
public class Character {
	public int x, y; 
	public int hv, vv;
	private Image img; 	

	private AffineTransform tx;

	//create constructor for object
	public Character(int x, int y) {
		this.x = x;
		this.y = y;
		//load the character images 
		img = getImage("testMan.png"); 
	
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 			
	
	}
	
	public void update() {
		
		tx.setToTranslation(x, y);
		tx.scale(.071, .071);
	
	}
	
	public void jump()
	{
		vv += 11; 
	}
	
	public void moveLeft()
	{
	hv -= 3.7;
	}
	
	
	public void moveRight()
	{
	hv += 3.7;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.27, .27);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Character.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		

	}
}
