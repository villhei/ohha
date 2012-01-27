/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import snake.Obstacle;
import snake.Snake;
import snake.SnakeGame;
import snake.SnakePart;

public class GameArea extends JPanel {

	private int size_x;
	private int size_y;
	private SnakeGame game;

	public GameArea(int x, int y, SnakeGame sgame) {
		this.size_x = x;
		this.size_y = y;
		this.game = sgame;
		this.setSize(size_x, size_y);

	}

	@Override
	public String toString() {
		Dimension blaa = this.getSize();
		return "Gamearea x: " + blaa.width + ", y: " + blaa.height;
	}

	@Override
	public void paint(Graphics gfx) {

		super.paint(gfx);
		drawGameEvents(gfx);

	}

	private void drawGameEvents(Graphics g) {

		for (Obstacle obs : game.getObstacles()) {
			drawObstacle(obs, g);
		}

		drawSnake(g);

	}

	private void drawObstacle(Obstacle obs, Graphics g) {
		g.setColor(Color.red);
		g.fillRect(obs.getStart_x(),
				obs.getStart_y(),
				obs.getSize_x(),
				obs.getSize_y());
	}

	private void drawSnake(Graphics g) {
		
		LinkedList<SnakePart> parts = game.getSnake().getParts();
		for (SnakePart part : parts)
		{
			g.setColor(Color.blue);
			g.fillRect(part.getHead_x(), part.getHead_y(), part.getWidth(), part.getHeight());
		}
	}
}
