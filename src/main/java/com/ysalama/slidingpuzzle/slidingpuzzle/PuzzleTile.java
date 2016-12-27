package com.ysalama.slidingpuzzle.slidingpuzzle;

public class PuzzleTile {
	private int tileNumber; // The number that will display on the tile.
	//private Point tilePosition; // The position of the tile.

	/**
	 * The constructor for the PuzzleTile
	 *
	 * @param tileNumber
	 *	sets the number on the tile.
	 *
	 */

	public PuzzleTile(int tileNumber) {
		this.setTileNumber(tileNumber);
		//this.tilePosition = new Point(x,y);
	}
	
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

}
