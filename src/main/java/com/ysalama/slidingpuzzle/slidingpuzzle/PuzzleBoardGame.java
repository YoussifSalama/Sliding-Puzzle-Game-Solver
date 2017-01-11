package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzleBoardGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 461470536640690001L;
	
	int boardSize;
	PuzzleBoard board;
	//JFrame gameFrame;
	
	public PuzzleBoardGame(int boardSize){
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		board = new PuzzleBoard(boardSize);

		buttonsGUI();
		
		this.add(board);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,450);
		this.setVisible(true);
	}
	
	public PuzzleBoardGame(PuzzleBoard board){
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.board = board;

		buttonsGUI();
		
		this.add(this.board);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,450);
		this.setVisible(true);
	}
	
	public void solve(){
		board.solve();
	}
	
	
	private void buttonsGUI(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		

		JButton button1 = new JButton("Solve!");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		button1.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				solve();
				
			}

			public void mousePressed(MouseEvent e) {return;}
			public void mouseReleased(MouseEvent e) {return;}
			public void mouseEntered(MouseEvent e) {return;}
			public void mouseExited(MouseEvent e) {return;}
		});
		
		buttonPanel.add(button1);
		//buttonPanel.add(button2);
		//buttonPanel.add(button3);
		
		this.add(buttonPanel);
	}
}
