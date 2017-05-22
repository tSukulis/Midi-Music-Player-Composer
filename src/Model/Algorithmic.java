package Model;


import Model.Note;

public class Algorithmic {
	
	
	
	
	static String myNotes [] = new String []{
		"C", 
		"C#",
		"D",
		"D#",
		"E",
		"F",
		"F#",
		"G",
		"G#",
		"A",
		"A#",
		"B"
	};
	
	
	String finalsong = "";
	
	public Algorithmic (String note, String instrument){
		this.finalsong = instrument + note; 
		
	}
	
	
	
	
	
	public static Composition createAlgorithmic (String name, String artist, String composer, String year, String genre, String instrument) {
		Composition finalComp = new Composition(name, artist, composer, year, genre, instrument);
		finalComp.setCompositionStyle("Algorithmic");
		Note n1 = new Note(instrument);
		finalComp.addNote(n1);
		for (int numberofNotes = 0; numberofNotes < 11; numberofNotes++){
			int myRand = 0 + (int)(Math.random() * ((11 - 0) + 1));
			Note n = new Note(myNotes[myRand]);
			finalComp.addNote(n);
		}
		return finalComp;
	}
	
	
	
	

	

	
}
