public class SideBorder extends Border {
    private char borderChar;                        // 장식이 되는 문자
    public SideBorder(Display display, char ch) {   // 생성자에서 Display와 장식문자를 지정
        super(display);
        this.borderChar = ch;
    }
    public int getColumns() {                       // 문자수는 내용물의 양쪽에 장식 문자분을 더한 것
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                          // 줄수는 내용물의 줄수와 같음
        return display.getRows();
    }
    public String getRowText(int row) {             // 지정한 줄의 내용은 내용물의 지정 줄의 양쪽에 장식문자를 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
