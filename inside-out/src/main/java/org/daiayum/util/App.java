package org.daiayum.util;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main( String[] args ){
    	InsideOutPredictor insideOutPredictor = new InsideOutPredictorWithWinCommand();
    	insideOutPredictor.setElapsedSeconds();
    	insideOutPredictor.setAllTimeComponentsValues();
    	String message = insideOutPredictor.generateMessage();
    	JOptionPane.showMessageDialog(null, message);
    	Logger logger = LoggerFactory.getLogger(App.class);
    	logger.info("aaaa");
    }
}
