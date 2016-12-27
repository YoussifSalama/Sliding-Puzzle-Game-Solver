package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBoard {
	final static int ABOVE = 1;
	final static int BELOW = 2;
	final static int LEFT = 3;
	final static int RIGHT = 4;
	final static int UNMOVABLE = -1;
	
	private PuzzleTile [][] board;
	private int size;
	
	public PuzzleBoard(int size){
		this.size = size;
		board = new PuzzleTile[size][size];
		
		ArrayList<Integer> tileNumbersList = new ArrayList<Integer>();
		//Add numbers from 0 to size*size - 1.
		for(int i = 0; i< size*size; i++){
			tileNumbersList.add(i);
		}
		
		//Shuffle the list.
		Collections.shuffle(tileNumbersList);
		
		//Creates new tiles with the shuffled tileNumbers array.
		for(int x = 0; x<size; x++){
			for(int y = 0; y<size; y++){
				board[x][y] = new PuzzleTile(tileNumbersList.remove(0));
			}
		}
		
	}
	
	public String toString(){
		
		String result = "";
		for(int x = 0; x<size; x++){
			for(int y = 0; y<size; y++){
				result = result + getPuzzleTile(x,y).toString() + "\t";
			}
			result = result + "\n";
		}
		return result;
	}
	
	//A tile can move if one of the tiles around it is the 0 tile.
	private int canTileMove(int x, int y){
		PuzzleTile emptyTile = new PuzzleTile(0);
		
		PuzzleTile above = getPuzzleTile(x,y+1);
		PuzzleTile below = getPuzzleTile(x,y-1);
		PuzzleTile left = getPuzzleTile(x-1,y);
		PuzzleTile right = getPuzzleTile(x+1,y);
		
		boolean isEmptyTileAbove = above.equals(emptyTile);
		boolean isEmptyTileBelow = below.equals(emptyTile);
		boolean isEmptyTileLeft = left.equals(emptyTile);
		boolean isEmptyTileRight = right.equals(emptyTile);
		if(isEmptyTileAbove){
			return ABOVE;
		} else if(isEmptyTileBelow){
			return BELOW;
		} else if(isEmptyTileLeft){
			return LEFT;
		} else if(isEmptyTileRight){
			return RIGHT;
		}
		
		return UNMOVABLE;
	}
	
	private PuzzleTile getPuzzleTile(int x, int y){
		if(x >= size || y>= size || x<0 || y<0 ){
			return null;
		}
		return board[x][y];
	}
	

}
