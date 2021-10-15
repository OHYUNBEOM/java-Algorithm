public class Director {
    private Builder builder;
    public Director(Builder builder) {      // Builder의 하위 클래스의 인스턴스가 제공되기 때문에
        this.builder = builder;             // builder 필드에 보관해 둔다.
    }
    public Object construct() {             // 문서 구축
        builder.makeTitle("Greeting");              // 타이틀
        builder.makeString("아침과 낮에");     // 문자열
        builder.makeItems(new String[]{             // 항목
            "좋은 아침입니다.",
            "안녕하세요",
        });
        builder.makeString("밤에");                 // 다른 문자열
        builder.makeItems(new String[]{             // 다른 항목
            "안녕하세요",
            "안녕히 주무세요",
            "안녕히 계세요",
        });
        return builder.getResult();                 // 완성된 문서가 반환 값이 된다.
    }
}
