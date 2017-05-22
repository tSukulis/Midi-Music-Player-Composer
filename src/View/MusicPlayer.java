package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MusicPlayer extends JFrame {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MusicPlayer(){
		JFrame mainFrame = new JFrame("Music Player");
		mainFrame.setBackground(Color.white);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(700,400);
		mainFrame.getContentPane().setLayout(new BorderLayout(3,1));
		
		
		
		JPanel north = createNORTH();
		
		JScrollPane south = createSOUTH();
		
		JPanel dummy = new JPanel();
		dummy.setBackground(Color.black);
		
		
		mainFrame.add(north, BorderLayout.NORTH);
		mainFrame.add(south, BorderLayout.SOUTH);
		mainFrame.add(dummy, BorderLayout.CENTER);
		mainFrame.setJMenuBar(createJMenuBar());
		mainFrame.setVisible(true);
	}
	
	public JPanel createNE() {  //NE = NorthEast
		JPanel res = new JPanel();
		res.setLayout(new BorderLayout(2,1));
		res.setBackground(Color.black);
		
		final JButton play = new JButton(new ImageIcon("buttons/Play-Hot-icon.png"));
		play.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Player temp = new Player("mitsos.txt", "/ProjectMusic/myMusic.mid");
				temp.run();
				play.setIcon(new ImageIcon("buttons/pause-hot-icon.png"));
			}
			
		});
		JButton forward = new JButton(new ImageIcon("buttons/HOT-Forward-icon.png"));
		JButton back = new JButton(new ImageIcon("buttons/HOT-Back-icon.png"));
		
		res.add(back, BorderLayout.WEST);
		res.add(play, BorderLayout.CENTER);
		res.add(forward, BorderLayout.EAST);
		
		
		return res;
		
	}
	
	public JPanel createNORTH(){
		JPanel res = new JPanel();
		res.setLayout(new BorderLayout(2,1));
		res.setBackground(Color.black);
		res.add(createNE(),BorderLayout.EAST);
		
		
		return res;
	}
	
	
	public JScrollPane createSOUTH(){
		
		JTextArea tmp = new JTextArea();
		tmp.setPreferredSize(new Dimension(700,200));
		tmp.setEditable(false);
		tmp.setFont(new Font("Serif", Font.BOLD, 16));
		tmp.setLineWrap(true);
		tmp.setWrapStyleWord(true);
		tmp.setBackground(Color.WHITE);
		JScrollPane res = new JScrollPane(tmp);
		
		
		
		
		return res;
	}
	
	public JMenuBar createJMenuBar(){
		JMenuBar res = new JMenuBar();
		
		JMenu collection = new JMenu("Collection");
		final JMenuItem open = new JMenuItem("Open");
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(open);
				//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//Handle open button action.
			    if (e.getSource() == open) {
			        //int returnVal = fc.showOpenDialog(FileChooserDemo.this);
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            String absolutePath = file.getAbsolutePath();
			            
			        } else {
			        	JOptionPane.showMessageDialog(null, "List contained 0 elements!", "Error",
                                JOptionPane.ERROR_MESSAGE);
			        }
			   }
			}
		});
		
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		
		collection.add(open);
		collection.add(exit);
		
		
		JMenu help = new JMenu("Help");
		
		
		res.add(collection);
		res.add(help);
		return res;
	}
	
}
