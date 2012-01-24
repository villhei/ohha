/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

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
	// Directions:
	//    0 
	//  3 * 1
	//    2
	
	public Snake(int x, int y)
	{
		length = 4;
		head_x = x;
		head_y = y;
		width = 20;
		height = 20;
		
		direction = 1;
	
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
	
	public void move()
	{
		if(direction == 0)
		{
			head_y--;
		}
		if(direction == 1)
		{
			head_x++;
		}
		if(direction == 2)
		{
			head_y++;
		}
		if(direction == 3)
		{
			head_x--;
		}
	}
}
