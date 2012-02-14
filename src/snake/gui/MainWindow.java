/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import snake.SnakeGame;

/** SnakeGame main Window class. Handles all the window related
 * stuff and takes the current snakegame as a constructor parameter
 *
 * @author Ville Heikkinen
 */
public class MainWindow {

	JFrame frame;
	private JPanel gameArea;
	private GameArea ga;
	final int size_x = 800;
	final int size_y = 600;
	private SnakeGame game;

	/** Constructor for Snake main window.
	 *  calls createGameArea() quite quickly
	 * 
	 * @param sgame Game state as a paremeter
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

		System.out.println(insets.toString());
		createGameArea();
	}

	/** Creates game area, gets ready for the game
	*
	*/
	private void createGameArea() {

		ga = new GameArea(size_x, size_y, game);
		ga.setBackground(new Color(0, 0, 0));
		ga.setVisible(true);
		ga.setFocusable(true);
		ga.requestFocus();
		ga.addKeyListener(new SnakeListener(game));
		frame.add(ga);
	}
	/**
	 *  Method for repainting the game area
	 */
	
	public void rePaint()
	{
		ga.repaint();
	}

}
