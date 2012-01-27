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
	private int head_x;
	private int head_y;
	private int direction;
	private int width;
	private int height; 
	final int movestep = 20;
	private LinkedList<SnakePart> parts;
	// Directions:
	//    0 
	//  3 * 1
	//    2
	
	public Snake(int x, int y)
	{
		width = 20;
		height = 20;
		length = 4;
		direction = 1;
		parts = new LinkedList<SnakePart>();
		
		for(int i = 0 ; i < length; ++i)
		{
			parts.addLast(new SnakePart(x-(width*i),y,width,height));
			System.out.println("added!");
			System.out.println("" + parts.getFirst());
		}
	
	}
	
	
	public LinkedList getParts()
	{
		return parts;
	}
	
	@Override
	public String toString()
	{
		return "Direction: " + direction + "\nHead_x: " + head_x + "\nHead_y: " + head_y;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	

	public void growSnake()
	{
		length++;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public void setDirection(int newDirection)
	{
		direction = newDirection;
	}
	
	private void moveRight()
	{
		int pos_x = parts.getFirst().getHead_x();
		int pos_y = parts.getFirst().getHead_y();
		parts.addLast(new SnakePart(pos_x+movestep, pos_y, width, height));
		parts.removeFirst();
		
	}
	private void moveLeft()
	{
		int pos_x = parts.getFirst().getHead_x();
		int pos_y = parts.getFirst().getHead_y();
		parts.add(new SnakePart(pos_x-movestep, pos_y, width, height));
		parts.removeFirst();
	}
	
	private void moveUp()
	{
		int pos_x = parts.getFirst().getHead_x();
		int pos_y = parts.getFirst().getHead_y();
		parts.add(new SnakePart(pos_x, pos_y+movestep, width, height));
		parts.removeFirst();
	}
	
	private void moveDown()
	{
		int pos_x = parts.getFirst().getHead_x();
		int pos_y = parts.getFirst().getHead_y();
		parts.add(new SnakePart(pos_x, pos_y-movestep, width, height));
		parts.removeFirst();
	}
	
	public void move()
	{
		if(direction == 0)
		{
			moveUp();
		}
		if(direction == 1)
		{
			moveRight();
		}
		if(direction == 2)
		{
			moveDown();
		}
		if(direction == 3)
		{
			moveLeft();
		}
	}
}
