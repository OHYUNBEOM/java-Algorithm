package org.onlineshopping.facade;

import org.onlineshopping.bridge.Online;
import org.onlineshopping.client.Common;

public class Credit {
	Online online=new Online();
	
	public void CreditCardPayment(){
		Common.BlankSpaces();
		online.CreditCard(0, 0, "0", 0);
	}
}
