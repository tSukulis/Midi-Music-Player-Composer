package View;


import FileHandler.*;
import Model.Algorithmic;
import Model.Composition;
import Model.Note;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.*;

import org.jfugue.Player;



public class MusicView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private String sessionStyle = "Free";
	private static String[] sessionStyles = { "Free", "Atonal", "Algorithmic" }; 
	public static Composition underEdit;
	public CompositionHandler J;
	public int transposeVALUE = 0, reflectVALUE = 0;
	
	
	
	
	
	public MusicView(){
		
		JFrame mainFrame = new JFrame("Music Composer");
		underEdit = new Composition();
		mainFrame.setBackground(Color.white);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000,800);
		mainFrame.getContentPane().setLayout(new BorderLayout(3,1));
		
		
		JPanel northSection = new JPanel();
		JPanel centerSection = new JPanel();
		JTextArea southSection = new JTextArea();
		
		centerSection = createCenterSECTION();
		southSection = createSouthSECTION();
		northSection = createNorthSECTION();
		
		
		mainFrame.add(southSection, BorderLayout.SOUTH);
		mainFrame.add(northSection, BorderLayout.NORTH);
		mainFrame.add(centerSection, BorderLayout.CENTER);
		mainFrame.setJMenuBar(createMenuBar());
		
		System.out.println("giouxou " + underEdit.toString());
		
		mainFrame.setVisible(true);
		
	}
	
	
	

	private JPanel createNorthSECTION() {
		ImageIcon playIcon = new ImageIcon("buttons/001.png");
		ImageIcon pauseIcon = new ImageIcon("buttons/pause.png");
		
		
		JPanel res = new JPanel();
		res.setBackground(Color.black);
		res.setLayout(new BorderLayout(10,1));
		RoundButton b = new RoundButton("play", playIcon);
		res.add(b, BorderLayout.EAST);
		
		final JComboBox<Object> box = new JComboBox<Object>(sessionStyles);
		box.setPrototypeDisplayValue("Algorithmic");
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED){
					sessionStyle = sessionStyles [box.getSelectedIndex()];	
				}
			}
		});
		
		res.add(box, BorderLayout.WEST);
		
		return res;
	}




	public JMenuBar createMenuBar(){
		JMenuBar menubar = new JMenuBar();
		
		JMenu composition = new JMenu("Composition");
		
		final JMenuItem open = new JMenuItem("Open");
		open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(open);
				//Handle open button action.
			    if (e.getSource() == open) {
			        //int returnVal = fc.showOpenDialog(FileChooserDemo.this);
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            String absolutePath = file.getAbsolutePath();
			            J = new CompositionHandler();
			            underEdit = J.LoadFromFile(absolutePath);
			            
			            System.out.println("lala" + underEdit.toString());
			        } else {
			        	JOptionPane.showMessageDialog(null, "List contained 0 elements!", "Error",
                                JOptionPane.ERROR_MESSAGE);
			        }
			   }	
			}
		});
		
		
		
		JMenuItem new1 = new JMenuItem("New");
		
		final JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(save);
				//Handle save button action.
			    if (e.getSource() == save) {
			        
			    	 
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            String filename = file.getName();
			            String parentPath = file.getParent();
			            Composition REMOVELater = new Composition();
			            CompositionHandler J = new CompositionHandler(filename, parentPath);
			    		J.SaveToFile(REMOVELater);
			    		
			            //log.append("Opening: " + file.getName() + "." + newline);
			        } else {
			        	JOptionPane.showMessageDialog(null, "Error Occured, please try again", "Error",
                                JOptionPane.ERROR_MESSAGE);
			        }
			   }	
			}
		});
		
		
		
		JMenuItem saveas = new JMenuItem("SaveAs");
		saveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(save);
				//Handle open button action.
			    if (e.getSource() == save) {
			        //int returnVal = fc.showOpenDialog(FileChooserDemo.this);
			    	
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            String filename = file.getName();
			            String parentPath = file.getParent();
			            Composition REMOVELater = new Composition();
			            CompositionHandler J = new CompositionHandler(filename, parentPath);
			    		J.ExportToMidi(REMOVELater, parentPath + "/" + filename);
			    		
			            //log.append("Opening: " + file.getName() + "." + newline);
			        } else {
			        	JOptionPane.showMessageDialog(null, "Error Occured, please try again", "Error",
                                JOptionPane.ERROR_MESSAGE);
			        }
			   }	
			}
		});
		
		
		final JMenuItem export = new JMenuItem("Export");
		export.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(export);
				//Handle open button action.
				if (e.getSource() == export) {
					//int returnVal = fc.showOpenDialog(FileChooserDemo.this);
		    	
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						String filename = file.getName();
						String parentPath = file.getParent();
						Composition REMOVELater = new Composition();
						CompositionHandler J = new CompositionHandler(filename, parentPath);
						J.ExportToMidi(REMOVELater, parentPath + "/" + filename);
		    		
						//log.append("Opening: " + file.getName() + "." + newline);
					} else {
						JOptionPane.showMessageDialog(null, "Error Occured, please try again", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
		
		
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		composition.add(open);
		composition.add(new1);
		composition.add(save);
		composition.add(saveas);
		composition.add(export);
		composition.add(quit);
		

	    JMenu instrument = new JMenu("Instrument");
	    JMenuItem piano = new JMenuItem("Piano");
	    JMenuItem guitar = new JMenuItem("Guitar");
	    JMenuItem flute = new JMenuItem("Flute");
	    instrument.add(piano);
	    instrument.add(guitar);
	    instrument.add(flute);
	    
	    JMenu help = new JMenu("Help");
	    
	    
	    menubar.add(composition);
	    menubar.add(instrument);
	    menubar.add(help);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    return menubar;
	}
	
	public JPanel createCenterSECTION(){
		
		ImageIcon iconC = new ImageIcon("logos/C.jpg");
		ImageIcon iconCsh = new ImageIcon("logos/C#.jpg");
		ImageIcon iconD = new ImageIcon("logos/D.jpg");
		ImageIcon iconDsh = new ImageIcon("logos/D#.jpg");
		ImageIcon iconE = new ImageIcon("logos/E.jpg");
		ImageIcon iconF = new ImageIcon("logos/F.jpg");
		ImageIcon iconFsh = new ImageIcon("logos/F#.jpg");
		ImageIcon iconG = new ImageIcon("logos/G.jpg");
		ImageIcon iconGsh = new ImageIcon("logos/G#.jpg");
		ImageIcon iconA = new ImageIcon("logos/A.jpg");
		ImageIcon iconAsh = new ImageIcon("logos/A#.jpg");
		ImageIcon iconB = new ImageIcon("logos/B.jpg");
		
		
		
		final JButton C_Button = new JButton("C", iconC);
		C_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					C_Button.setEnabled(true);
					Player pl = new Player();
					pl.play("C");
				}
				else {
					C_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton Csh_Button = new JButton("C#", iconCsh);
		Csh_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					Csh_Button.setEnabled(true);
					Note n = new Note("C#");
					n.PlayNote();
				}
				else {
					Csh_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton D_Button = new JButton("D", iconD);
		D_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					D_Button.setEnabled(true);
					Note n = new Note("D");
					n.PlayNote();
				}
				else {
					D_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton Dsh_Button = new JButton("D#", iconDsh);
		Dsh_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					Dsh_Button.setEnabled(true);
					Note n = new Note("D#");
					n.PlayNote();
				}
				else {
					Dsh_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton E_Button = new JButton("E", iconE);
		E_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					E_Button.setEnabled(true);
					Note n = new Note("E");
					n.PlayNote();
				}
				else {
					E_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton F_Button = new JButton("F", iconF);
		F_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					F_Button.setEnabled(true);
					Note n = new Note("F");
					n.PlayNote();
				}
				else {
					F_Button.setEnabled(false);
				}
			}
		});
		
		final JButton Fsh_Button = new JButton("F#", iconFsh);
		Fsh_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					Fsh_Button.setEnabled(true);
					Note n = new Note("F#");
					n.PlayNote();
				}
				else {
					Fsh_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton G_Button = new JButton("G", iconG);
		G_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					G_Button.setEnabled(true);
					Note n = new Note("G");
					n.PlayNote();
				}
				else {
					G_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton Gsh_Button = new JButton("G#", iconGsh);
		Gsh_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					Gsh_Button.setEnabled(true);
					Note n = new Note("G#");
					n.PlayNote();
				}
				else {
					Gsh_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton A_Button = new JButton("A", iconA);
		A_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					A_Button.setEnabled(true);
					Note n = new Note("A");
					n.PlayNote();
				}
				else {
					A_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton Ash_Button = new JButton("A#", iconAsh);
		Ash_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					Ash_Button.setEnabled(true);
					Note n = new Note("A#");
					n.PlayNote();
				}
				else {
					Ash_Button.setEnabled(false);
				}
			}
			
		});
		
		final JButton B_Button = new JButton("B", iconB);
		B_Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Free")){
					//add the note to the free composition
					B_Button.setEnabled(true);
					Note n = new Note("B");
					n.PlayNote();
				}
				else if (sessionStyle.equals("Atonal")){
					B_Button.setEnabled(false);
				}
				else if (sessionStyle.equals("Algorithmic")){
					B_Button.setEnabled(false);
				}
			}
			
		});
		
		
		JPanel mainWindow = new JPanel();

		
		mainWindow.add(C_Button);
		revalidate();
		C_Button.setOpaque(true);
		C_Button.setBorderPainted(false);
		
		mainWindow.add(Csh_Button);
		revalidate();
		Csh_Button.setOpaque(true);
		Csh_Button.setBorderPainted(false);
		
		mainWindow.add(D_Button);
		revalidate();
		D_Button.setOpaque(true);
		D_Button.setBorderPainted(false);
		
		
		mainWindow.add(Dsh_Button);
		revalidate();
		Dsh_Button.setOpaque(true);
		Dsh_Button.setBorderPainted(false);
		
		mainWindow.add(E_Button);
		revalidate();
		E_Button.setOpaque(true);
		E_Button.setBorderPainted(false);
		
		mainWindow.add(F_Button);
		revalidate();
		F_Button.setOpaque(true);
		F_Button.setBorderPainted(false);
		
		mainWindow.add(Fsh_Button);
		revalidate();
		Fsh_Button.setOpaque(true);
		Fsh_Button.setBorderPainted(false);
		
		mainWindow.add(G_Button);
		revalidate();
		G_Button.setOpaque(true);
		G_Button.setBorderPainted(false);
		
		mainWindow.add(Gsh_Button);
		revalidate();
		Gsh_Button.setOpaque(true);
		Gsh_Button.setBorderPainted(false);
		
		
		mainWindow.add(A_Button);
		revalidate();
		A_Button.setOpaque(true);
		A_Button.setBorderPainted(false);
		
		mainWindow.add(Ash_Button);
		revalidate();
		Ash_Button.setOpaque(true);
		Ash_Button.setBorderPainted(false);
		
		mainWindow.add(B_Button);
		revalidate();
		B_Button.setBorderPainted(false);
		
		
		Dimension preferredSize = new Dimension(1000,400);
		mainWindow.setPreferredSize(preferredSize);
		
		
		JPanel extra = new JPanel();
		extra = atonalPanel();
			
		mainWindow.add(extra);
		
		return mainWindow;
	}
	
	
	public JTextArea createSouthSECTION(){
		
		
		
		final JTextArea res = new JTextArea();
		
		res.setFont(new Font("Serif", Font.BOLD, 16));
		res.setLineWrap(true);
		res.setWrapStyleWord(true);
					
		
		//res.setText(this.getComposition().toString());
		
		
		Color col = new Color(153, 153, 255);
		res.setBackground(col);
		res.setEditable(false);
		
		Dimension preferredSize = new Dimension(1000,250);
		res.setPreferredSize(preferredSize);
		
		res.setText(this.getComposition().toString());
		res.update(res.getGraphics());
		
		
		
		//res.setCaretPosition(res.getText().length() - 1);
		return res;
	}
	
	public JPanel atonalPanel(){
		JPanel res = new JPanel();
		
		JButton doNothing = new JButton("doNothing");
		doNothing.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("sfsd");
			}
			
		});
		doNothing.setBackground(new Color(255,204,153));
		doNothing.setOpaque(true);
		doNothing.setBorderPainted(false);
		
		JButton retrograde = new JButton("Retrograde");
		retrograde.setBackground(new Color(153,255,153));
		retrograde.setOpaque(true);
		retrograde.setBorderPainted(false);
		
		
		final JButton transpose = new JButton("transpose");
		
		transpose.setBackground(new Color(153,255,255));
		transpose.setOpaque(true);
		transpose.setBorderPainted(false);
		
		final JTextField transposeTXT = new JTextField();
		transposeTXT.setPreferredSize(new Dimension(50,35));
		
		transpose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Atonal")){
					try{
						transposeVALUE = Integer.parseInt(transposeTXT.getText());
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "transpose value must be integer",
								"InfoBox: " + "Number Format Exception", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					transpose.setEnabled(false);
				}
			}
			
		});
		
		
		JButton reflect = new JButton("reflect");
		reflect.setBackground(new Color(255,153,153));
		reflect.setOpaque(true);
		reflect.setBorderPainted(false);
		
		JTextField reflectTXT = new JTextField();
		reflectTXT.setPreferredSize(new Dimension(50,35));
		
		reflect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sessionStyle.equals("Atonal")){
					try{
						reflectVALUE = Integer.parseInt(transposeTXT.getText());
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "reflect value must be integer",
								"InfoBox: " + "Number Format Exception", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					transpose.setEnabled(false);
				}
			}
			
		});
		
		
		res.add(doNothing);
		res.add(retrograde);
		res.add(transpose);
		res.add(transposeTXT);
		res.add(reflect);
		res.add(reflectTXT);
		
		
		return res;
	}
	
	public Composition getComposition(){
		return MusicView.underEdit;
	}
	
	public void setComposition( Composition a){
		MusicView.underEdit = a;
	}

	
}