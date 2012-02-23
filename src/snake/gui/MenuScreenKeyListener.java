/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ville Heikkinen
 */
public class MenuScreenKeyListener implements KeyListener {

	private MenuScreen menu;

	public MenuScreenKeyListener(MenuScreen menu) {
		this.menu = menu;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			menu.moveFocusUp();
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			menu.removePlayer();
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			menu.moveFocusDown();
		}

		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			menu.addPlayer();
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_ENTER)
		{
			menu.performAction();
		}
	}
}
