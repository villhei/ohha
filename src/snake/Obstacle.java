/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 * Class of obstacles for the game, these are the walls, etc
 * setters and getters for their dimensions
 */
public class Obstacle {

	private int start_x;
	private int start_y;
	private int size_x;
	private int size_y;

	/** Constuctor for the obstacle
	 * @param create new obstacle, start x, start y, size x, size y
	 */
	public Obstacle(int startx, int starty, int sizex, int sizey) {

		if (startx < 0 || startx > 800) {
			startx = 0;
		}
		if (starty < 0 || starty > 600) {
			starty = 0;
		}
		if (sizex < 0 || sizex > 800) {
			sizex = 100;
		}
		if (sizey < 0 || sizey > 600) {
			sizey = 100;
		}

		start_x = startx;
		start_y = starty;
		size_x = sizex;
		size_y = sizey;
	}
	/**
	 * Check if snake collides
	 * @param head_x x coordinate
	 * @param head_y Y coordinate
	 * @return true if snake collides with obstacle, otherwise false
	 */
	public boolean overlap(int head_x, int head_y) {
		if ((head_x >= start_x && head_x < start_x + size_x)
				&& (head_y >= start_y && head_y < size_y + start_y)) {
			return true;
		}
		return false;
	}
	/**
	 *  ToString fro the obstacle, useful for debugging
	 * @return string representation
	 */

	@Override
	public String toString() {
		return "start_x: " + start_x
				+ "start_y: " + start_y
				+ "size_x: " + size_x
				+ "size_y: " + size_y;
	}

	/**
	 * @return gets obstacle x size
	 */
	public int getSize_x() {
		return size_x;
	}

	/**
	 * @param set size x
	 */
	public void setSize_x(int size_x) {
		this.size_x = size_x;
	}

	/**
	 * @return gets obstacle y size
	 */
	public int getSize_y() {
		return size_y;
	}

	/**
	 * @param set size y
	 */
	public void setSize_y(int size_y) {
		this.size_y = size_y;
	}

	/**
	 * @return gets start x position
	 */
	public int getStart_x() {
		return start_x;
	}

	/**
	 * @param sets start x position
	 */
	public void setStart_x(int start_x) {
		this.start_x = start_x;
	}

	/**
	 * @return gets start y position
	 */
	public int getStart_y() {
		return start_y;
	}

	/**
	 * @param sets start y position
	 */
	public void setStart_y(int start_y) {
		this.start_y = start_y;
	}
}