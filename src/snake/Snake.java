/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.LinkedList;

/**
 *
 * @author villheik
 */
public class Snake {

	private int length;
	private int pos_x;
	private int pos_y;
	private int direction;
	private int width;
	private int height;
	final int movestep = 20;
	private LinkedList<SnakePart> parts;
	// Directions:
	//    0 
	//  3 * 1
	//    2
	/**	@param input snake start point
	 */


	public Snake(int x, int y) {
		width = 20;
		height = 20;
		length = 4;
		pos_x = x;
		pos_y = y;
		direction = 1;
		parts = new LinkedList<SnakePart>();

		for (int i = 0; i < length; ++i) {
			parts.addLast(new SnakePart(x - (width * i), y, width, height));
			System.out.println("added!");
			System.out.println("" + parts.getFirst());
		}

	}
	/**
	 *  @return snake parts for drawing
	 */
	public LinkedList getParts() {
		return parts;
	}

	/**
	 *  @return snake description, useful debug
	 */
	@Override
	public String toString() {
		return "Direction: " + direction + "\npos_x: " + pos_x + "\npos_y: " + pos_y;
	}

	/**
	 *  @return snake height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 *  @param set snake height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 *  @return snake width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 *  @return set snake width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 *  @param grow snake
	 */
	public void growSnake() {
		length++;
	}
	/**
	 *  @return gets snake length
	 */
	public int getLength() {
		return this.length;
	}
	/**
	 *  @return gets snake direction
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 *  @param set snake direction int
	 */
	public void setDirection(int newDirection) {
		direction = newDirection;
	}

	private void moveRight() {
		pos_x = parts.getFirst().getHead_x() + movestep;
		if(pos_x > 800) {
			pos_x = 0;
		}
		pos_y = parts.getFirst().getHead_y();
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		parts.removeLast();

	}

	private void moveLeft() {
		pos_x = parts.getFirst().getHead_x() - movestep;
		pos_y = parts.getFirst().getHead_y();
		if(pos_x < 0)
			pos_x = 800;
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		parts.removeLast();
	}

	private void moveUp() {
		pos_x = parts.getFirst().getHead_x();
		pos_y = parts.getFirst().getHead_y() - movestep;
		if(pos_y < 0)
			pos_y = 600;
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		parts.removeLast();
	}

	private void moveDown() {
		pos_x = parts.getFirst().getHead_x();
		pos_y = parts.getFirst().getHead_y() + movestep;
		if(pos_y > 600)
			pos_y = 0;
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		parts.removeLast();
	}
	/**
	 *  @param move snake body to set direction
	 */
	public void move() {
		if (direction == 0) {
			moveUp();
		}
		if (direction == 1) {
			moveRight();
		}
		if (direction == 2) {
			moveDown();
		}
		if (direction == 3) {
			moveLeft();
		}
	}
}
