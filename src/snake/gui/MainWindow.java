/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import snake.SnakeGame;

/** SnakeGame main Window class. Handles all the window related
 * stuff and takes the current snakegame as a constructor parameter
 *
 * @author Ville Heikkinen
 */
public class MainWindow{

	JFrame frame;
	private MenuScreen menu;
	private GameArea ga;
	final int size_x = 800;
	final int size_y = 600;
	private JPanel cards;
	private SnakeGame game;
	private KeyboardFocusManager keymanager;

	/** Constructor for Snake main window.
	 *  calls createGameArea() quite quickly
	 * 
	 * @param sgame Game state as param
	 */
	public MainWindow(SnakeGame sgame) {
		game = sgame;
		frame = new JFrame("Mighty Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.white);
		frame.setVisible(true);
		Insets insets = frame.getInsets();
		frame.setSize(
				size_x + (insets.left + insets.right),
				size_y + (insets.top + insets.bottom));
	}

	/** Creates game area, gets ready for the game
	*
	*/
	
	public void createMenuScreen() {

		menu = new MenuScreen(size_x, size_y, game);
		menu.setBackground(new Color(0, 0, 0));
		menu.setVisible(true);
		menu.setFocusable(true);
		menu.requestFocus();
		menu.addKeyListener(new MenuScreenKeyListener(menu));
		frame.getContentPane().add(menu);
		frame.validate();
	}
	
	public void closeMenu()
	{
		System.out.println("suljin ja silleen");
		frame.setVisible(false);
		menu.setFocusable(false);
		menu.setVisible(false);
		menu = null;
		frame.getContentPane().removeAll();

		frame.repaint();

	}
		
	public void createGameArea() {

		keymanager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		keymanager.addKeyEventDispatcher(new SnakeKeyDispatcher(game));
		
		frame.setBackground(Color.white);
		ga = new GameArea(size_x, size_y, game);
		ga.setBackground(new Color(0, 0, 0));
		ga.setVisible(true);
		ga.setFocusable(true);
		ga.requestFocus();
		frame.add(ga);
		frame.validate();
		frame.setVisible(true);
	}
	/**
	 *  Method for repainting the game area
	 */
	public void rePaint()
	{
		frame.repaint();
	}
}