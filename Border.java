public abstract class Border extends Display {
    protected Display display;          // 장식이 감싸고 있는 "내용물"을 가리킨다.
    protected Border(Display display) { // 인스턴스 생성시에 "내용물"을 인수로 지정
        this.display = display;
    }
}
