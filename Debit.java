package org.onlineshopping.facade;

import org.onlineshopping.bridge.Online;
import org.onlineshopping.client.Common;

public class Debit {
Online online=new Online();
	
	public void DebitCardPayment(){
		Common.BlankSpaces();
		online.DebitCard(0, 0, "0", 0);
	}
}
