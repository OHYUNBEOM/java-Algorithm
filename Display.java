public abstract class Display {
    public abstract int getColumns();               // 가로의 문자수를 얻는다.
    public abstract int getRows();                  // 세로의 줄수를 얻는다.
    public abstract String getRowText(int row);     // row번째의 문자열을 얻는다.
    public final void show() {                      // 전부를 표시한다.
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
