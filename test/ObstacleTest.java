/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import snake.Obstacle;

/**
 *
 * @author villheik
 */
public class ObstacleTest {
	
	public ObstacleTest() {
	}

	@Test
	public void testaaSyntyykoOBstacleOikein() {
		Obstacle obst = new Obstacle(100,100,100,100);
		
		assertEquals("x-Koko ei ollut oikein", 100, obst.getSize_x());
		assertEquals("y-koko ei ollut oikein", 100, obst.getSize_y());
		assertEquals("x-koordinaatti ei ollit oikein", 100, obst.getStart_x());
		assertEquals("y-koordinaatti ei ollut oikein", 100, obst.getStart_y());
		
	}
	
	@Test
	public void obstacleReagoiVirheeseenOikei() {
		Obstacle obst = new Obstacle(900,900,-100,-100);
		
		assertEquals("x-Koko ei ollut oikein", 100, obst.getSize_x());
		assertEquals("y-koko ei ollut oikein", 100, obst.getSize_y());
		assertEquals("x-koordinaatti ei ollit oikein", 0, obst.getStart_x());
		assertEquals("y-koordinaatti ei ollut oikein", 0, obst.getStart_y());
		
	}
}
