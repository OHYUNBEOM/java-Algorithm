package org.onlineshopping.facade;

import org.onlineshopping.bridge.Online;
import org.onlineshopping.client.Common;

public class Paypal {
Online online=new Online();
	
	public void PaypalPayment(){
		Common.BlankSpaces();
		online.Paypal("UserName", "Password", 0);
	}
}
