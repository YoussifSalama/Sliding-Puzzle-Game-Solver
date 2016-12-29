package com.ysalama.slidingpuzzle.slidingpuzzle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PuzzleBoardGame extends JFrame {
	int boardSize;
	//JFrame gameFrame;
	
	public PuzzleBoardGame(int boardSize){
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		//titleGUI();
		buttonsGUI();
		
		this.add(new PuzzleBoard(boardSize));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,450);
		this.setVisible(true);
	}
	
	private void titleGUI(){
		JLabel title = new JLabel("Sliding Puzzle Game");
		//title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);
	}
	
	private void buttonsGUI(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//buttonPanel.setSize(5, 5);
		JButton button1 = new JButton("Button 1");
		button1.setSize(20, 5);
		JButton button2 = new JButton("Button 2");
		button2.setSize(20, 5);
		JButton button3 = new JButton("Button 3");
		button3.setSize(20, 5);
		
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		
		this.add(buttonPanel);
		//buttonPanel.add(title);
	}
}
