package test;
import java.io.*;
public class coding {
	static double[][] origin= {{1,2,-1},{5,2,2},{-3,5,-1}};
	static double[][] eli=origin;
	static double[] constant= {2,9,1};
	static double[] s= {1,1,1},x= {1,1,1};
	static int er=0;
	static double tol=0.00001;
	static int n = origin.length-1;
	public static void main(String[] args)
	{
		gauss();
		System.out.println("구해진 해 --> ");
		for(int i=0;i<x.length; i++)
		{
			System.out.printf("x" + (i+1)+" = %.3f\n", x[i]);
		}
	}
	public static void gauss()
	{
		for(int i=0; i<n; i++)
		{
			s[i]=Math.abs(origin[i][0]);
			for(int j=1; j<n; j++)
			{
				if(Math.abs(origin[i][j])>s[i])
				{
					s[i]=Math.abs(origin[i][j]);
				}
			}
		}
		Eliminate();
		if(er!=-1)
		{
			Substitute();
		}
	}
	public static void Eliminate()
	{
		double factor;
		for(int k=0; k<=n; k++)
		{
			Pivot(k);
			if(Math.abs(origin[k][k])<tol)
			{
				er=-1;
				break;
			}
			for(int i=k+1; i<=n; i++)
			{
				factor=origin[i][k]/origin[k][k];
				eli[i][k]=0;
				for(int j=k+1; j<=n; j++)
				{
					origin[i][j]=origin[i][j]-(factor*origin[k][j]);
				}
				constant[i]=constant[i]-(factor*constant[k]);
				print();
			}
		}
		if(Math.abs(origin[n][n])/s[n]<tol)
		{
			er=-1;
		}
	}
	public static void Substitute()
	{
		double sum;
		for(int i=n-1;i>0;i--)
		{
			if(i==n-1)
			{
				x[n]=constant[n]/origin[n][n];
			}
			else
			{
				sum=0;
				for(int j=i+1;j<n;j++)
				{
					sum+=(origin[i][j]*x[j]);
				}
				x[i]=sum/origin[i][i];
			}
		}
	}
	public static void Pivot(int k)
	{
		double big;
		double dummy = 0;
		int p=k;
		
		big=Math.abs(origin[k][k]);
		for(int i=k+1; i<=n; i++)
		{
			dummy=Math.abs(origin[i][k]);
			if(big<dummy)
			{
				big=dummy;
				p=i;
			}
		}
		if(p!=k)
		{
			System.out.println("Pivot화 Pivot화 Pivot화 Pivot화 Pivot화 Pivot화 Pivot화 Pivot화 Pivot화 ");
			for(int j=k;j<=n;j++)
			{
				dummy=origin[p][j];
				origin[p][j]=origin[k][j];
				origin[k][j]=dummy;
			}
			dummy=constant[p];
			constant[p]=constant[k];
			constant[k]=dummy;
			dummy=s[p];
			s[p]=s[k];
			s[k]=dummy;
			print();
		}
	}
	public static void print()
	{
		for(int i=0; i<origin.length; i++)
		{
			for(int j=0; j<origin.length;j++)
			{
				System.out.printf("%3f\t", eli[i][j]);
			}
			System.out.printf(" = %.3f", constant[i]);
			System.out.println();
		}
		System.out.println();
	}
}


