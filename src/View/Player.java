package View;

import FileHandler.CompositionHandler;
import Model.Composition;

public class Player implements Runnable {
	
	Composition tobePlayed;
	
	Player(String filename,String path){
		CompositionHandler J = new CompositionHandler(filename, path);
		tobePlayed = J.LoadFromFile(path);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		tobePlayed.PlaySong();
	}
	
	public void pause() {
		
	}
	
}
