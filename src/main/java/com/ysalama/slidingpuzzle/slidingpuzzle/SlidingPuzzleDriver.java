package com.ysalama.slidingpuzzle.slidingpuzzle;


public class SlidingPuzzleDriver {
	
	public static void main(String[] args) {
		PuzzleBoard a = new PuzzleBoard(3,true);
		
		System.out.println(a.toString());
		
		a.move(0, 1);
		System.out.println(a.toString());
		
		PuzzleBoard b = new PuzzleBoard(3);
		
	}
	
}