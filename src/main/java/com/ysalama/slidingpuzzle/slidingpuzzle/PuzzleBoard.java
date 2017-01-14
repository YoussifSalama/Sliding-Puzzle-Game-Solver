package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.swing.JPanel;

public class PuzzleBoard extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1680191577932990786L;
	
	final static int ABOVE = 1;
	final static int BELOW = 2;
	final static int LEFT = 3;
	final static int RIGHT = 4;
	final static int UNMOVABLE = -1;
	
	
	private PuzzleTile [][] board;
	private int size;
	
	public PuzzleBoard(int size){
		
		
		this.size = size;
		this.board = new PuzzleTile[size][size];
		
		ArrayList<Integer> tileNumbersList = new ArrayList<Integer>();
		//Add numbers from 0 to size*size - 1.
		for(int i = 0; i< size*size; i++){
			tileNumbersList.add(i);
		}
		
		//Shuffle the list.
		Collections.shuffle(tileNumbersList);
		System.out.println(tileNumbersList);
		
		//If puzzle is not solvable, shuffle list until it is.
		while(isSolvablePuzzle(tileNumbersList) == false){
			Collections.shuffle(tileNumbersList);
			System.out.println(tileNumbersList);
		}
		
		//Creates new tiles with the shuffled tileNumbers list.
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				board[x][y] = new PuzzleTile(tileNumbersList.remove(0),x,y);
			}
		}
		System.out.println(this.toString());
		PuzzleBoardGUI();
		
		
	}
	
	public PuzzleBoard(String tileNumbers){
		this.size = (int) Math.sqrt(tileNumbers.length());
		this.board = new PuzzleTile[size][size];
		
		
		
		ArrayList<Integer> tileNumbersList = new ArrayList<Integer>();
		//int index = 0;
		for(int i = 0; i<tileNumbers.length(); i++){
			
			tileNumbersList.add((int) tileNumbers.charAt(i) - '0');
			
		}
		
		//System.out.println(tileNumbersList);
		
		//If puzzle is not solvable, shuffle list until it is.
		while(isSolvablePuzzle(tileNumbersList) == false){
			Collections.shuffle(tileNumbersList);
			System.out.println(tileNumbersList);
		}
		
		//Creates new tiles with the shuffled tileNumbers list.
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				board[x][y] = new PuzzleTile(tileNumbersList.remove(0),x,y);
			}
		}
		//System.out.println(this.toString());
		PuzzleBoardGUI();
	}
	
	public PuzzleBoard(PuzzleBoard that){
		this.size = that.size;
		this.board = new PuzzleTile[size][size];
		
		//Copy each puzzleTile from that to this.
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				this.board[x][y] = new PuzzleTile(that.board[x][y]);
			}
		}
	}
	
	
	public String toString(){
		
		String result = "";
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				result = result + getPuzzleTile(x,y).toString() + "\t";
			}
			result = result + "\n";
		}
		return result;
	}
	
	
	
	/*public boolean equals(PuzzleBoard that){
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				if(this.board[x][y].equals(that.board[x][y]) == false){
					return false;
				}
			}
		}
		return true;
		
	}*/
	
	/**
	 * Returns the tiles on the board in the form of an array list.
	 * 
	 * */
	
	private ArrayList<Integer> toArrayList(){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				result.add(board[x][y].getTileNumber());
			}
		}
		return result;
	}
	
	/**
	 * Returns the number of tiles in the board that are out of place.
	 * 
	 * */
	
	public int numberOfMisplacedTiles(){
		int numberOfMisplacedTiles = 0;
		ArrayList<Integer> tileNumbersList = this.toArrayList();
		for(int i = 0; i< tileNumbersList.size(); i++){
			if(tileNumbersList.get(i) != i+1){
				numberOfMisplacedTiles++;
			} else if(tileNumbersList.get(i) == 0 && i != size-1 ){
				numberOfMisplacedTiles++;
			}
		}
		//System.out.println(numberOfMisplacedTiles);

		return numberOfMisplacedTiles;
	}
	
	/**
	 * Returns the sum of the Manhattan distances in the board.
	 * 
	 * */
	
	public int getManhattenDistance(){
		int manhattenDistance = 0;
		int index = 0;
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				manhattenDistance += board[x][y].getManhattanDistance(index++);
			}
		}
		return manhattenDistance;
	}
	
	/**
	 * Checks if this board is solvable or not.
	 * 
	 * */
	
	private boolean isSolvablePuzzle(ArrayList<Integer> tileNumbers){
		
		/*If this copy is not done we will be removing from 
		 * the actual ArrayList that is passed.*/
		
		ArrayList<Integer> tileNumbersCopy = new ArrayList<Integer>(tileNumbers);
		tileNumbersCopy.remove(new Integer(0));
		int numberOfInversions = 0;
		
		for(int i = 0; i<tileNumbersCopy.size(); i++){
			for(int j = i+1; j<tileNumbersCopy.size(); j++){
				if(tileNumbersCopy.get(i) > tileNumbersCopy.get(j)){
					numberOfInversions++;
				}
			}
		}
		
		//If the number of inversions is even then it is solvable.
		return numberOfInversions % 2 == 0;
	}
	/**
	 * Returns PuzzleTile in specified location, if location is 
	 * out of bounds it returns null.*/
	private PuzzleTile getPuzzleTile(int x, int y){
		if(x >= size || y>= size || x<0 || y<0 ){
			return null;
		}
		return board[x][y];
	}
	
	/**
	 * A tile can move if one of the tiles around it is the 0 tile.
	 * */
	private int canTileMove(int x, int y){
		PuzzleTile emptyTile = new PuzzleTile(0,0,0);
		
		PuzzleTile above = getPuzzleTile(x,y+1);
		PuzzleTile below = getPuzzleTile(x,y-1);
		PuzzleTile left = getPuzzleTile(x-1,y);
		PuzzleTile right = getPuzzleTile(x+1,y);
		
		boolean isEmptyTileAbove = emptyTile.equals(above);
		boolean isEmptyTileBelow = emptyTile.equals(below);
		boolean isEmptyTileLeft = emptyTile.equals(left);
		boolean isEmptyTileRight = emptyTile.equals(right);
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
	
	/**
	 * If possible switches specified tile with the empty tile.
	 * */
	public void move(int x, int y){

		int movement = canTileMove(x, y);
		if(movement == UNMOVABLE){
			return;
		} 
		
		if(movement == ABOVE){
			board[x][y].switchNumber(board[x][y+1]);

		} else if(movement == BELOW){
			board[x][y].switchNumber(board[x][y-1]);

		} else if(movement == LEFT){
			board[x][y].switchNumber(board[x-1][y]);
	
		} else if(movement == RIGHT){
			board[x][y].switchNumber(board[x+1][y]);

		}
		
	}
	
	/**
	 * 
	 * This method checks if a correct solution has been reached.
	 * i.e.
	 *  If the empty tile is in the bottom right corner, and all the
	 *  tiles are in proper order.
	 * 
	 * */
	
	public boolean isCorrectSolution(){

		
		
		String solution = ""; // Empty tile in bottom right corner.
		
		int tileNumber = 1;
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				
				if(x == size-1 && y == size-1){
					tileNumber = 0;
				}
				solution = solution + tileNumber++ + "\t";
			}
			solution = solution + "\n";
		}
		
		boolean isSolution = this.toString().equals(solution);
		return isSolution;
	}
	
	/**
	 * Returns an ArrayList with all the possible board states
	 *  that can occur after moving a tile on this board.
	 *  
	 * */
	
	public ArrayList<PuzzleBoard> getNextPossibleBoards(){
		ArrayList<PuzzleBoard> possibleBoards = new ArrayList<PuzzleBoard>();
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				if(this.canTileMove(x, y) != UNMOVABLE){
					PuzzleBoard aPossibleBoard = new PuzzleBoard(this);
					aPossibleBoard.move(x, y);
					possibleBoards.add(aPossibleBoard);
				}
			}
		}
		return possibleBoards;
	}
	
	/**
	 * Solves the puzzle using the A* algorithm
	 * 
	 * */
	
	public void solve(){
		PriorityQueue <BoardNode> queue = new PriorityQueue<BoardNode>();
		HashMap <BoardNode,Integer> visitedSet = new HashMap<BoardNode,Integer>();
		BoardNode startNode = new BoardNode(this);
		queue.add(startNode);
		
		while(queue.isEmpty() == false){
			BoardNode current = queue.poll();
			visitedSet.put(current,current.getHeuristic());
			
			if(current.getState().isCorrectSolution()){

				System.out.println("DONE \n");
				
				for(BoardNode x: current.getPath()){
					System.out.println(x);
				}
				
				return;
			}
			
			ArrayList<BoardNode> nextPossibleNodes = current.getNextPossibleNodes();
			for(BoardNode x: nextPossibleNodes){
				if(!visitedSet.containsKey(x)){
					queue.add(x);
				} else if( x.getHeuristic() < visitedSet.get(x)){ 
					/*If new heuristic is less than that in visitedSet, 
					 * add this node to queue.*/
					queue.add(x);
				}
			}
			
		}
		
	}
	
	/**
	 * Returns this puzzleBoard represented as a Long. This is used by the
	 * BoardNode class to save memory.
	 * For Example, 
	 * 	
	 * 	1	2	3
	 * 	4	5	6
	 * 	7	8	0
	 * 
	 *  is represented as: 123456780.
	 * */
	public long puzzleBoardToLong(){
		
		String result = "";
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				result = result + board[x][y].getTileNumber();
			}
		}
		return new Long(result);
	}
	
	
	
	
	private void PuzzleBoardGUI(){
		
		this.setLayout(new GridLayout(size,size));
		
		MouseListener mouseListener = new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				PuzzleTile clickedTile = (PuzzleTile) e.getComponent();
				
				int xPositionOfClickedTile = clickedTile.getTilePosition().x;
				int yPositionOfClickedTile = clickedTile.getTilePosition().y;
				
				move(xPositionOfClickedTile, yPositionOfClickedTile);
				

				/*//Repaints the whole board, to display all changes.
				for( y = 0; y<size; y++){
					for( x = 0; x<size; x++){
						board[x][y].repaint();
					}
				}*/
				
			}

			public void mousePressed(MouseEvent e) {return;}
			public void mouseReleased(MouseEvent e) {return;}
			public void mouseEntered(MouseEvent e) {return;}
			public void mouseExited(MouseEvent e) {return;}
			
		};
		
		for(int y = 0; y<size; y++){
			for(int x = 0; x<size; x++){
				board[x][y].addMouseListener(mouseListener);

				this.add(board[x][y]);

			}
		}
		
	}

	
}
