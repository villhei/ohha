/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.*;
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
	}
	
	public void closeMenu()
	{
		menu.setFocusable(false);
		menu.setVisible(false);
		Container contentPane = frame.getContentPane();
		contentPane.removeAll();

	}
		
	public void createGameArea() {

		keymanager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		keymanager.addKeyEventDispatcher(new SnakeKeyDispatcher(game));
		Container contentPane = frame.getContentPane();
		ga = new GameArea(size_x, size_y, game);
		ga.setBackground(new Color(0, 0, 0));
		ga.setVisible(true);
		ga.setFocusable(true);
		ga.requestFocus();
		contentPane.add(ga);
		contentPane.invalidate();
		contentPane.repaint();
		contentPane.setVisible(true);
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