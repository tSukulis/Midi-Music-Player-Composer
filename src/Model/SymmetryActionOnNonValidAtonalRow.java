package Model;

@SuppressWarnings("serial")
public class SymmetryActionOnNonValidAtonalRow extends Exception{
	
	public SymmetryActionOnNonValidAtonalRow() {
    }

    //Constructor that accepts a message
    public SymmetryActionOnNonValidAtonalRow(String message) {
        super(message);
    }

    public SymmetryActionOnNonValidAtonalRow(Throwable cause) {
        super(cause);
    }

    public SymmetryActionOnNonValidAtonalRow(String message, Throwable cause) {
        super(message, cause);
    }

}
