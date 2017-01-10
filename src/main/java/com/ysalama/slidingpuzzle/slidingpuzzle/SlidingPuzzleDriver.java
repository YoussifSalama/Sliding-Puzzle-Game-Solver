package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingPuzzleDriver {
	
	public static void main(String[] args) {
		/*PuzzleBoard b = new PuzzleBoard(2);
		ArrayList<PuzzleBoard> next = b.getNextPossibleBoards();
		for(PuzzleBoard x:next){
			System.out.println(x);
		}*/
		//b.isCorrectSolution();
		
		//PuzzleBoardGame b = new PuzzleBoardGame(2);
		//System.out.println("solving...");
		//b.solve();
		
		Integer[] array = {1,8,2,0,4,3,7,6,5};
		//Integer[] array = {7,8,5,1,4,6,2,3,0};
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.addAll(Arrays.asList(array));
		
		PuzzleBoard a = new PuzzleBoard(3,ints);
		System.out.println("solving...");
		PuzzleBoardGame x = new PuzzleBoardGame(a);
		//a.solve();
		
		/*PuzzleBoard a = new PuzzleBoard(3);
		System.out.println("solving...");
		a.solve();*/
	}
	
}