package gausselimination;
import java.text.DecimalFormat;//�Ҽ����� �����ϱ� ���� ���
public class gauss {
    static double[][] arr = {{2,-3,1,6,5},{2,-2,6,2,5},{2,-2,9,-1,6},{2,-2,9,4,9},{2,-2,9,4,16}};//�־����� �����ý���
    static double[] constant= {-3,5,9.7,10.3,11.7};//�����
    static double[] x = new double [5];//���� �������� �ظ� ������� �迭
    static double factor;//factor
    static int max=5;//�������� ����
    static DecimalFormat ans;//�Ҽ��� �����Ͽ� ���

    public static String formatD(double n){
        return ans.format(n);//�Ҽ��� ����
    }
    public static void print(){
    	System.out.println("======================================================");
        for(int i =0; i<max; i++)//�������� ��� (3�� : x1 x2 x3 / 5�� : x1 x2 x3 x4 x5)
        {
            System.out.print("\t");
            System.out.printf("%5c%d",'x',i+1);
        }
        System.out.print("\t");
        System.out.printf("%5c\n",'b');
        System.out.println("======================================================");
        for(int i = 0; i<max; i++)//�Ҽ��� ������ ���·� �������� ��� / ����� ���
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
    public static void eliminate() // �౳ȯ �� ��� �Ұ�
    {
        for (int cnt = 0; cnt < max - 1; cnt++) 
        {
        	System.out.println("\t\t    pivot�౳ȯ");
            pivot(cnt);// �Ұ��Ϸ��� pivot���� ���� ū ����� �Ұ��ϴ� ����� �� �� �ֵ��� �౳ȯ
            System.out.println("\t\t     x" + (cnt + 1) + " �Ұ�");
            for (int i = cnt; i < max - 1; i++) 
            {
                factor = arr[i + 1][cnt] / arr[cnt][cnt];//factor ���
                for (int j = cnt; j < max; j++) 
                {
                    arr[i + 1][j] -= arr[cnt][j] * factor;
                    if (Math.abs(arr[i + 1][j]) < 0.00001)//�ش� ���� ���� �� pivot �ҰŵǾ��ٰ� �Ǵ��Ͽ� 0���� ����
                    {
                    	arr[i + 1][j] = 0;
                    }
                }
                constant[i + 1] -= constant[cnt] * factor;
            }
            print();
        }
    }

    public static void pivot(int num)//�౳ȯ 
    {
        int cnt = num;
        boolean first = false;
        double big = arr[num][num];
        double temp;
        for(int i = num+1; i<max; i++)
        {
            if(big<Math.abs(arr[i][num]))//���� �����ÿ� �౳ȯ�� �̷�� �� �� �ֵ��� boolean ������ first �� true �� ����
            { 
                big = Math.abs(arr[i][num]);
                first = true;
                cnt = i;
            }
        }
        if(first)//big<Math.abs(arr[i][num]))�����ÿ�
        {
            for (int i = 0; i < max; i++)
            {
                temp = arr[cnt][i];
                arr[cnt][i] = arr[num][i];
                arr[num][i] = temp;
            }
            temp = constant[num];
            constant[num] = constant[cnt];
            constant[cnt] = temp;//�౳ȯ
            print();
        }
    }
    public static void substitute()//���������� ���� �ظ� ����
    {
        System.out.println("======================================================");
        System.out.println("\t\t[������������ ���� ��]");
        for(int i = max -1; i>=0; i--)//���������̱⿡ �������� ����
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
            System.out.println(formatD(x[i]));//������ �ظ� �Ҽ��� �����Ͽ� ���
        }
    }
    public static void main(String[] args) 
    {
    	System.out.println("\t\t   pivotȭ");
    	ans = new DecimalFormat("#.#####");
    	print();
        eliminate();
        substitute();
    }
}
