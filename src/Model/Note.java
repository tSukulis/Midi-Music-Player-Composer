package Model;

import org.jfugue.Player;


public class Note {
	private String name;
	
	/**
	 * constructor 
	 * @param name
	 * creates a new note 
	 */
	public Note(String name)
	{
		this.name=name;
	}
	
	/**
	 * mutative
	 * @param name
	 * sets a new name for a note
	 */
	public void setNoteName(String name)
	{
		this.name=name;
	}
	
	/**
	 * accessor
	 * @return name of a note
	 */
	public String getNoteName()
	{
		return this.name;
	}
	
	/**
	 * plays a note
	 */
	public void PlayNote()
	{
		Player pl=new Player();
		pl.play(this.getNoteName());
		
	}
	
	/**
	 * stops playong a note
	 */
	public void StopNote()
	{
		
	}

}
