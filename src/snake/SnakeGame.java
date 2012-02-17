/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import snake.gui.MainWindow;

/**
 *
 * @author villheik
 */
public class SnakeGame extends Thread {

	boolean running = false;
//	private Snake snake;
	boolean ended = false;
	private Apple apple;
	private int score;
	private boolean paused;
	private int players;
	private GameLevel level;
	private ArrayList<Snake> snakes;

	public SnakeGame() {
		score = 0;
		paused = false;
		level = new LevelOne();
		snakes = new ArrayList<Snake>();
		apple = new Apple();

	}

	public void initSnakes(int amount) {
	
		snakes.add(new Snake(400, 400, 1));
		
		if (amount == 2) {
			snakes.add(new Snake(400, 500, 2));
		}
	}

	public ArrayList<Obstacle> getObstacles() {
		return level.getObstacles();
	}

	public Apple getApple() {
		return apple;
	}

	public ArrayList<Snake> getSnake() {
		return snakes;
	}

	@Override
	public void run() {
		System.out.println("How many players? ");
		Scanner scanner = new Scanner(System.in);
		players = Integer.parseInt(scanner.nextLine());
		this.initSnakes(players);
		this.initApple();

		MainWindow window = new MainWindow(this);
		
		startGame();
		while (isRunning()) {
			window.rePaint();
			// logiikka
			if (!paused && !this.ended) {
				for (Snake snake : snakes) {
					snake.move();
				}
				if (this.checkCollision()) {
					this.ended = true;
				}
				this.checkApple();
			}
			try {
				SnakeGame.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(SnakeGame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void checkApple() {
		for (Snake snake : snakes) {
			if (apple.eatingme(snake.getPos_x(), snake.getPos_y())) {
				snake.score += 100;
				apple.randomizePosition();
				while (!appleFits(apple.getPos_x(), apple.getPos_y())) {
					apple.randomizePosition();
				}
				snake.growSnake();
			}
		}
	}

	public void togglePause() {
		if (paused) {
			paused = false;
		} else {
			paused = true;
		}
	}

	public boolean isPaused() {
		return paused;
	}

	public boolean checkCollision() {
		for (Snake snake : snakes) {

			for (Obstacle obs : this.getObstacles()) {
				if (obs.overlap(snake.getPos_x(), snake.getPos_y())) {
					return true;
				}
			}
			if (snake.checkforCollision()) {
				return true;
			}
		}
		return false;
	}

	public boolean appleFits(int x, int y) {
		for (Obstacle obs : this.getObstacles()) {
			if (obs.overlap(x, y)) {
				return false;
			}
		}
		for (Snake snake : snakes) {
			LinkedList<SnakePart> parts = snake.getParts();
			for (SnakePart part : parts) {
				if (part.overlap(x, y)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public int getPlayers()
	{
		return players;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean hasEnded() {
		return ended;
	}

	public void endGame() {
		ended = true;
	}

	public void pauseGame() {
		running = false;
	}

	public void startGame() {
		running = true;
	}

	public String getScore() {
		return "" + score;
	}

	private void initApple() {
		while (!appleFits(apple.getPos_x(), apple.getPos_y())) {
					apple.randomizePosition();
				}
	}
}
