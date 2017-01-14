package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BoardNode implements Comparable<BoardNode>{
	long state;
	BoardNode previousNode;
	private int numberOfMoves;
	
	public BoardNode(PuzzleBoard state){
		this.state = state.puzzleBoardToLong();
		previousNode = null;
		
		numberOfMoves = 0;
	}
	
	public BoardNode(PuzzleBoard state, BoardNode previousNode){
		this.state = state.puzzleBoardToLong();
		this.previousNode = previousNode;
		
		numberOfMoves = previousNode.numberOfMoves + 1;
	}
	
	public BoardNode(long state, BoardNode previousNode){
		this.state = state;
		this.previousNode = previousNode;
		
		numberOfMoves = previousNode.numberOfMoves + 1;
	}
		
	public int getHeuristic(){
		int costFromStartToNode = numberOfMoves;
		//int costFromNodeToGoal = state.numberOfMisplacedTiles();
		int costFromNodeToGoal = getState().getManhattenDistance();
		int totalCost = costFromStartToNode + costFromNodeToGoal;
		return totalCost;
	}
	
	/**
	 * The lower the heuristic value the higher the priority.
	 * And in a priority queue (which will be used to solve the puzzle)
	 * the elements are ordered according to their natural ordering from least
	 * to greatest.
	 * 
	 * */
	public int compareTo(BoardNode that) {
		return this.getHeuristic() - that.getHeuristic();
	}
	
	/**
	 * Returns an arrayList of board nodes with all the possible next board
	 * states.
	 * 
	 * */
	
	public ArrayList<BoardNode> getNextPossibleNodes(){
		ArrayList<PuzzleBoard> nextPossibleStates = getState().getNextPossibleBoards();
		ArrayList<BoardNode> nextPossibleNodes = new ArrayList<BoardNode>();
		
		for(PuzzleBoard x: nextPossibleStates){
			nextPossibleNodes.add(new BoardNode(x,this));
		}
		return nextPossibleNodes;
	}
	
	/**
	 * Returns a PuzzleBoard.
	 * It converts the BoardNode state which is a long to a PuzzleBoard.
	 * 
	 * */
	
	public PuzzleBoard getState(){
		return new PuzzleBoard(Long.toString(state));
	}
	
	/**
	 * If two boards have equal states. Then they are equal.
	 * 
	 * */
	public boolean equals(BoardNode that){
		return this.state == that.state;
	}
	
	public String toString(){
		String result;
		PuzzleBoard puzzleState = new PuzzleBoard(Long.toString(this.state));
		result = puzzleState + "\n" + "Number of Moves: " + numberOfMoves+"\n\n";
		return result;
	}
	
	/**
	 * Returns a stack of BoardNodes that when printed would print the path 
	 * leading up to this BoardNode.
	 * 
	 * */
	public ArrayDeque<BoardNode> getPath(){
		ArrayDeque<BoardNode> path  = new ArrayDeque<BoardNode>();
		BoardNode current = this;
		//path.add(current);
		while(current != null){
			path.push(current);
			current = current.previousNode;
		}
		
		return path;
	}
	
}
