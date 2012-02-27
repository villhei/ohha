/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import snake.SnakeGame;
/**
 *  Game menu screen, extends JPanel
 * 
 */

public class MenuScreen extends JPanel {

	private int size_x;
	private int size_y;
	private SnakeGame game;
	private ArrayList<MenuItem> menuitems;
	private int focus = 0;
	private int levelnumber = 1;
	
	/**
	 *  Consturctor for the menuscreen
	 * @param x x size
	 * @param y y size 
	 * @param sgame SnakeGame snake
	 */

	public MenuScreen(int x, int y, SnakeGame sgame) {
		this.size_x = x;
		this.size_y = y;
		this.game = sgame;
		this.menuitems = new ArrayList<MenuItem>();
		this.setSize(size_x, size_y);

		menuitems.add(new MenuItem(100, 400, "START GAME", 0));
		menuitems.add(new MenuItem(100, 400, "PLAYERS: " + game.getPlayers(), 1));
		menuitems.add(new MenuItem(100, 400, "LEVEL: " + levelnumber, 2));
		menuitems.add(new MenuItem(100, 400, "QUIT", 3));

	}
	/**
	 *  Debug tool for menuscreen
	 * @return menuscreen dimensions as string
	 */

	@Override
	public String toString() {
		Dimension blaa = this.getSize();
		return "MenuScreen x: " + blaa.width + ", y: " + blaa.height;
	}

	/**
	 * Method to paint the menu
	 *
	 * @param Graphics as a parameter
	 */
	@Override
	public void paint(Graphics gfx) {
		super.paint(gfx);
		drawMenuElements(gfx);
	}

	private void drawMenuElements(Graphics g) {
		int startx = 50;
		int starty = 0;
		for (MenuItem item : menuitems) {
			starty += item.height;
			startx += 30;
			drawMenuItem(g, item, startx, starty);
		}

	}
	/**
	 *  Move keyboard focus up
	 */

	public void moveFocusUp() {
		if (focus > 0) {
			focus--;
			this.repaint();
		}
	}
	/**
	 *  Move keyboard focus down
	 */

	public void moveFocusDown() {
		if (focus < 4) {
			focus++;
			this.repaint();
		}
	}
	/**
	 *  Perform the action associated with the focused menu item
	 */

	public void performAction() {
		if (focus == 0) {
			game.startGame(levelnumber - 1);
		}

		if (focus == 3) {
			System.exit(0);
		}
	}
	/**
	 *  Add a player to the game
	 */

	public void addPlayer() {
		if (focus == 1) {
			game.addPlayer();
			menuitems.get(1).setText("PLAYERS: " + game.getPlayers());
			this.repaint();
		}
	}
	/**
	 *  Remove a player from the game
	 */

	public void removePlayer() {
		if (focus == 1) {
			game.removePlayer();
			menuitems.get(1).setText("PLAYERS: " + game.getPlayers());
			this.repaint();
		}
	}
	/**
	 *  Grow level number
	 */

	public void levelUp() {
		if (focus == 2) {
			if (levelnumber < game.getLevelAmount()) {
				levelnumber++;
				menuitems.get(2).setText("LEVEL: " + levelnumber);
				this.repaint();
			}
		}
	}
	/**
	 *  Shrink the level number
	 */

	public void levelDown() {
		if (focus == 2) {
			if (levelnumber > 1) {
				levelnumber--;
				menuitems.get(2).setText("LEVEL: " + (levelnumber));
				this.repaint();
			}
		}
	}

	/**
	 *  Private class for menuitems and their drawings
	 */
	private class MenuItem {

		private int height;
		private int width;
		private String text;
		public boolean focus;
		private int number;

		public MenuItem(int height, int width, String text, int number) {
			this.number = number;
			this.height = height;
			this.width = width;
			this.text = text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}

	private void drawMenuItem(Graphics g, MenuItem item, int startx, int starty) {
		Font font = new Font("Arial Black", 1, 30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(item.getText(), startx + 50, starty + 20);
		if (item.number == focus) {
			g.setColor(Color.BLUE);
			g.fillRect(startx, starty, 20, 20);
		}
		g.setColor(Color.red);
		g.fillRect(startx, starty + 50, 400, 20);

	}
}