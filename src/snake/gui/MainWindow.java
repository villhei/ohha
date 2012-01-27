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

/**
 *
 * @author villheik
 */
public class MainWindow {

	JFrame frame;
	private JPanel gameArea;
	private GameArea ga;
	final int size_x = 800;
	final int size_y = 600;
	private SnakeGame game;

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

	private void createGameArea() {

		ga = new GameArea(size_x, size_y, game);
		ga.setBackground(new Color(0, 0, 0));
		ga.setVisible(true);
		ga.setFocusable(true);
		ga.requestFocus();
		ga.addKeyListener(new SnakeListener(game));
		frame.add(ga);
	}
	
	public  void rePaint()
	{
		ga.repaint();
	}

}
