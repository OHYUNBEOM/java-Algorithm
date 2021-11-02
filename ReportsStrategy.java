package org.onlineshopping.strategy;

public abstract class ReportsStrategy {
	public abstract void SetReports(String UserName, String Operation, String Item, String Cost);
	public abstract void PrintReports();
	public abstract void ClearReportsWhenUserLoggedIn();
}
