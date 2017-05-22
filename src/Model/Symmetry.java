package Model;

import java.util.ArrayList;

public interface Symmetry {
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow;
    public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow;
    public void retrograde() throws SymmetryActionOnNonValidAtonalRow;
    public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow;
    public ArrayList<Note> DoNothing() throws SymmetryActionOnNonValidAtonalRow;
    public ArrayList<Note>  Transpose(int x) throws SymmetryActionOnNonValidAtonalRow;
    public ArrayList<Note> Retrograde() throws SymmetryActionOnNonValidAtonalRow; 
    public ArrayList<Note> Reflect(int x) throws SymmetryActionOnNonValidAtonalRow;
}
