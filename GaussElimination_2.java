package gausselimination;
import java.text.DecimalFormat;//소수점을 고정하기 위해 사용
public class gauss {
    static double[][] arr = {{2,-3,1,6,5},{2,-2,6,2,5},{2,-2,9,-1,6},{2,-2,9,4,9},{2,-2,9,4,16}};//주어지는 선형시스템
    static double[] constant= {-3,5,9.7,10.3,11.7};//상수항
    static double[] x = new double [5];//구한 미지수의 해를 집어넣을 배열
    static double factor;//factor
    static int max=5;//미지수의 개수
    static DecimalFormat ans;//소수점 고정하여 출력

    public static String formatD(double n){
        return ans.format(n);//소수점 고정
    }
    public static void print(){
    	System.out.println("======================================================");
        for(int i =0; i<max; i++)//미지수를 출력 (3개 : x1 x2 x3 / 5개 : x1 x2 x3 x4 x5)
        {
            System.out.print("\t");
            System.out.printf("%5c%d",'x',i+1);
        }
        System.out.print("\t");
        System.out.printf("%5c\n",'b');
        System.out.println("======================================================");
        for(int i = 0; i<max; i++)//소수점 고정한 상태로 미지수의 계수 / 상수항 출력
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
    public static void eliminate() // 행교환 및 계수 소거
    {
        for (int cnt = 0; cnt < max - 1; cnt++) 
        {
        	System.out.println("\t\t    pivot행교환");
            pivot(cnt);// 소거하려는 pivot열의 가장 큰 계수가 소거하는 계수가 될 수 있도록 행교환
            System.out.println("\t\t     x" + (cnt + 1) + " 소거");
            for (int i = cnt; i < max - 1; i++) 
            {
                factor = arr[i + 1][cnt] / arr[cnt][cnt];//factor 계산
                for (int j = cnt; j < max; j++) 
                {
                    arr[i + 1][j] -= arr[cnt][j] * factor;
                    if (Math.abs(arr[i + 1][j]) < 0.00001)//해당 조건 만족 시 pivot 소거되었다고 판단하여 0으로 변경
                    {
                    	arr[i + 1][j] = 0;
                    }
                }
                constant[i + 1] -= constant[cnt] * factor;
            }
            print();
        }
    }

    public static void pivot(int num)//행교환 
    {
        int cnt = num;
        boolean first = false;
        double big = arr[num][num];
        double temp;
        for(int i = num+1; i<max; i++)
        {
            if(big<Math.abs(arr[i][num]))//조건 만족시에 행교환이 이루어 질 수 있도록 boolean 변수인 first 를 true 로 변경
            { 
                big = Math.abs(arr[i][num]);
                first = true;
                cnt = i;
            }
        }
        if(first)//big<Math.abs(arr[i][num]))만족시에
        {
            for (int i = 0; i < max; i++)
            {
                temp = arr[cnt][i];
                arr[cnt][i] = arr[num][i];
                arr[num][i] = temp;
            }
            temp = constant[num];
            constant[num] = constant[cnt];
            constant[cnt] = temp;//행교환
            print();
        }
    }
    public static void substitute()//후진대입을 통해 해를 구함
    {
        System.out.println("======================================================");
        System.out.println("\t\t[후진대입으로 구한 해]");
        for(int i = max -1; i>=0; i--)//후진대입이기에 역행으로 대입
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
            System.out.println(formatD(x[i]));//구해진 해를 소수점 고정하여 출력
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
