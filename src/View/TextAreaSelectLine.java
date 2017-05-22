package View;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultEditorKit;

public class TextAreaSelectLine extends JFrame implements MouseListener {

	JTextArea textArea;
    Action selectLine;
    
    
    public TextAreaSelectLine(){
    	textArea = new JTextArea();
    	textArea.addMouseListener(this);
    	
    	JScrollPane sp = new JScrollPane(textArea);
    	getContentPane().add(sp, BorderLayout.SOUTH);
    	getContentPane().add( new JTextArea() );
    	  
        selectLine = getAction(DefaultEditorKit.selectLineAction);
    	
    }
    
    
    private Action getAction(String name){
        Action action = null;
        Action[] actions = textArea.getActions();
  
        for (int i = 0; i < actions.length; i++){
            if (name.equals( actions[i].getValue(Action.NAME).toString() ) ){
                action = actions[i];
                break;
            }
        }
  
        return action;
    }
  
    public void mouseClicked(MouseEvent e){
  
        if ( SwingUtilities.isLeftMouseButton(e)  && e.getClickCount() == 1){
            selectLine.actionPerformed( null );
        }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
