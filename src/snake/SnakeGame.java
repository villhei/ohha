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

	boolean running = false;
//	private Snake snake;
	boolean ended = false;
	private Apple apple;
	private int score;
	private boolean paused;
	private int players;
	private int deadSnakes;
	private GameLevel level;
	private ArrayList<Snake> snakes;
	protected int MAX_PLAYERS = 3;
	private long GAME_DELAY;
	private MainWindow window;

	public SnakeGame() {
		score = 0;
		paused = false;
		level = new LevelOne();
		snakes = new ArrayList<Snake>();
		apple = new Apple();
		players = 1;
		deadSnakes = 0;
		GAME_DELAY = 100;

	}

	public void initSnakes(int amount) {
		snakes.add(new Snake(400, 200, 1));

		if (amount > 1) {
			snakes.add(new Snake(400, 300, 2));
		}
		if (amount > 2) {
			snakes.add(new Snake(400, 400, 3));
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
		window = new MainWindow(this);
		window.createMenuScreen();
	}

	public void runGame() {

		while (isRunning()) {
			window.rePaint();
			moveSnakes();
			checkSnakeCollisions();
			this.checkApple();
			try {
				SnakeGame.sleep(GAME_DELAY);
			} catch (InterruptedException ex) {
				Logger.getLogger(SnakeGame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/** After menu has set the settings for the game
	 *  use this to fire up the game along with
	 *  appropriate game area
	 * 
	 *  Handles closing menu, too.
	 */
	public void startGame() {

		this.running = true;
		this.initSnakes(players);
		this.addDelayHandicap(players);
		this.initApple();
		window.closeMenu();
		window.createGameArea();
		runGame();
	}

	private void initApple() {
		while (!appleFits(apple.getPos_x(), apple.getPos_y())) {
			apple.randomizePosition();
		}
	}

	private void addDelayHandicap(int players) {
		if (players > 1) {
			GAME_DELAY = GAME_DELAY + (GAME_DELAY / 4) * (players - 1);
			System.out.println("GAME_DELAY: " + GAME_DELAY);
		}
	}

	private void moveSnakes() {
		if (!paused && !this.ended) {
			for (Snake snake : snakes) {
				if (snake.alive()) {
					snake.move();
				}
			}
		}
	}

	private void checkApple() {
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
		System.out.println("toggle");
		if (paused) {
			System.out.println("false");
			paused = false;
		} else {
			System.out.println("true");
			paused = true;
		}
	}

	public boolean isPaused() {
		return paused;
	}

	private void checkSnakeCollisions() {
		for (int i = 0; i < this.players; ++i) {
			if (snakes.get(i).alive()) {
				if (this.checkForSnakeCollision(snakes.get(i))) {
					snakes.get(i).die();
					deadSnakes++;
					if (deadSnakes == players) {
						this.ended = true;
					}
				}
			}
		}
	}

	private boolean checkForSnakeCollision(Snake snake) {
		for (Obstacle obs : this.getObstacles()) {
			if (obs.overlap(snake.getPos_x(), snake.getPos_y())) {
				System.out.println("snake: " + snake + " törmäs");
				return true;
			}
		}
		for (int i = 0; i < this.players; ++i) {
			if (snakes.get(i).checkforCollision(snake.getPos_x(), snake.getPos_y())) {
				return true;
			}
		}
		return false;
	}

	private boolean appleFits(int x, int y) {
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

	public int getPlayers() {
		return players;
	}

	public void addPlayer() {
		if (players + 1 <= MAX_PLAYERS) {
			players++;
		}
	}

	public void removePlayer() {
		if (players - 1 > 0) {
			players--;
		}
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
}