/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.*;
import javax.swing.JFrame;
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
		ga = new GameArea(size_x, size_y, game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.black);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		Insets insets = frame.getInsets();
		frame.setSize(
				size_x + (insets.left + insets.right),
				size_y + (insets.top + insets.bottom));
		frame.setLayout(new CardLayout());
	}

	/** Creates menu screen, used to setup game
	*   creates a KeyListener
	*/
	
	public void createMenuScreen() {

		menu = new MenuScreen(size_x, size_y, game);
		menu.setBackground(new Color(0, 0, 0));
		menu.setVisible(true);
		menu.setFocusable(true);
		menu.requestFocus();
		menu.setBounds(0, 0, size_x, size_y);
		menu.setMinimumSize(new Dimension(800,600));
		menu.addKeyListener(new MenuScreenKeyListener(menu));
		frame.add(menu, BorderLayout.CENTER);
		frame.validate();
	}
	/**
	 *  Just show the menu instead of creating it
	 */
	
	public void showMenu()
	{
		game.pauseGame();
		frame.remove(ga);
		ga.setFocusable(false);
		ga.setVisible(false);
		menu.setFocusable(true);
		menu.requestFocus();
		frame.add(menu);
		frame.validate();
		frame.repaint();
	}
	/**
	 *  Method for closing down the menu
	 */
	
	public void closeMenu()
	{
		menu.setFocusable(false);
		frame.remove(menu);
		frame.validate();
		frame.repaint();

	}
	/**
	 *  Create game area, associate KeyDispatcher with it
	 */
		
	public void createGameArea() {

		keymanager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		keymanager.addKeyEventDispatcher(new SnakeKeyDispatcher(game));
		ga.setBackground(new Color(0, 0, 0));
		ga.setFocusable(true);
		ga.requestFocus();
		ga.setBounds(0, 0, size_x, size_y);
		frame.add(ga, BorderLayout.CENTER);
		frame.setVisible(true);
		ga.setVisible(true);
	}
	/**
	 *  Method for repainting the game area, the game should call this
	 *  method
	 */
	public void rePaint()
	{
		ga.repaint();
	}
}