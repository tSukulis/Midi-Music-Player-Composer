package Executable;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import FileHandler.CompositionHandler;
import Model.Composition;
import Model.Algorithmic;
import View.MusicPlayer;
import View.MusicView;
import Model.SymmetryActionOnNonValidAtonalRow;


public class Runnable {
	static JFrame mainFrame = new JFrame("Music Composer");

	public static void main(String[] args) throws SymmetryActionOnNonValidAtonalRow{
		// TODO Auto-generated method stub
		
		
		
		//AtonalComposition test1 = new AtonalComposition("MPLA", "Pavlaras", "Soukis", "2014", "Death Metal", "Mpouzouki");
		
		
		
		//Composition test2 = new Composition("rty", "Pavl", "Souk", "2054", "swag Metal", "drumobasso");
		
		
		
		/*Note d = new Note("C");
		Note f = new Note("C#");
		Note h = new Note("D");
		Note p = new Note("D#");
		Note w = new Note("E");
		Note t = new Note("F");
		Note y = new Note("F#");
		Note u = new Note("G");
		Note l = new Note("G#");
		Note k = new Note("A");
		Note r = new Note("A#");
		Note q = new Note("B");
		
		test1.addNote(d);
		test1.addNote(f);
		test1.addNote(h);
		test1.addNote(p);
		test1.addNote(w);
		test1.addNote(t);
		test1.addNote(y);
		test1.addNote(u);
		test1.addNote(l);
		test1.addNote(k);
		test1.addNote(r);
		test1.addNote(q);*/
		
		
		
		
		
		/*test1.retrograde();
		test1.transpose(1);
		test1.doNothing();
		test1.reflect(0);*/
		
	
		//TEST for algorithmic
		/*Composition test = new Composition();
		Algorithmic aa= new Algorithmic("C","I[Violin]");
		test = aa.createAlgorithmic("giwrgos", "takis", "mitsos","1924","pop", "I[Violin]");
		test.PlaySong();*/
		
		
		
		
		
		//printtest
		/*int k1=0;
		for(int i=0;i<test.getSong().size();i++)
		{
			
				System.out.print(test.getSong().get(i).getNoteName()+ " ");
				k1++;
				if(k1==12)
				{
					System.out.println();
					k1=0;
				}
				
			
		}*/
		
		
		
		
		
		
		
		
		
		  //test for compositonHandler
		  /*CompositionHandler ch= new CompositionHandler();
		  ch.SaveToFile(test);
		  ch.ExportToMidi(test, savepath);*/
		
		
		
		//TEST for read a composition from a folder
		/*CompositionHandler ch2= new CompositionHandler();
		Composition cmp = new Composition();
		cmp=ch2.LoadFromFile(path);
		int k1=0;
		for(int i=0;i<test.getSong().size();i++)
		{
			
				System.out.print(test.getSong().get(i).getNoteName()+ " ");
				k1++;
				if(k1==12)
				{
					System.out.println();
					k1=0;
				}
				
			
		}*/
		
		
		
		
		
		/*MusicCollection myMusic = new MusicCollection("myMusic");
		myMusic.AddFoldertoCollection(path);
		
		System.out.println(myMusic.Getplaylist().get(0).getName());
		System.out.println(myMusic.Getplaylist().get(1).getName());
		System.out.println(myMusic.Getplaylist().get(2).getName());
		
		myMusic.AddSongToCollection(test);
		myMusic.AddSongToCollection(test1);
		myMusic.AddSongToCollection(test2);
		System.out.println("Sonds added to collection");
		CollectionHandler newhandler= new CollectionHandler(path);
		System.out.println("newhandler created");
		newhandler.SaveToFolder(myMusic, path);*/
		
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800,400);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(new BorderLayout(3,1));
		
		
		JPanel eastSection = eastPanel();
		JPanel westSection = westPanel();
		
		
		
		
		mainFrame.add(eastSection, BorderLayout.EAST);
		mainFrame.add(westSection, BorderLayout.WEST);
		
		
		
		mainFrame.setVisible(true);
		
	}
	
	
public static JPanel eastPanel(){
		
		JPanel res = new JPanel();
		
		res.setLayout(new BorderLayout());
		
		JButton selEditor = new JButton("editor", new ImageIcon("buttons/editor.png"));
		res.add(selEditor, BorderLayout.CENTER);
		selEditor.setOpaque(true);
		selEditor.setBorderPainted(false);
		
		selEditor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MusicView theView = new MusicView();
				mainFrame.dispose();
			}
			
		});
		
		
		
		return res;
	}
	
	public static JPanel westPanel(){
		JPanel res = new JPanel();
		JButton selPlayer = new JButton("player", new ImageIcon("buttons/player.png"));
		res.add(selPlayer, BorderLayout.CENTER);
		selPlayer.setOpaque(true);
		selPlayer.setBorderPainted(false);
		selPlayer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MusicPlayer thePlayer = new MusicPlayer();
				mainFrame.dispose();
			}
			
		});
		
		return res;
	}

}
