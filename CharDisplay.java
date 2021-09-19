public class CharDisplay extends AbstractDisplay {  // CharDisplay�� AbstractDisplay�� ���� Ŭ����
    private char ch;                                // ǥ���ؾ� �� ����
    public CharDisplay(char ch) {                   // �����ڿ��� �Ѿ�� ����ch��
        this.ch = ch;                               // �ʵ忡 ����� �д�.
    }
    public void open() {                            // ���� Ŭ���������� �߻�޼ҵ忴��. ���⼭ �������̵� �ؼ� ����.
        System.out.print("<<");                     // ���� ���ڿ��μ� "<<"�� ǥ���Ѵ�.
    }
    public void print() {                           // print�޼ҵ�� ���⼭ �����Ѵ�. �̰��� display���� �ݺ��ؼ� ȣ��ȴ�.
        System.out.print(ch);                       // �ʵ忡 ����ص� ���� 1���� ǥ��
    }
    public void close() {                           // close�޼ҵ嵵 ���⼭ ����
        System.out.println(">>");                   // ���Ṯ�ڿ� ">>"�� ǥ��.
    }
}
