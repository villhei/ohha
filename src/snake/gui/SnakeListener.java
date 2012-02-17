/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import snake.Snake;
import snake.SnakeGame;

/**
 *
 * @author villheik
 */
public class SnakeListener implements KeyListener {

	private SnakeGame game;

	public SnakeListener(SnakeGame sgame) {
		this.game = sgame;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	@Override
	public void keyPressed(KeyEvent ke) {

		ArrayList<Snake> snakes = game.getSnake();


		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			if (snakes.get(0).getDirection() != 2) {
				snakes.get(0).setDirection(0);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			if (snakes.get(0).getDirection() != 1) {
				snakes.get(0).setDirection(3);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if (snakes.get(0).getDirection() != 0) {
				snakes.get(0).setDirection(2);
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (snakes.get(0).getDirection() != 3) {
				snakes.get(0).setDirection(1);
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			game.togglePause();
		}

		if (game.getPlayers() == 2) {
			if (ke.getKeyCode() == KeyEvent.VK_W) {
				if (snakes.get(1).getDirection() != 2) {
					snakes.get(1).setDirection(0);
				}
			}

			if (ke.getKeyCode() == KeyEvent.VK_A) {
				if (snakes.get(1).getDirection() != 1) {
					snakes.get(1).setDirection(3);
				}
			}

			if (ke.getKeyCode() == KeyEvent.VK_S) {
				if (snakes.get(1).getDirection() != 0) {
					snakes.get(1).setDirection(2);
				}

			}
			if (ke.getKeyCode() == KeyEvent.VK_D) {
				if (snakes.get(1).getDirection() != 3) {
					snakes.get(1).setDirection(1);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
	}
}
