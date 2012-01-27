/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snake.SnakeGame;

/**
 *
 * @author villheik
 */
public class SnakeListener implements KeyListener {
	
	private SnakeGame game;
	
	public SnakeListener(SnakeGame sgame)
	{
		this.game = sgame;
	}
	@Override
	public void keyTyped(KeyEvent ke) {
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			game.getSnake().setDirection(0);
			System.out.println(game.getSnake());
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			game.getSnake().setDirection(3);
			System.out.println(game.getSnake());
		}

		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			game.getSnake().setDirection(2);
			System.out.println(game.getSnake());

		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.getSnake().setDirection(1);
			System.out.println(game.getSnake());
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
	}
	
}
