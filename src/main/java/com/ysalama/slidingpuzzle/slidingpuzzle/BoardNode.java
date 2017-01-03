package com.ysalama.slidingpuzzle.slidingpuzzle;

public class BoardNode{
	PuzzleBoard state;
	PuzzleBoard previousState;
	private int numberOfMoves;
	
	public BoardNode(PuzzleBoard state){
		this.state = state;
		previousState = null;
		
		numberOfMoves = 0;
	}
	
	public BoardNode(PuzzleBoard state, BoardNode previousNode){
		this.state = state;
		this.previousState = previousNode.state;
		
		numberOfMoves = previousNode.numberOfMoves + 1;
	}
		
	public int getHeuristic(){
		int costFromStartToNode = numberOfMoves;
		int costFromNodeToGoal = state.numberOfMisplacedTiles();
		
		int totalCost = costFromStartToNode + costFromNodeToGoal;
		return totalCost;
	}
	
}
