/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import snake.Obstacle;
import snake.Snake;
import snake.SnakeGame;

public class GameArea extends JPanel {

	private int size_x;
	private int size_y;
	
	private SnakeGame game;

	public GameArea(int x, int y, SnakeGame sgame) {
		this.size_x = x;
		this.size_y = y;
		this.game = sgame;

		this.setSize(size_x, size_y);
		this.setLocation(25, 5);
	}
	
	@Override
	public String toString()
	{
		Dimension blaa = this.getSize();
		return "Gamearea x: " + blaa.width + ", y: " + blaa.height;
	}

	@Override
	public void paint(Graphics gfx) {

		super.paint(gfx);
		drawGameEvents(gfx);

	}

	private void drawGameEvents(Graphics g)
	{
			
		for(Obstacle obs : game.getObstacles())
		{
			drawObstacle(obs, g);
		}
		
		drawSnake(game.getSnake(), g);

	}
	
	private void drawObstacle(Obstacle obs, Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(obs.getStart_x(),
				obs.getStart_y(),
				obs.getSize_x(),
				obs.getSize_y());
	}
	
	private void drawSnake(Snake snk, Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(snk.getHead_x(), snk.getHead_y(), snk.getWidth(), snk.getHeight());
	}
}
