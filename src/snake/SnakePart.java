package snake;

public class SnakePart {

	private int head_x;
	private int head_y;
	private int direction;
	private int width;
	private int height;
	private int movestep;

	public SnakePart(int x, int y, int wth, int hth) {
		head_x = x;
		head_y = y;
		width = wth;
		height = hth;
	}
	
	@Override
	public String toString()
	{
		return "head_x: " + head_x + " head_y: " + head_y +
				" width: " + width + " height: " + height;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getHead_x() {
		return head_x;
	}

	public void setHead_x(int head_x) {
		this.head_x = head_x;
	}

	public int getHead_y() {
		return head_y;
	}

	public void setHead_y(int head_y) {
		this.head_y = head_y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMovestep() {
		return movestep;
	}

	public void setMovestep(int movestep) {
		this.movestep = movestep;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}