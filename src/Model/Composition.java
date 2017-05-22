package Model;

import java.util.ArrayList;

import org.jfugue.Player;

public class Composition {
	private ArrayList<Note> Song;
	private String name;
	private String Artist;
	private String Composer;
	private String Year;
	private String Genre;
	private String instrument;
	private String CompositionStyle;
	
	/**
	 * Default Constructor
	 */
	public Composition(){
		this.name = "";
		this.Artist = "";
		this.Composer = "";
		this.Year = "";
		this.Genre = "";
		this.instrument = "";
		this.Song = null;
	}
	
	/**
	 * constructor
	 * @param song
	 * @param name
	 * @param artist
	 * @param composer
	 * @param year
	 * @param genre
	 * @param instrument
	 */
	public Composition(String name,String artist,String composer,String year,String genre,String instrument){
		this.name = name;
		this.Artist = artist;
		this.Composer = composer;
		this.Year = year;
		this.Genre = genre;
		this.instrument = instrument;
		this.Song = new ArrayList<Note>();
		
	}
	
	/**
	 * modifier
	 * @param Song
	 * sets a new list of object notes to song
	 */
	public void setSong(ArrayList<Note> Song){
		this.Song = Song;
	}
	
	/**
	 * accessor
	 * @return a song
	 */
	public ArrayList<Note> getSong()
	{
		return this.Song;
		
	}
	
	/**
	 * modifier
	 * @param name
	 * sets a new name
	 */
	public void setName(String name)
	{
		this.name = name;
		
	}
	
	/**
	 * modifier
	 * @param Artist
	 * sets a new artist
	 */
	public void setArtist(String artist)
	{
		this.Artist = artist;
		
	}
	
	
	/**
	 * modifier	
	 * @param Composer
	 * sets a new composer
	 */
	public void setComposer(String Composer)
	{
		this.Composer=Composer;
		
	}
	
	/**
	 * modifier
	 * @param year
	 * sets a new year
	 */
	public void setYear(String year)
	{
		this.Year = year;
		
	}
	
	/**
	 * modifier
	 * @param Genre
	 * sets a new genre
	 */
	public void setGenre(String Genre)
	{
		this.Genre = Genre;
		
	}
	
	/**
	 * modifier
	 * @param instrument
	 * sets a new instrument
	 */
	public void setInstrument(String instrument)
	{
		this.instrument=instrument;
		
	}
	
	/**
	 * accessor
	 * @return name of a song
	 */
	public String getName()
	{ 
		return this.name;
	}
	
	/**
	 * accessor
	 * @return Artist of a song
	 */
	public String getArtist()
	{
		return this.Artist;
		
	}
	
	/**
	 * accessor
	 * @return Composer of a song
	 */
	public String getComposer()
	{
		return this.Composer;
		
	}
	
	/**
	 * accessor
	 * @return Year of a song
	 */
	public String getYear()
	{
		return this.Year;
		
	}
	
	/**
	 * accessor
	 * @return Genre of a song
	 */
	public String getGenre()
	{
		return this.Genre;
		
	}
	
	/**
	 * accessor
	 * @return Instrument of a song
	 */
	public String getInstrument()
	{
		return this.instrument;
		
	}
	
	/**
	 * adds a note to song
	 * @param note
	 */
	public void addNote(Note note)
	{
		
		this.Song.add(note);
		
	}
	
	/**
	 * removes a note from song
	 * @param note
	 */
	public void removeNote(Note note)
	{
		this.Song.remove(note);
	}
	
	
	/**
	 * plays a song 
	 */
	public void PlaySong()
	{
		String output= "";
		for (int i = 0; i < Song.size(); i++){
			output = output + this.Song.get(i).getNoteName() + " ";
		}
		Player player = new Player();
		player.play(output);
		
		
	}
	public String toString(){
		  return "Name: " + this.getName() + "\n\n" +
		  "Artist: " + this.getArtist() + "\n\n" +
		  "Year: " + this.getYear() + "\n\n" +
		  "Composer: " + this.getComposer() + "\n\n" +
		  "Genre: " + this.getGenre() + "\n\n" +
		  "Composition Style: " + this.getCompositionStyle() + "\n\n" ;
		  
		 }
	
	/**
	 * Stops the song
	 */
	public void StopSong()
	{
		
	}

	
	/**
	 * accessor
	 * @return composition style
	 */
	public String getCompositionStyle() {
		return this.CompositionStyle;
		
	}
	
	/**
	 * mutative
	 * sets free atonal or algorithmic composition
	 * @param compositionStyle
	 */
	public void setCompositionStyle(String compositionStyle) {
		this.CompositionStyle = compositionStyle;
		
	}
}
