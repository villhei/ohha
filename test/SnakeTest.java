/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import snake.Snake;
import snake.SnakeGame;

/**
 *
 * @author villheik
 */
public class SnakeTest {

	public SnakeTest() {
	}

	@Test
	public void liikkuukoMatoYlös() {
		SnakeGame matopeli = new SnakeGame();
		matopeli.getSnake().setDirection(0);
		Snake mato = matopeli.getSnake();
		assertEquals("mato ei ottanut suuntaa", mato.getDirection(), 0);

	}

	@Test
	public void liikkuukoMatoAlas() {
		SnakeGame matopeli = new SnakeGame();
		matopeli.getSnake().setDirection(2);
		Snake mato = matopeli.getSnake();
		assertEquals("mato ei ottanut suuntaa", mato.getDirection(), 2);

	}

	@Test
	public void liikkuukoMatoOikealle() {
		SnakeGame matopeli = new SnakeGame();
		matopeli.getSnake().setDirection(1);
		Snake mato = matopeli.getSnake();
		assertEquals("mato ei ottanut suuntaa", mato.getDirection(), 1);

	}

	@Test
	public void liikkuukoMatoVasemmalle() {
		SnakeGame matopeli = new SnakeGame();
		matopeli.getSnake().setDirection(3);
		Snake mato = matopeli.getSnake();
		assertEquals("mato ei ottanut suuntaa", mato.getDirection(), 3);

	}

	@Test
	public void kasvaakoMato() {
		SnakeGame matopeli = new SnakeGame();
		matopeli.getSnake().growSnake();
		Snake mato = matopeli.getSnake();
		assertEquals("mato ei kasvanut", mato.getLength(), 5);
	}
	
}
