/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import snake.gui.MainWindow;

/**
 *
 * @author villheik
 */
public class SnakeGame extends Thread {

	private ArrayList<Obstacle> obstacles;
	//private ArrayList<Game> snake;
	boolean running = false;
	private Snake snake;
	boolean ended = false;
	private Apple apple;
	private int score;
	private boolean paused;

	public SnakeGame() {
		obstacles = new ArrayList<Obstacle>();
		Obstacle ylareuna = new Obstacle(0, 0, 800, 20);
		Obstacle alareuna = new Obstacle(0, 580, 800, 20);
		Obstacle keski = new Obstacle(300, 300, 100, 100);
		Obstacle vasreuna = new Obstacle(0, 20, 20, 560);
		Obstacle oikreuna = new Obstacle(780, 20, 20, 560);

		snake = new Snake(200, 200);
		apple = new Apple(400, 400);
		score = 0;
		paused = false;

		obstacles.add(oikreuna);
		obstacles.add(ylareuna);
		obstacles.add(alareuna);
		obstacles.add(vasreuna);
		obstacles.add(keski);

	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public Apple getApple() {
		return apple;
	}

	public Snake getSnake() {
		return snake;
	}

	@Override
	public void run() {
		MainWindow window = new MainWindow(this);
		System.out.println("Testi");
		startGame();
		while (isRunning()) {
			window.rePaint();
			// logiikka
			if (!paused && !this.ended) {
				this.snake.move();
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
		if (apple.eatingme(snake.getPos_x(), snake.getPos_y())) {
			score += 100;
			apple.randomizePosition();
			while(!appleFits(apple.getPos_x(), apple.getPos_y()))
			{
				apple.randomizePosition();
			}
			snake.growSnake();
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
		for (Obstacle obs : obstacles) {
			if (obs.overlap(snake.getPos_x(), snake.getPos_y())) {
				return true;
			}
		}
		if (snake.checkforCollision()) {
			return true;
		}
		return false;
	}

	public boolean appleFits(int x, int y) {
		for (Obstacle obs : obstacles) {
			if (obs.overlap(x, y)) {
				return false;
			}
		}
		LinkedList<SnakePart> parts = snake.getParts();
		for (SnakePart part : parts) {
			if (part.overlap(x, y)) {
				return false;
			}
		}
		return true;
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
}
