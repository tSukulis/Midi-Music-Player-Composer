package Collection;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import FileHandler.CompositionHandler;
import Model.Composition;


public class MusicCollection {
	private String name;
	private ArrayList<Composition> playlist;
	private ArrayList<Composition> temp;
	
	
	
	
	/**
	 * constructor
	 * @param name
	 */
	public MusicCollection(String name)
	{
		this.name = name;
		this.playlist = new ArrayList<Composition>();
	}
	
	/**
	 * modifier
	 * @param name
	 * sets a new name to a Collection
	 */
	public void SetName(String name)
	{
		this.name = name;
	}
	
	/**
	 * accessor
	 * @return the name of a Collection
	 */
	public String GetName()
	{
		return this.name;
	}
	
	/**
	 * accessor
	 * @return a playlist
	 */
	public ArrayList<Composition> Getplaylist()
	{
		return this.playlist;
	}
	
	/**
	 * accessor
	 * @return a temp playlist
	 */
	public ArrayList<Composition> GetTempPlaylist()
	{
		return this.temp;
	}
	
	/**
	 * adds a song to playlist
	 * @param Song
	 */
	public void AddSongToCollection(Composition Song)
	{
		this.playlist.add(Song);
	}
	
	/**
	 * removes a song from playlist
	 * @param Song
	 */
	public void RemoveSongFromCollection(Composition Song)
	{
		this.playlist.remove(Song);
	}
	
	/**
	 * adds a folder to collection
	 */
	public void AddFoldertoCollection(String Folderpath )
	{
		File folder = new File(Folderpath);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i< listOfFiles.length; i++){
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".txt")){
				Composition newComp = new Composition();
				CompositionHandler handle = new CompositionHandler();
				newComp = handle.LoadFromFile(Folderpath + "/" + listOfFiles[i].getName());
				this.Getplaylist().add(newComp);
			}
		}
	}
	
	/**
	 * moves a song inside list
	 * @param song
	 */
	public void MoveComposition(ArrayList<Composition> compList, int i , int j)
	{
		Collections.swap(compList, i, j);
	}
	
	
	
	

}
