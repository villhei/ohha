/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import snake.*;

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
		drawApple(g);
		if (game.isPaused()) {
			drawDialog(g, "PAUSED - SCORE: " + game.getScore());
		}
		if (game.hasEnded()) {
			drawDialog(g, "DEATH! - SCORE: " + game.getScore());
		}

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
		for (SnakePart part : parts) {
			g.setColor(Color.blue);
			g.fillRect(part.getHead_x(), part.getHead_y(), part.getWidth(), part.getHeight());
		}
	}

	private void drawApple(Graphics g) {

		Apple apple = game.getApple();
		g.setColor(Color.green);
		g.fillRect(apple.getPos_x(), apple.getPos_y(), apple.getSize_x(), apple.getSize_y());
	}

	private void drawDialog(Graphics g, String text) {
		Font font = new Font("Arial Black", 1, 40);
		g.setColor(Color.white);
		int start_y = (size_y / 2) - 100;
		g.fillRect(0, start_y, size_x, 20);
		g.fillRect(0, start_y + 80, size_x, 20);
		g.setColor(Color.black);
		g.fillRect(0, start_y + 20, size_x, 60);
		g.setColor(Color.gray);
		g.setFont(font);
		g.drawString(text, ( size_x - (text.length() * 28) )/ 2, start_y + 60);

	}
}
