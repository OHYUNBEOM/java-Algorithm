package test2;
import java.text.DecimalFormat;
public class gauss {
    static double[][] arr = {{1,2,-1},{5,2,2},{-3,5,-1}};
    static double[] constant= {2,9,1};
    static double[] x = new double [3];
    static double factor;
    static int max=3;
    static DecimalFormat ans;

    public static String formatD(double n){
        return ans.format(n);
    }
    public static void print(){
    	System.out.println("======================================================");
        for(int i =0; i<max; i++)
        {
            System.out.print("\t");
            System.out.printf("%5c%d",'x',i+1);
        }
        System.out.print("\t");
        System.out.printf("%5c\n",'b');
        System.out.println("======================================================");
        for(int i = 0; i<max; i++)
        {
            for(int j = 0; j<max; j++)
            {
                System.out.print('\t');
                System.out.printf("%5s",formatD(arr[i][j]));
            }
            System.out.print('\t');
            System.out.printf("%5s\n",formatD(constant[i]));
        }
        System.out.println();
    }
    public static void eliminate() {
        for (int cnt = 0; cnt < max - 1; cnt++) 
        {
        	System.out.println("\t\t    pivot행교환");
            pivot(cnt);
            System.out.println("\t\t     x" + (cnt + 1) + " 소거");
            for (int i = cnt; i < max - 1; i++) 
            {
                factor = arr[i + 1][cnt] / arr[cnt][cnt];
                for (int j = cnt; j < max; j++) 
                {
                    arr[i + 1][j] -= arr[cnt][j] * factor;
                    if (Math.abs(arr[i + 1][j]) < 0.00001)
                    {
                    	arr[i + 1][j] = 0;
                    }
                }
                constant[i + 1] -= constant[cnt] * factor;
            }
            print();
        }
    }

    public static void pivot(int num)
    {
        int cnt = num;
        boolean first = false;
        double big = arr[num][num];
        double temp;
        for(int i = num+1; i<max; i++)
        {
            if(big<Math.abs(arr[i][num]))
            { 
                big = Math.abs(arr[i][num]);
                first = true;
                cnt = i;
            }
        }
        if(first) 
        {
            for (int i = 0; i < max; i++)
            {
                temp = arr[cnt][i];
                arr[cnt][i] = arr[num][i];
                arr[num][i] = temp;
            }
            temp = constant[num];
            constant[num] = constant[cnt];
            constant[cnt] = temp;
            print();
        }
    }
    public static void substitute()
    {
        System.out.println("======================================================");
        System.out.println("\t\t[후진대입으로 구한 해]");
        for(int i = max -1; i>=0; i--)
        {
            System.out.print("x"+(i+1)+ " = ");
            if(i == max -1)
            {
                x[i] = constant[i]/arr[i][i];
            }
            else 
            {
                double temp = 0;
                for (int j = max - 1; j > i; j--)
                {
                	temp += arr[i][j] * x[j];
                }
                x[i] = (constant[i] - temp) / arr[i][i];
            }
            System.out.println(formatD(x[i]));
        }
    }
    public static void main(String[] args) 
    {
    	System.out.println("\t\t   pivot화");
    	ans = new DecimalFormat("#.#####");
    	print();
        eliminate();
        substitute();
    }
}
