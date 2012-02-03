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
			if(game.getSnake().getDirection() != 2)
				game.getSnake().setDirection(0);
			System.out.println(game.getSnake());
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			if(game.getSnake().getDirection() != 1)
			game.getSnake().setDirection(3);
			System.out.println(game.getSnake());
		}

		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if(game.getSnake().getDirection() != 0)
			game.getSnake().setDirection(2);
			System.out.println(game.getSnake());

		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(game.getSnake().getDirection() != 3)
			game.getSnake().setDirection(1);
			System.out.println(game.getSnake());
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
	}
	
}
