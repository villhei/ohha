package snake.gui;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import snake.Snake;
import snake.SnakeGame;

/**
 *  Class handling all the snake games key input related to gameplay
 * 
 * @author villheik
 */

public class SnakeKeyDispatcher implements KeyEventDispatcher {

	private SnakeGame game;

	/**
	 *  Constructor for the games keydispatcher
	 * @param SnakeGame game 
	 */
	public SnakeKeyDispatcher(SnakeGame game) {
		this.game = game;
	}

	/**
	 * Send keyEvent to the game, statically filtered
	 * values for actions
	 * @param KeyEvent event
	 * @return true in any case
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			ArrayList<Snake> snakes = game.getSnake();

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				game.togglePause();
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				game.restartGame();
			}

			keyPressesForPlayer1(e, snakes.get(0));

			if (game.getPlayers() > 1) {
				keyPressesForPlayer2(e, snakes.get(1));
			}
			if (game.getPlayers() > 2) {
				keyPressesForPlayer3(e, snakes.get(2));
			}
		}
		return true;
	}

	private void keyPressesForPlayer1(KeyEvent ke, Snake snake) {
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			if (snake.getDirection() != 2) {
				snake.setDirection(0);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			if (snake.getDirection() != 1) {
				snake.setDirection(3);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if (snake.getDirection() != 0) {
				snake.setDirection(2);
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (snake.getDirection() != 3) {
				snake.setDirection(1);
			}
		}
	}

	private void keyPressesForPlayer2(KeyEvent ke, Snake snake) {
		if (ke.getKeyCode() == KeyEvent.VK_W) {
			if (snake.getDirection() != 2) {
				snake.setDirection(0);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_A) {
			if (snake.getDirection() != 1) {
				snake.setDirection(3);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_S) {
			if (snake.getDirection() != 0) {
				snake.setDirection(2);
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_D) {
			if (snake.getDirection() != 3) {
				snake.setDirection(1);
			}
		}
	}

	private void keyPressesForPlayer3(KeyEvent ke, Snake snake) {
		if (ke.getKeyCode() == KeyEvent.VK_I) {
			if (snake.getDirection() != 2) {
				snake.setDirection(0);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_J) {
			if (snake.getDirection() != 1) {
				snake.setDirection(3);
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_K) {
			if (snake.getDirection() != 0) {
				snake.setDirection(2);
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_L) {
			if (snake.getDirection() != 3) {
				snake.setDirection(1);
			}
		}
	}
}