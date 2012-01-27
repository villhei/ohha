/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author villheik
 */
public class Obstacle {

	private int start_x;
	private int start_y;
	private int size_x;
	private int size_y;

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

	@Override
	public String toString() {
		return "start_x: " + start_x
				+ "start_y: " + start_y
				+ "size_x: " + size_x
				+ "size_y: " + size_y;
	}

	public int getSize_x() {
		return size_x;
	}

	public void setSize_x(int size_x) {
		this.size_x = size_x;
	}

	public int getSize_y() {
		return size_y;
	}

	public void setSize_y(int size_y) {
		this.size_y = size_y;
	}

	public int getStart_x() {
		return start_x;
	}

	public void setStart_x(int start_x) {
		this.start_x = start_x;
	}

	public int getStart_y() {
		return start_y;
	}

	public void setStart_y(int start_y) {
		this.start_y = start_y;
	}
}
