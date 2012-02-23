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

public class MenuScreen extends JPanel {

	private int size_x;
	private int size_y;
	private SnakeGame game;
	private ArrayList<MenuItem> menuitems;
	private int focus = 0;

	public MenuScreen(int x, int y, SnakeGame sgame) {
		this.size_x = x;
		this.size_y = y;
		this.game = sgame;
		this.menuitems = new ArrayList<MenuItem>();
		this.setSize(size_x, size_y);
		
		menuitems.add(new MenuItem(100, 400, "START GAME", 0));
		menuitems.add(new MenuItem(100, 400, "PLAYERS: " + game.getPlayers(), 1));
		menuitems.add(new MenuItem(100, 400, "QUIT", 2));

	}

	@Override
	public String toString() {
		Dimension blaa = this.getSize();
		return "MenuScreen x: " + blaa.width + ", y: " + blaa.height;
	}

	/** Method to paint the window
	 *  Used for repainting the game state
	 * @param Graphics as a parameter
	 */
	
	@Override
	public void paint(Graphics gfx) {
		super.paint(gfx);
		drawMenuElements(gfx);
		System.out.println("focus: " + focus);
	}

	private void drawMenuElements(Graphics g) {
		int startx = 50;
		int starty = 0;
		for(MenuItem item : menuitems)
		{
			starty += item.height;
			drawMenuItem(g, item, startx, starty);
		}

	}
	
	public void moveFocusUp()
	{
		if(focus > 0)
		{
			focus--;
			this.repaint();
		}
	}
	
	public void moveFocusDown()
	{
		if(focus <= 3)
		{
			focus++;
			this.repaint();
		}
	}
	
	public void performAction()
	{
		if(focus == 0)
		{
			game.startGame();
		}
		
		if(focus == 2)
		{
			System.exit(0);
		}
	}
	
	public void addPlayer()
	{
		if(focus == 1)
		{
			game.addPlayer();
			menuitems.get(1).setText("PLAYERS: " + game.getPlayers());
			this.repaint();
		}			
	}
	
	public void removePlayer()
	{
		if(focus == 1)
		{
			game.removePlayer();
			menuitems.get(1).setText("PLAYERS: " + game.getPlayers());
			this.repaint();
		}
	}
	
	private class MenuItem
	{
		private int height;
		private int width;
		private String text;
		public boolean focus;
		private int number;
		
		public MenuItem(int height, int width, String text, int number)
		{
			this.number = number;
			this.height = height;
			this.width = width;
			this.text = text;
		}
		
		public void setText(String text)
		{
			this.text = text;
		}
		
		public String getText()
		{
			return this.text;
		}
	}
	
	private void drawMenuItem(Graphics g, MenuItem item, int startx, int starty) {
		Font font = new Font("Arial Black", 1, 30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(item.getText(), startx + 50 , starty+20);
		if(item.number == focus)
		{
			g.setColor(Color.BLUE);
			g.fillRect(startx, starty, 20, 20);
		}
		g.setColor(Color.red);
		g.fillRect(startx, starty +50, 400, 20);

	}
}
