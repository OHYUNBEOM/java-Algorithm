package org.onlineshopping.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.onlineshopping.client.Buyer;
import org.onlineshopping.client.BuyerOptions;
import org.onlineshopping.client.Common;

public class Reports extends ReportsStrategy{

	static ArrayList<String> myArr=new ArrayList<String>();

	@Override
	public void SetReports(String UserName, String Operation, String Item,
			String Cost) {
		myArr.add(UserName+" "+Operation+" "+ Item+" "+Cost);
		
	}

	@Override
	public void PrintReports() {
		// TODO Auto-generated method stub
		Common.BlankSpaces();
		Common.DrawLine();
		Buyer buyer=new Buyer();
		System.out.println(buyer.getBuyer_UserName()+"'s Reports");
		Common.DrawLine();
		for(int i=0;i<myArr.size();i++){
			String Data=myArr.get(i);
			String[] ArrayData=Data.split(" ");
			String Type=ArrayData[2].toString();
			if(Type.equals("Buyable")||Type.equals("Rentable")){
			System.out.println(myArr.get(i));
			}
		}		
		
		Common.InsertDoubleSpace();
		System.out.println("Press Enter To Back");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
		br.readLine();
		Common.BlankSpaces();
		BuyerOptions buyeroptions=new BuyerOptions();
		buyeroptions.MainOptions();
		}
		catch(Exception er){}
		
		
	}

	@Override
	public void ClearReportsWhenUserLoggedIn() {
		// TODO Auto-generated method stub
		myArr.clear();
	}


}
