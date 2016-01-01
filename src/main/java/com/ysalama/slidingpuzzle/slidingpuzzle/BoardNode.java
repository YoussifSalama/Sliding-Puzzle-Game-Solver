package com.ysalama.slidingpuzzle.slidingpuzzle;

public class BoardNode{
	PuzzleBoard state;
	PuzzleBoard nextStates;
	int costFromStart;
	int costToGoal;	//The heuristic
	int totalCost;
	
}
