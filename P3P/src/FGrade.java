
public class FGrade extends Object{
	public FGrade (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "FGrade.png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}
	public FGrade(int x, int y, boolean whichWay) {
		// TODO Auto-generated constructor stub
	}
	public void appear(MD b) {
		this.x= b.getX();
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
