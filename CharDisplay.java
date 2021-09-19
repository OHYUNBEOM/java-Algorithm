public class CharDisplay extends AbstractDisplay {  // CharDisplay는 AbstractDisplay의 하위 클래스
    private char ch;                                // 표시해야 할 문자
    public CharDisplay(char ch) {                   // 생성자에서 넘어온 문자ch를
        this.ch = ch;                               // 필드에 기억해 둔다.
    }
    public void open() {                            // 상위 클래스에서는 추상메소드였다. 여기서 오버라이드 해서 구현.
        System.out.print("<<");                     // 시작 문자열로서 "<<"를 표시한다.
    }
    public void print() {                           // print메소드로 여기서 구현한다. 이것이 display에서 반복해서 호출된다.
        System.out.print(ch);                       // 필드에 기억해둔 문자 1개를 표시
    }
    public void close() {                           // close메소드도 여기서 구현
        System.out.println(">>");                   // 종료문자열 ">>"를 표시.
    }
}
