/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/** Interface class for game levels
 * 
 * 
 */
public interface GameLevel {
	
	/** Method for returning obstacles
	 *  
	 * @return return list of obstacles
	 */
	public ArrayList<Obstacle> getObstacles();
	
	/** Method for returning snakes
	 * 
	 * @return return list of snakes
	 */
	public ArrayList<Snake> getSnakes();
	
	/** Force snake reset, used to restart game
	 *  
	 * @param amount amount of snakes,
	 * use the amount of players
	 */
	
	public void initSnakes(int amount);
	
}