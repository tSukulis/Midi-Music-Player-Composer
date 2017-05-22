package Model;

import java.util.ArrayList;





public class AtonalComposition extends Composition  implements Symmetry {
	private AtonalRow seedrow;
	
	public AtonalComposition(String name,String artist,String composer,String year,String genre,String instrument)
	{
		super(name,artist,composer,year,genre,instrument);
		
	}
	
	public void setSeedrow(AtonalRow ar)
	{
		this.seedrow=ar;
	}
	
	public AtonalRow getSeedrow()
	{
		return seedrow; 
	}
	
	
		
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
		
		int counter=0;
		boolean flag=true;
		ArrayList<Note> temp = new ArrayList<Note>();
		ArrayList<Note> tmp = new ArrayList<Note>();
		for(int i=0;i<this.getSong().size();i++)
		{
			counter++;
			temp.add(this.getSong().get(i));
			
			if(counter==12)
			{
				flag=false;
				AtonalRow seedrow = new AtonalRow(temp);
				tmp.addAll(seedrow.DoNothing());
				temp.clear();
				counter=0;
			}
			
		}
		this.getSong().addAll(tmp);
	}
	
	

	@Override
	/**
	 * Like calling the AtonalRow transpose for every String Note line. 
	 */
	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		int counter=0;
		ArrayList<Note> temp = new ArrayList<Note>();
		ArrayList<Note> tmp = new ArrayList<Note>();
		for(int i=0;i<this.getSong().size();i++)
		{
			counter++;
			temp.add(this.getSong().get(i));
			
			if(counter==12)
			{
				AtonalRow seedrow = new AtonalRow(temp);
				tmp.addAll(seedrow.Transpose(x));
				temp.clear();
				counter=0;
			}
			
		}
		this.getSong().addAll(tmp);
	}

	@Override
	/**
	 * For every Note String line, adds the reversed edition of it at the end of the Note String. ex. <a b b.retrogate a.retrogate>
	 */
	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		int counter=0;
		ArrayList<Note> temp = new ArrayList<Note>();
		ArrayList<Note> tmp = new ArrayList<Note>();
		ArrayList<Note> tmp2 = new ArrayList<Note>();
		for(int i=this.getSong().size()-1;i>=0;i--)
		{
			counter++;
			temp.add(this.getSong().get(i));
			
			if(counter==12)
			{
				for(int j=temp.size()-1;j>=0;j--)
				{
					tmp2.add(temp.get(j));
				}
				AtonalRow seedrow = new AtonalRow(tmp2);
				tmp.addAll(seedrow.Retrograde());
				temp.clear();
				tmp2.clear();
				counter=0;
			}
			
		}
		this.getSong().addAll(tmp);
		
	}

	@Override
	/**
	 * Adds the reflect of everyline at the end of the end of the String Note.
	 */
	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		int counter=0;
		ArrayList<Note> temp = new ArrayList<Note>();
		ArrayList<Note> tmp = new ArrayList<Note>();
		for(int i=0;i<this.getSong().size();i++)
		{
			counter++;
			temp.add(this.getSong().get(i));
			
			if(counter==12)
			{
				AtonalRow seedrow = new AtonalRow(temp);
				tmp.addAll(seedrow.Reflect(x));
				temp.clear();
				counter=0;
			}
			
		}
		this.getSong().addAll(tmp);
	}
		
	

	@Override
	public ArrayList<Note> DoNothing() throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> Transpose(int x)
			throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> Retrograde()
			throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> Reflect(int x)
			throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
	

}
