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
public class SnakeGame extends Thread{
	
	private ArrayList<Obstacle> obstacles;
	//private ArrayList<Game> snake;
	boolean running = false;
	private Snake snake;
	boolean ended = false;
	
	public SnakeGame()
	{
		obstacles = new ArrayList<Obstacle>();
		//snake = new ArrayList<Game>();
		Obstacle ylareuna = new Obstacle(0, 0, 800, 20);
		Obstacle alareuna = new Obstacle(0, 580, 800, 20);
		Obstacle vasreuna = new Obstacle(0, 20, 20, 560);
		Obstacle oikreuna = new Obstacle(780, 20, 20, 560);
		
		snake = new Snake(200, 200);
		
		obstacles.add(oikreuna);
		obstacles.add(ylareuna);
		obstacles.add(alareuna);
		obstacles.add(vasreuna);
		
	}
	
	public ArrayList<Obstacle> getObstacles()
	{
		return obstacles;
	}
	
	public Snake getSnake()
	{
		return snake;
	}
	
	@Override
	public void run()
	{
		MainWindow window = new MainWindow(this);
		System.out.println("Testi");
		startGame();
		
		while(isRunning()) {
			// logiikka
			this.snake.move();
			try {
			SnakeGame.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(SnakeGame.class.getName()).log(Level.SEVERE, null, ex);
			}
			// piirtely
			window.rePaint();
			
		}
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public boolean hasEnded()
	{
		return ended;
	}
	
	public void endGame()
	{
		ended = true;
	}
	
	public void pauseGame()
	{
		running = false;
	}
	
	public void startGame()
	{
		running = true;
	}
	
	
}
