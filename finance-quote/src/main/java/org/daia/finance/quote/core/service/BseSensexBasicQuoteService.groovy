package org.daia.finance.quote.core.service

import org.daia.finance.quote.core.entity.Quote;

import wslite.soap.SOAPClient;

class BseSensexBasicQuoteService implements QuoteService {

	public Object getQuote() {
		
		try{
			def client = new SOAPClient("http://freewebservicesx.com/live-sensex-bse-index.asmx")
			
			def response = client.send(
				"""<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:fre="http://freewebservicesx.com/">
				   <soapenv:Header/>
				   <soapenv:Body>
				      <fre:GetLiveSensex>
				         <!--Optional:-->
				         <fre:UserName>daia.yum@gmail.com</fre:UserName>
				         <!--Optional:-->
				         <fre:Password>Electricshock</fre:Password>
				      </fre:GetLiveSensex>
				   </soapenv:Body>
				</soapenv:Envelope>""")
			def quote = new Quote(value: response.GetLiveSensexResponse.GetLiveSensexResult.string[0], lastUpdate: response.GetLiveSensexResponse.GetLiveSensexResult.string[2], change: response.GetLiveSensexResponse.GetLiveSensexResult.string[1])
			return quote;
			
		}catch(e){
			println e.getMessage()
			return null
		}
		
	}

}
