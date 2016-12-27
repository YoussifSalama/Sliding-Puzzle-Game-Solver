package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.Point;

public class PuzzleTile {
	private int tileNumber; // The number that will display on the tile.
	//private Point tilePosition; // The position of the tile.

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

	public PuzzleTile(int tileNumber) {
		this.setTileNumber(tileNumber);
		//this.tilePosition = new Point(x,y);
	}


	public int getTileNumber() {
		return tileNumber;
	}


	public void setTileNumber(int tileNumber) {
		this.tileNumber = tileNumber;
	}



}
