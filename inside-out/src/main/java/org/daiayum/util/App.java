package org.daiayum.util;

import javax.swing.JOptionPane;

public class App {
    public static void main( String[] args ){
    	InsideOut.setElapsedSeconds();
    	InsideOut.setAllTimeComponentsValues();			
		JOptionPane.showMessageDialog(null, InsideOut.generateMessage());		
    }
}
