/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;
import snake.*;
/**
 *  Game area, acts as a container for game events
 * @author villheik
 */

public class GameArea extends JPanel {

	private int size_x;
	private int size_y;
	private SnakeGame game;
	
	/**
	 *  Constructor for game area
	 * @param x horizontal size (default 800)
	 * @param y vertical size (default 600)
	 * @param sgame current game
	 */

	public GameArea(int x, int y, SnakeGame sgame) {
		this.size_x = x;
		this.size_y = y;
		this.game = sgame;
		this.setSize(size_x, size_y);

	}
	
	/** toString method to request for debug info
	 *  from the game area
	 * @return String representation of game areas size 
	 */

	@Override
	public String toString() {
		Dimension blaa = this.getSize();
		return "Gamearea x: " + blaa.width + ", y: " + blaa.height;
	}

	/** Method to paint the panel
	 *  Used for repainting the game state
	 * @param Graphics as a parameter
	 */
	
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
			drawDialog(g, "PAUSED");
		}
		if (game.hasEnded()) {
			drawPlayerStats(g);

		}

	}
	
	private void drawPlayerStats(Graphics g)
	{
		String deathMessage = "DEATH! - P1: " + game.getSnake().get(0).getScore();
		if(game.getPlayers() > 1)
		{
			deathMessage += ", P2: " + game.getSnake().get(1).getScore();
		}
		if(game.getPlayers() > 2)
		{
			deathMessage += ", P3: " + game.getSnake().get(2).getScore();
		}
		drawDialog(g, deathMessage);
	}

	private void drawObstacle(Obstacle obs, Graphics g) {
		g.setColor(Color.red);
		g.fillRect(obs.getStart_x(),
				obs.getStart_y(),
				obs.getSize_x(),
				obs.getSize_y());
	}

	private void drawSnake(Graphics g) {
		ArrayList<Snake> snakes = game.getSnake();

		for (int i = 0; i < game.getPlayers(); ++i) {
			if (i == 0) {
				g.setColor(Color.blue);
			}
			if (i == 1) {
				g.setColor(Color.magenta);
			}
			
			if (i == 2) {
				g.setColor(Color.yellow);
			}
			LinkedList<SnakePart> parts = snakes.get(i).getParts();
			for (SnakePart part : parts) {

				g.fillRect(part.getHead_x(), part.getHead_y(), part.getWidth(), part.getHeight());
			}
		}
	}

	private void drawApple(Graphics g) {

		Apple apple = game.getApple();
		g.setColor(Color.green);
		g.fillRect(apple.getPos_x(), apple.getPos_y(), apple.getSize_x(), apple.getSize_y());
	}

	private void drawDialog(Graphics g, String text) {
		Font font = new Font("Arial Black", 1, 30);
		g.setColor(Color.white);
		int start_y = (size_y / 2) - 100;
		g.fillRect(0, start_y, size_x, 20);
		g.fillRect(0, start_y + 80, size_x, 20);
		g.setColor(Color.black);
		g.fillRect(0, start_y + 20, size_x, 60);
		g.setColor(Color.gray);
		g.setFont(font);
		g.drawString(text, (size_x - (text.length() * 26)) / 2, start_y + 60);

	}
}