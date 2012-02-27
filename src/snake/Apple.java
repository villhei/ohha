/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.Random;

/**
 * Class for all the relevant stuff about Apples
 * 
 */
public class Apple {

	private int size_x = 20;
	private int size_y = 20;
	private int pos_x;
	private int pos_y;
	private Random random;
	private boolean visible;
	
	/** Constructor for creating an apple,
	 *  constructor also randomizes apple position.
	 */
	public Apple() {
		
		this.visible = false;
		randomizePosition();
	}
	
	/**
	 *  Randomize apple position
	 */

	public void randomizePosition() {
		random = new Random();
		pos_x = random.nextInt(38)*20+20;
		pos_y = random.nextInt(28)*20+20;
	}

	/** Is snake eating the apple?
	 * 
	 * @param head_x Snake's head location (x)
	 * @param head_y Snake's head location (y)
	 * @return true if snake eats, false if not
	 */
	public boolean eatingme(int head_x, int head_y) {
		if ((head_x >= pos_x && head_x < pos_x + size_x)
				&& (head_y >= pos_y && head_y < pos_y + size_y)) {
			System.out.println("syöty!");
			return true;
		}
		return false;
	}
	/** Constructor for apple
	 * 
	 * @param x creation position
	 * @param y creation position
	 */

	public Apple(int x, int y) {
		pos_x = x;
		pos_y = y;
		visible = true;
	}

	/** is apple visible?
	 * 
	 * @return visibility
	 */
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
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
}