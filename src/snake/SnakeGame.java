/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.*;
import snake.gui.MainWindow;

/** SnakeGame main game class, extends Thread
 *
 * 
 */
public class SnakeGame extends Thread {

	boolean running = false;
//	private Snake snake;
	boolean ended = false;
	private Apple apple;
	private boolean paused;
	private int players;
	private int deadSnakes;
	private GameLevel level;
	protected int MAX_PLAYERS = 3;
	private long INITIAL_DELAY = 100;
	private long GAME_DELAY;
	private MainWindow window;
	private Timer timer;
	private int activemap;
	private ArrayList<GameLevel> levels;

	/**
	 * Parameterless constructor, sets game's intial state
	 * and variables to default values
	 */
	public SnakeGame() {

		paused = false;
		levels = new ArrayList<GameLevel>();
		levels.add(new LevelOne());
		levels.add(new LevelTwo());
		players = 1;
		deadSnakes = 0;
		GAME_DELAY = INITIAL_DELAY;

	}
	/**
	 *  Initialize snakes for the level
	 *  amount should be the amount of players in game
	 * @param amount amount of players
	 */

	public void initSnakes(int amount) {
		level.initSnakes(amount);
	}

	/** Request the list of obstacles in the active level
	 * 
	 * @return ArrayList of obstacles
	 */
	public ArrayList<Obstacle> getObstacles() {
		return level.getObstacles();
	}
	/** Return the current apple for drawing, etc
	 * 
	 * @return active apple
	 */
	public Apple getApple() {
		return apple;
	}
	/**
	 *  Requests a list of snakes from the gamelevel
	 * @return ArrayList of snakes 
	 */

	public ArrayList<Snake> getSnake() {
		return level.getSnakes();
	}
	/** 
	 *  Run method for the game, creates main window
	 *  and creates menuscreen
	 */

	@Override
	public void run() {
		window = new MainWindow(this);
		window.createMenuScreen();
	}

	private void runGameCycle() {
		if (running && !paused) {
			moveSnakes();
			checkSnakeCollisions();
			this.checkApple();
		}
		window.rePaint();

	}

	/**
	 * After menu has set the settings for the game use this to fire up the game
	 * along with appropriate game area
	 *
	 * Handles closing menu, too.
	 */
	public void startGame(int level) {
		activemap = level;
		deadSnakes = 0;
		this.level = levels.get(level);
		this.running = true;
		this.initSnakes(players);
		this.setDelayHandicap(players);
		this.initApple();
		window.closeMenu();
		window.createGameArea();
		TimerTask gameCycle = new TimerTask() {

			@Override
			public void run() {
				runGameCycle();
			}
		};

		timer = new Timer();
		timer.schedule(gameCycle, new Date(), GAME_DELAY);
	}
	/**
	 *  Call for game restart, resets the current level to
	 *  original state
	 */

	public void restartGame() {
		timer.cancel();
		timer.purge();
		ended = false;
		paused = false;
		startGame(activemap);
	}

	private void initApple() {
		apple = new Apple();
		while (!appleFits(apple.getPos_x(), apple.getPos_y())) {
			apple.randomizePosition();
		}
	}

	private void setDelayHandicap(int players) {
		if (players > 1) {
			GAME_DELAY = INITIAL_DELAY + (INITIAL_DELAY / 4) * (players - 1);
		}
	}

	private void moveSnakes() {
		if (!paused && !this.ended) {
			for (Snake snake : level.getSnakes()) {
				if (snake.alive()) {
					snake.move();
				}
			}
		}
	}

	private void checkApple() {
		for (Snake snake : level.getSnakes()) {
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
	/** Toggle games paused state, stops movement in main loop
	 * 
	 */

	public void togglePause() {
		if (paused) {
			paused = false;
		} else {
			paused = true;
		}
	}
	/**
	 *  Is the game paused
	 * @return true if paused, otherwise false
	 */

	public boolean isPaused() {
		return paused;
	}

	private void checkSnakeCollisions() {
		for (int i = 0; i < this.players; ++i) {
			if (level.getSnakes().get(i).alive()) {
				if (this.checkForSnakeCollision(level.getSnakes().get(i))) {
					level.getSnakes().get(i).die();
					deadSnakes++;
					if (deadSnakes == players) {
						endGame();
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
			if (level.getSnakes().get(i).checkforCollision(snake.getPos_x(), snake.getPos_y())) {
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
		for (Snake snake : level.getSnakes()) {
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
	
	/**
	 *  Add a player to the game, not added if exceeds maximum value
	 */

	public void addPlayer() {
		if (players + 1 <= MAX_PLAYERS) {
			players++;
		}
	}
	/**
	 *  Remove player from the game, not removed if less than 1
	 */

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
		paused = true;
	}

	public int getLevelAmount() {
		return levels.size();
	}
}