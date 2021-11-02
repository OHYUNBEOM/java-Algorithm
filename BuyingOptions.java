package org.onlineshopping.facade;

import java.io.IOException;

import org.onlineshopping.client.Common;
import org.onlineshopping.items.Items;

public class BuyingOptions {
public void Pay(int ModeOfPayment) throws NumberFormatException, IOException{

	switch (ModeOfPayment) {
	case 1:
		Credit credit=new Credit();
		credit.CreditCardPayment();
		break;
		
	case 2:
		Debit debit=new Debit();
		debit.DebitCardPayment();

		break;

	case 3:
		Paypal paypal=new Paypal();
		paypal.PaypalPayment();
		break;

		
	default:
		Common.BlankSpaces();
		Items items=new Items();
		items.DisplayItems();
		break;
	}	
}

}
