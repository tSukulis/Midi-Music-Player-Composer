package FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

import org.jfugue.Pattern;
import org.jfugue.Player;

import Model.Composition;
import Model.Note;

public class CompositionHandler {
	private String Filename;
	private String Path;
	
	
	public CompositionHandler(){
		this.Filename = "";
		this.Path = "";
	}
	
	/**
	 * constructor
	 * @param filename
	 * @param path
	 */
	public CompositionHandler(String filename,String path)
	{
		this.Filename = filename;
		this.Path = path;
		
		
	}
	
	/**
	 * saves a composition
	 * @param composotion
	 * @return path of composition
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void SaveToFile(Composition composition){
		String oName = "Name: " + composition.getName();
		String oArtist = "Artist: " + composition.getArtist();
		String oYear = "Year: " + composition.getYear();
		String oComposer = "Composer: " + composition.getComposer();
		String oGenre = "Genre: " + composition.getGenre();
		String oCompStyle = "Composition_Style: " + composition.getCompositionStyle();
		
		
		String output = "";
		for (int i = 0; i < composition.getSong().size(); i++){
			output = output + composition.getSong().get(i).getNoteName() + " ";
		}
		
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.getPath() + "/" + this.getFilename() + ".txt"), true));
            bw.write(": " + oName);
            bw.newLine();
            bw.write(": " + oArtist);
            bw.newLine();
            bw.write(": " + oYear);
            bw.newLine();
            bw.write(": " + oComposer);
            bw.newLine();
            bw.write(": " + oGenre);
            bw.newLine();
            bw.write(": " + oCompStyle);
            bw.newLine();
            bw.write("--------------------------------------------------------------");
            bw.newLine();
            bw.write(output);
            bw.close();
		} 
		catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}
	
	
	/**
	 * reads a composition from a file
	 */
	public Composition LoadFromFile (String path){
		this.setPath(path);
		try{
			FileInputStream fstream = new FileInputStream(path);
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			Composition newComp = new Composition();
			int i = 0;
			while ((strLine = br.readLine()) != null && i < 8) {
				
				String [] parts = strLine.split(" ");
				if (i == 0){
					newComp.setName(parts[1]);
				}
				else if (i == 1){
					newComp.setArtist(parts[1]);
				}
				else if (i == 2){
					newComp.setYear(parts[1]);
				}
				else if (i == 3){
					newComp.setComposer(parts[1]);
				}
				else if (i == 4){
					newComp.setGenre(parts[1]);
				}
				else if (i == 5){
					newComp.setCompositionStyle(parts[1]);
				}
				else if (i == 7){
					ArrayList<Note> newSong = new ArrayList<Note>();
					for (int j = 0; j < parts.length;j++){
						Note newNote = new Note(parts[j]);
						newSong.add(newNote);
					}
					newComp.setSong(newSong);
				}
				i++;
			}
			in.close();
			return newComp;
		}
		catch (Exception e){
			System.err.println("Exception: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * saves a composition to midi format
	 */
	public void ExportToMidi(Composition composition,String savepath){
		try{
			Player player = new Player();
			String pat = "";
			for (int i = 0; i < composition.getSong().size(); i++){
				pat = pat + composition.getSong().get(i).getNoteName() + " ";
			}
			Pattern pattern = new Pattern(pat);
			player.saveMidi(pattern, new File(savepath));
		}
		catch (IOException e) {
			System.err.println("IOException : " + e.getMessage());
			
		}
		
	}
	
	/**
	 * accessor
	 * @return name of file
	 */
	public String getFilename() {
		return this.Filename;
	}
	
	/**
	 * mutative
	 * @param filename
	 * sets a new name to file
	 */
	public void setFilename(String filename) 
	{
		this.Filename=filename;
	}
	
	/**
	 * accessor
	 * @return the path
	 */
	public String getPath(){
		return this.Path;
	}
	
	/**
	 * mutative sets a new path
	 * @param path
	 */
	public void setPath(String path) 
	{
		this.Path=path;
	}

}
