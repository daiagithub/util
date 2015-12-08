package org.daiayum.util;

import javax.swing.JOptionPane;

public class App {
    public static void main( String[] args ){
    	InsideOutPredictor insideOutPredictor = new InsideOutPredictorWithWinCommand();
    	insideOutPredictor.setElapsedSeconds();
    	insideOutPredictor.setAllTimeComponentsValues();
    	String message = insideOutPredictor.generateMessage();
    	JOptionPane.showMessageDialog(null, message);
    }
}
