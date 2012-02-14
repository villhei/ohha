package snake;

public class SnakePart {

	private int head_x;
	private int head_y;
	private int direction;
	private int width;
	private int height;
	private int movestep;

	/**
	 *  @param new snake part, x position, y position, width, height
	 */
	public SnakePart(int x, int y, int wth, int hth) {
		head_x = x;
		head_y = y;
		width = wth;
		height = hth;
	}
	/** Method for checking snake collision with itself
	 * 
	 * @param x x_position to check overlap for
	 * @param y y_position to check overlap for
	 * @return true if snake head collides with parts
	 */
	
	public boolean overlap(int x, int y)
	{
		if ((x >= head_x && x < head_x + width)
				&& (y >= head_y && y < head_y + height)) {
			return true;
		}
		return false;
	}
	/** toString representation of the snake part in question
	 *  @return debug information for snake parts
	 */
	@Override
	public String toString()
	{
		return "head_x: " + head_x + " head_y: " + head_y +
				" width: " + width + " height: " + height;
	}

	public int getDirection() {
		return direction;
	}
	/**
	 *  @param sets snake part direction, not normally used
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	/**
	 *  @return part x_position
	 */
	public int getHead_x() {
		return head_x;
	}
	/**
	 *  @param set part x_position
	 */
	public void setHead_x(int head_x) {
		this.head_x = head_x;
	}
	/**
	 *  @return part y_position
	 */
	public int getHead_y() {
		return head_y;
	}
	/**
	 *  @param set part y_position
	 */
	public void setHead_y(int head_y) {
		this.head_y = head_y;
	}
	/**
	 *  @return get part height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 *  @param set part height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 *  @return get part width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 *  @param set part width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}