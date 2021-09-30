public class StringDisplayImpl extends DisplayImpl {
    private String string;                              // 표시해야할 문자열
    private int width;                                  // 바이트 단위로 계산한 문자열의 "길이"
    public StringDisplayImpl(String string) {           // 생성자에서 넘어온 문자열 string를
        this.string = string;                               // 필드에 기억해 둔다
        this.width = string.getBytes().length;              // 그리고 바이트 단위의 길이도 필드에 기억해두고 나중에 사용한다.
    }
    public void rawOpen() {
        printLine();
    }
    public void rawPrint() {
        System.out.println("|" + string + "|");         // 앞뒤에 "|"를 붙여서 표시
    }
    public void rawClose() {
        printLine();
    }
    private void printLine() {
        System.out.print("+");                          // 틀의 모퉁이를 표현하는 "+"마크를 표시한다.
        for (int i = 0; i < width; i++) {               // width개의 "-"를 표시해서
            System.out.print("-");                      // 틀의 선으로 이용한다.
        }
        System.out.println("+");                        // 틀의 모퉁이를 표현하는 "+"마크를 표시한다.
    }
}
