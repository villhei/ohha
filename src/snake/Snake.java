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
	private int id;
	public int score;
	final int movestep = 20;
	private int moves_since_last_turn;
	private boolean alive;
	private LinkedList<SnakePart> parts;

	// Directions:
	//    0 
	//  3 * 1
	//    2
	/**
	 * @param input snake start point
	 */
	public Snake(int x, int y, int id) {
		width = 20;
		height = 20;
		length = 4;
		pos_x = x;
		pos_y = y;
		direction = 1;
		this.id = id;
		score = 0;
		moves_since_last_turn = 0;
		alive = true;
		parts = new LinkedList<SnakePart>();

		for (int i = 0; i < length; ++i) {
			parts.addLast(new SnakePart(x - (width * i), y, width, height));
			System.out.println("added!");
			System.out.println("" + parts.getFirst());
		}
		System.out.println("parts.size: " + parts.size());
		System.out.println("snake.legnth: " + length);
		

	}
	/** Method for checking Snake's collision with
	 *  other snakeparts than head
	 * @return true if snake collides
	 */
	
	public boolean checkforCollision(int x, int y)
	{
		boolean first = true;
		for(SnakePart part : parts)
		{
			if(first)
			{
				first = false;
			}
			else
			{
				if(part.overlap(x, y))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method for returning snake's nodes
	 *
	 * @return snake parts for drawing
	 */
	public LinkedList getParts() {
		return parts;
	}

	/**
	 * Method for String expression of the snake
	 *
	 * @return snake description, useful debug
	 */
	@Override
	public String toString() {
		return "Direction: " + direction + "\npos_x: " + pos_x + "\npos_y: " + pos_y;
	}
	
	public boolean alive()
	{
		return alive;
	}
	
	public void die()
	{
		alive = false;
	}

	/**
	 * Getter for snake's height
	 *
	 * @return snake height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter for snake's height
	 *
	 * @param set snake height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter for snake's width
	 *
	 * @return snake width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter for snake's width
	 *
	 * @return set snake width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Grows snake when snake eats an apple
	 *
	 * @param grow snake
	 */
	public void growSnake() {
		length++;
	}

	/**
	 * What's the length of the snake again?
	 *
	 * @return gets snake length
	 */
	public int getLength() {
		return this.length;
	}
	
	public int getScore()
	{
		return this.score;
	}

	/**
	 * Snakes current direction
	 *
	 * @return gets snake direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Set snakes direction to newDirection
	 *
	 * @param set snake direction int
	 */
	public void setDirection(int newDirection) {
		if(moves_since_last_turn > 0)
		{
			direction = newDirection;
			moves_since_last_turn = 0;
		}
	}

	/**
	 * Moves snake right with the desired movestep if snake goes out of
	 * boundaries, return to the game area to x position 0 (left)
	 */
	private void moveRight() {
		pos_x = parts.getFirst().getHead_x() + movestep;
		if (pos_x >= 800) {
			pos_x = 0;
		}
		pos_y = parts.getFirst().getHead_y();
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		if (parts.size() == length+1) {
			parts.removeLast();
		}
	}

	/**
	 * Moves snake left with the desired movestep if snake goes out of
	 * boundaries, return to the game area to x position 780 (right)
	 */
	private void moveLeft() {
		pos_x = parts.getFirst().getHead_x() - movestep;
		pos_y = parts.getFirst().getHead_y();
		if (pos_x < 0) {
			pos_x = 780;
		}
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		if (parts.size() == length+1) {
			parts.removeLast();
		}
	}

	/**
	 * Moves snake up with the desired movestep if snake goes out of boundaries,
	 * return to the game area to y position 580 (down)
	 */
	private void moveUp() {
		pos_x = parts.getFirst().getHead_x();
		pos_y = parts.getFirst().getHead_y() - movestep;
		if (pos_y < 0) {
			pos_y = 580;
		}
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		if (parts.size() == length+1) {
			parts.removeLast();
		}
	}
	
	/**
	 * Moves snake up with the desired movestep if snake goes out of boundaries,
	 * return to the game area to y position 0 (up)
	 */
	private void moveDown() {
		pos_x = parts.getFirst().getHead_x();
		pos_y = parts.getFirst().getHead_y() + movestep;
		if (pos_y >= 600) {
			pos_y = 0;
		}
		parts.addFirst(new SnakePart(pos_x, pos_y, width, height));
		if (parts.size() == length+1) {
			parts.removeLast();
		}
	}
	
	public int getPos_x() {
		return pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	/**
	 * Method for moving snake, asks for snake direction and chooses the
	 * separate method accordingly
	 *
	 * @param move snake body to set direction
	 */
	public void move() {
		++moves_since_last_turn;
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
