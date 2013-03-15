package nl.gjosse.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.gjosse.game.Game;

public class MasterGUI implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton submit;
	JLabel status;
	
	int guess = 1;
	static Game game;
	
	Map<String, Integer> items = new HashMap<String, Integer>();
	
	public MasterGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5, 10, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		frame.setContentPane(panel);
		
		//buttons 1
		b1 = new JButton(new ImageIcon("1.jpg"));
		b1.setActionCommand("1");
		b1.addActionListener(this);
		items.put("1", 1);
		panel.add(b1);
		
		//buttons 2
		b2 = new JButton(new ImageIcon("1.jpg"));
		b2.setActionCommand("2");
		b2.addActionListener(this);
		items.put("2", 1);
		panel.add(b2);
		
		//buttons 3
		b3 = new JButton(new ImageIcon("1.jpg"));
		b3.setActionCommand("3");
		b3.addActionListener(this);
		items.put("3", 1);
		panel.add(b3);
		
		//buttons 4
		b4 = new JButton(new ImageIcon("1.jpg"));
		b4.setActionCommand("4");
		b4.addActionListener(this);
		items.put("4", 1);
		panel.add(b4);
		
		//buttons 5
		b5 = new JButton(new ImageIcon("1.jpg"));
		b5.setActionCommand("5");
		b5.addActionListener(this);
		items.put("5", 1);
		panel.add(b5);
		
		//status
		
		status = new JLabel("Lets play");
		panel.add(status);
		
		//submit 
		submit = new JButton("Submit");
		submit.setAlignmentX(JFrame.RIGHT_ALIGNMENT);
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		panel.add(submit);
		
		//pack and go
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(false);
				MasterGUI gui = new MasterGUI();
			}
		});
		game = new Game(5, 5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		//Button1 action
		if(action.equals("1")) {
			String b = "1";
			int i = items.get(b);
			String loc;
				if(i<5) {
					loc = (i+1) + ".jpg";
					items.remove(b);
					items.put(b, i+1);
				} else {
					loc = "1.jpg";
					items.remove(b);
					items.put(b, 1);
				}
			b1.setIcon(new ImageIcon(loc));
			
		}
		
		//button2 action
		if(action.equals("2")) {
			String b = "2";
			int i = items.get(b);
			String loc;
				if(i<5) {
					loc = (i+1) + ".jpg";
					items.remove(b);
					items.put(b, i+1);
				} else {
					loc = "1.jpg";
					items.remove(b);
					items.put(b, 1);
				}
			b2.setIcon(new ImageIcon(loc));

		}
		
		//button3 action
		if(action.equals("3")) {
			String b = "3";
			int i = items.get(b);
			String loc;
				if(i<5) {
					loc = (i+1) + ".jpg";
					items.remove(b);
					items.put(b, i+1);
				} else {
					loc = "1.jpg";
					items.remove(b);
					items.put(b, 1);
				}
			b3.setIcon(new ImageIcon(loc));
		}
		
		//button4 action
		if(action.equals("4")) {
			String b = "4";
			int i = items.get(b);
			String loc;
				if(i<5) {
					loc = (i+1) + ".jpg";
					items.remove(b);
					items.put(b, i+1);
				} else {
					loc = "1.jpg";
					items.remove(b);
					items.put(b, 1);
				}
			b4.setIcon(new ImageIcon(loc));
		}
		
		//button5 action
		if(action.equals("5")) {
			String b = "5";
			int i = items.get(b);
			String loc;
				if(i<5) {
					loc = (i+1) + ".jpg";
					items.remove(b);
					items.put(b, i+1);
				} else {
					loc = "1.jpg";
					items.remove(b);
					items.put(b, 1);
				}
			b5.setIcon(new ImageIcon(loc));
		}	
		
		//Submit button
		if(action.equals("submit")) {
			if(guess<=20) {
			int loc1 = items.get("1");
			int loc2 = items.get("2");
			int loc3 = items.get("3");
			int loc4 = items.get("4");
			int loc5 = items.get("5");
			
			game.addToPegs(loc1);
			game.addToPegs(loc2);
			game.addToPegs(loc3);
			game.addToPegs(loc4);
			game.addToPegs(loc5);
			
				if(game.checkAnswer()) {
					frame.setTitle("You did it! You guess the code in "+guess+" guess");
					game.clear();
				} else {
					frame.setTitle(game.getAnswerString()); 
					guess++;
					game.clear();
				}
			
			} else {
				frame.setTitle("You failed to guess the code!");
			}
		}
		
	}

}
