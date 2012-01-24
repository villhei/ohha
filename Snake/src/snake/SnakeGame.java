/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;
import snake.gui.MainWindow;

/**
 *
 * @author villheik
 */
public class SnakeGame {
	
	private ArrayList<Obstacle> obstacles;
	//private ArrayList<Game> snake;
	boolean started = false;
	private Snake snake;
	
	public SnakeGame()
	{
		obstacles = new ArrayList<Obstacle>();
		//snake = new ArrayList<Game>();
		Obstacle ylareuna = new Obstacle(0, 0, 800, 20);
		Obstacle alareuna = new Obstacle(0, 580, 800, 20);
		Obstacle vasreuna = new Obstacle(0, 20, 20, 560);
		Obstacle oikreuna = new Obstacle(780, 20, 20, 560);
		
		snake = new Snake(40, 40);
		
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
	public void run()
	{
		MainWindow window = new MainWindow(this);
	}
	
	
}
