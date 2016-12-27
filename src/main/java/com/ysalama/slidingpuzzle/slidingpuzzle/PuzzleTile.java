package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.Point;

public class PuzzleTile {
	private int tileNumber; // The number that will display on the tile.
	private Point tilePosition; // The position of the tile.

	/**
	 * The constructor for the PuzzleTile
	 *
	 * @param tileNumber
	 *	sets the number on the tile.
	 *
	 * @param x
	 * 	sets X coordinate.
	 * 
	 * @param y
	 *	sets Y coordinate
	 */

	public PuzzleTile(int tileNumber, int x, int y) {
		this.setTileNumber(tileNumber);
		this.tilePosition = new Point(x,y);
	}


	public int getTileNumber() {
		return tileNumber;
	}


	public void setTileNumber(int tileNumber) {
		this.tileNumber = tileNumber;
	}

	/**
	 * Returns the X coordinate of the tile
	 * 
	 */
	public double getTilePositionX() {
		return tilePosition.getX();
	}
	
	/**
	 * Returns the Y coordinate of the tile
	 * 
	 */
	public double getTilePositionY() {
		return tilePosition.getY();
	}
	
	/**
	 * Set the position of the tile to a specified position.
	 * @param tilePosition
	 *            For example, if you want to set the tile position to the
	 *            coordinate (1,0), you can do the following:
	 *            setTilePosition(new Point(1,0));
	 * 
	 */

	public void setTilePosition(Point tilePosition) {
		this.tilePosition = tilePosition;
	}



}
