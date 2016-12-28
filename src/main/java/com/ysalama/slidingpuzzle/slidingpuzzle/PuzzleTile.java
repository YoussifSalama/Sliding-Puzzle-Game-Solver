package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PuzzleTile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6459685819551724830L;
	private int tileNumber; // The number that will display on the tile.
	private Point tilePosition; // The position of the tile.

	/**
	 * The constructor for the PuzzleTile
	 *
	 * @param tileNumber
	 *	sets the number on the tile.
	 *
	 */

	public PuzzleTile(int tileNumber, int x, int y) {
		this.setTileNumber(tileNumber);
		this.setTilePosition(new Point(x,y));
	}
	
	protected void paintComponent(Graphics g) {
	
	    super.paintComponent(g);    
	    PuzzleTileGUI();
	   
	    //Sets Font And Color
	    Font arial = new Font("Arial", Font.BOLD, 40);
	    g.setFont(arial);
	    g.setColor(Color.WHITE);
	
	    //Finds center of tile with the font used
	    FontMetrics fontMetrics = g.getFontMetrics();
	    int fontWidth = fontMetrics.stringWidth(""+getTileNumber());
	    int fontHeight= fontMetrics.getHeight();
	    int widthCenter = (this.getWidth()- fontWidth)/2;
	    int heightCenter = (this.getHeight()+fontHeight)/2;
	    
	    //Draws text on tile
	    g.drawString(""+getTileNumber(),widthCenter,heightCenter);
	   
	}  
	
	
	private void PuzzleTileGUI(){
		if(getTileNumber() == 0){
			this.setBackground(Color.WHITE);
		} else{
			this.setBackground(Color.BLACK);
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.white));
	}
	/**
	 * Two tiles are equal if they have equal tileNumbers*/
	public boolean equals(Object a){
		
		if(a == null){
			return false;
		}
		if( !(a instanceof PuzzleTile) ){
			return false;
		}
		
		PuzzleTile aTile = (PuzzleTile) a;
		return aTile.getTileNumber() == this.getTileNumber();
		
	}
	
	public boolean isEmpty(){
		return getTileNumber() == 0;
	}

	public int getTileNumber() {
		return tileNumber;
	}


	public void setTileNumber(int tileNumber) {
		this.tileNumber = tileNumber;
	}
	
	public String toString(){
		return "" + getTileNumber();
	}

	public Point getTilePosition() {
		return tilePosition;
	}

	public void setTilePosition(Point tilePosition) {
		this.tilePosition = tilePosition;
	}
	
	/**
	 * Switches the tile number with the tile number of tile given in the 
	 * argument.*/
	public void switchNumber(PuzzleTile a){
		int temp = this.tileNumber;
		this.tileNumber = a.tileNumber;
		a.tileNumber = temp;
	}

}
