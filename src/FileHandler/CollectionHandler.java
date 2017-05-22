package FileHandler;

import java.io.File;
import java.util.ArrayList;

import Collection.MusicCollection;
import Model.*;


public class CollectionHandler {
	private String collectionfilename;
	private String collectionpath;
	
	
	public CollectionHandler()
	{
		 
	}
	
	
	public CollectionHandler(String collectionfilename, String collectionpath)
	{
		this.collectionfilename = collectionfilename;
		this.collectionpath = collectionpath;
	}
	 
	/**
	 * saves a collection
	 * @param musiccollection
	 */
	public void SaveToFolder(MusicCollection musiccollection, String folderpath)
	{	
		File f = new File(folderpath + "/" + this.getCollectionfilename());
		try{
			if(f.mkdir()) { 
				ArrayList<Composition> temp = musiccollection.Getplaylist();
				for (int i = 0; i < temp.size();i++){
					CompositionHandler compHand = new CompositionHandler("myMusic" + i + ".txt", folderpath + "/" + this.getCollectionfilename());
					compHand.SaveToFile(temp.get(i));
					
				}

		    } else {
		        System.out.println("Directory is not created");
		    }
			
			
		}
		catch (Exception e){
			System.err.println("Exception: " + e.getMessage());
		}
	}
	
	/**
	 * reads a music collection
	 * @param collectionpath
	 */
	public void ReadFromFolder(String collectionpath)
	{
		
	}
	
	/**
	 * 
	 * @return name of the file
	 */
	public String getCollectionfilename() {
		return this.collectionfilename;
	}
	
	/**
	 * sets a new colletionfilename
	 * @param collectionfilename
	 */
	public void setCollectionfilename(String collectionfilename) {
		this.collectionfilename = collectionfilename;
	}
	
	/**
	 * accessor 
	 * @return the collectionpath
	 */
	public String getCollectionpath() {
		return collectionpath;
	}
	
	/**
	 * accessor
	 * @param collectionpath
	 * sets a new path
	 */
	public void setCollectionpath(String collectionpath) {
		this.collectionpath = collectionpath;
	}

}
