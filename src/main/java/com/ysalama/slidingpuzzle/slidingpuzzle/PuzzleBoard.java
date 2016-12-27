package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBoard {
	private PuzzleTile [][] board;
	
	public PuzzleBoard(int size){
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
	
	public boolean canTileMove(PuzzleTile tile){
		return false;
	}
	

}
