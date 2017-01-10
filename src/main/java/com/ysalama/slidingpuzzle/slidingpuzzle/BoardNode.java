package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.util.ArrayList;

public class BoardNode implements Comparable<BoardNode>{
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
		
	private int getHeuristic(){
		int costFromStartToNode = numberOfMoves;
		//int costFromNodeToGoal = state.numberOfMisplacedTiles();
		int costFromNodeToGoal = state.getManhattenDistance();
		int totalCost = costFromStartToNode + costFromNodeToGoal;
		return totalCost;
	}
	
	/*The lower the heuristic value the higher the priority.
	 * And in a priority queue (which will be used to solve the puzzle)
	 * the elements are ordered according to their natural ordering from least
	 * to greatest.*/
	public int compareTo(BoardNode that) {
		return this.getHeuristic() - that.getHeuristic();
	}
	
	public ArrayList<BoardNode> getNextPossibleNodes(){
		ArrayList<PuzzleBoard> nextPossibleStates = state.getNextPossibleBoards();
		ArrayList<BoardNode> nextPossibleNodes = new ArrayList<BoardNode>();
		
		for(PuzzleBoard x: nextPossibleStates){
			nextPossibleNodes.add(new BoardNode(x,this));
		}
		return nextPossibleNodes;
	}
	
	public PuzzleBoard getState(){
		return this.state;
	}
	
	public boolean equals(BoardNode that){
		return this.state.equals(that.state);
	}
	
	public String toString(){
		String result;
		result = state + "\n" + "Number of Moves: " + numberOfMoves+"\n\n";
		return result;
	}
	
	
}
