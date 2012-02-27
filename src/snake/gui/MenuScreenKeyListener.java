/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Menu screen's key listeners
 * @author Ville Heikkinen
 */
public class MenuScreenKeyListener implements KeyListener {

	private MenuScreen menu;

	/**
	 *  Takes the menuscreen as a parameter
	 * @param menu 
	 */
	public MenuScreenKeyListener(MenuScreen menu) {
		this.menu = menu;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}
	/**
	 *  When key is released, call menu with the desired action
	 * @param KeyEvent
	 */
	@Override
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			menu.moveFocusUp();
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			menu.levelDown();
			menu.removePlayer();
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			menu.moveFocusDown();
		}

		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			menu.levelUp();
			menu.addPlayer();
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_ENTER)
		{
			menu.performAction();
		}
	}
}