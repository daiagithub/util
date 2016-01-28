package org.daia.finance.quote

import javax.swing.JOptionPane;

import org.daia.finance.quote.core.entity.Quote;
import org.daia.finance.quote.core.service.BseSensexBasicQuoteService;

class GApp {

	static main(args) {
		def qoute = (Quote) new BseSensexBasicQuoteService().getQuote();
		JOptionPane.showMessageDialog(null, "" +  qoute.lastUpdate + ": " + qoute.value + " (" + qoute.change + ")" );
	}

}
