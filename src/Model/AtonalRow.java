package Model;

import java.util.ArrayList;



public class AtonalRow extends Composition  implements Symmetry {
	private ArrayList<Note> temp;
	
	private ArrayList<Note> prototyperow= new ArrayList<Note>();
	
	
	
	
	
	



	/**
	 * checks if note is contained to arraylist<note> song
	 * @param note
	 * @return true of false
	 */
	
	public AtonalRow(ArrayList<Note> row)
	{
		this.temp=row;
	}
	
	public void createprototyperow()
	{
		Note d = new Note("C");
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
		this.prototyperow.add(d);
		this.prototyperow.add(f);
		this.prototyperow.add(h);
		this.prototyperow.add(p);
		this.prototyperow.add(w);
		this.prototyperow.add(t);
		this.prototyperow.add(y);
		this.prototyperow.add(u);
		this.prototyperow.add(l);
		this.prototyperow.add(k);
		this.prototyperow.add(r);
		this.prototyperow.add(q);
		
		
	}
	
	
	

	public void replacefortransp()
	{
		
	}
	


	/**
	 * Does nothing. Duh?
	 */
	public ArrayList<Note>  DoNothing() throws SymmetryActionOnNonValidAtonalRow 
	{
		
		ArrayList<Note> atemp = new ArrayList<Note>();
		atemp.addAll(this.temp);
		
		return atemp;
		
		
				
	}

	
	/**
	 * Slides the string x times clockwise
	 */
	public ArrayList<Note>  Transpose(int x) throws SymmetryActionOnNonValidAtonalRow 
	{	
		 ArrayList<Note> atemp = new ArrayList<Note>();
		 this.createprototyperow();
		
		for(int i=0;i<this.temp.size();i++)
		{
			for(int j=0;j<this.prototyperow.size();j++)
			 {	
				
				 if(this.temp.get(i).getNoteName().equals(this.prototyperow.get(j).getNoteName()))
				 {
					 
					 if(j==this.prototyperow.size()-1)
					 {
						 atemp.add(this.prototyperow.get(0+x-1));
						 break;
						 
					 }
					 else
					 {
						 atemp.add(this.prototyperow.get(j+x));
						 
						 break;
					 }
					 
					 
				 }
					 
			}
					 
		}
		return atemp;
	}

	
	/**
	 * reverses a Note string
	 */
	public ArrayList<Note> Retrograde() throws SymmetryActionOnNonValidAtonalRow 
	{
		 ArrayList<Note> atemp = new ArrayList<Note>();
		
		for(int i=this.temp.size()-1;i>=0;i--)
		{
			atemp.add(this.temp.get(i));
		}
		this.temp.addAll(atemp);
		return atemp;
		
	}

	/**
	 * processes all 12 notes of the given input and reflects them. Kinda like retrogate with value 6.
	 */
	public ArrayList<Note> Reflect(int x) throws SymmetryActionOnNonValidAtonalRow 
	{
		ArrayList<Note> atemp = new ArrayList<Note>();
		this.createprototyperow();
		
	 for(int j=0;j<this.temp.size();j++)
	 {
		 if(this.temp.get(j).getNoteName()==this.prototyperow.get(0).getNoteName())
		 {
			 
			 if(j==0)
			 {
				 atemp.add(this.prototyperow.get(j));
				 
				 if(this.temp.get(j+1).getNoteName()==this.prototyperow.get(1).getNoteName())
				 {
					 for(int i=this.prototyperow.size()-1;i>0;i--)
					 {
						 atemp.add(this.prototyperow.get(i));
					 }
				 }
				 else if(this.temp.get(j+1).getNoteName()==this.prototyperow.get(11).getNoteName())
				 {
					 for(int i=1;i<this.prototyperow.size();i++)
					 {
						 atemp.add(this.prototyperow.get(i));
					 }
				 }
			 }
			 else if(j==11)
			 {
				 //System.out.println("temp"+ this.temp.get(0).getNoteName()+"====="+ this.prototyperow.get(j));
				 if(this.temp.get(0).getNoteName()==this.prototyperow.get(1).getNoteName())
				 {
					 atemp.add(this.prototyperow.get(11));
					 for(int i=this.prototyperow.size()-2;i>=0;i--)
					 {
						 atemp.add(this.prototyperow.get(i));
					 }
					 
				 }
				 else if(this.temp.get(0).getNoteName()==this.prototyperow.get(11).getNoteName())
				 {
					 
					 for(int i=1;i<this.prototyperow.size();i++)
					 {
						 atemp.add(this.prototyperow.get(i));
					 }
					 atemp.add(this.prototyperow.get(0));
				 }
			 }
			 
		 }
	 }
	 
	 
	 
	 return atemp;
		
		
	}


	@Override
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}


	
		
	

}
