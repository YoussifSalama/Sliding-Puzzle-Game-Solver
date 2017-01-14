package com.ysalama.slidingpuzzle.slidingpuzzle;

public class SlidingPuzzleDriver {
	
	public static void main(String[] args) {
	
		
		PuzzleBoard a = new PuzzleBoard("182043765"); //Easy Board.
		//PuzzleBoard a = new PuzzleBoard(3); //Create Board of Size 3.
		//PuzzleBoard a = new PuzzleBoard("785146230"); //Hard Board
		System.out.println("solving...");
		a.solve();
		
	}
	
}