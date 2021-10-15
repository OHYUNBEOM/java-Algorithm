public class TextBuilder extends Builder {
    private String buffer = "";                                 // 이 필드에 문서를 구축한다.
    public void makeTitle(String title) {                       // 일반 텍스트에서의 타이틀
        buffer += "==============================\n";               // 장식선
        buffer += "『" + title + "』\n";                            // 『 』이 있는 타이틀
        buffer += "\n";                                             // 공란
    }
    public void makeString(String str) {                        // 일반 텍스트에서의 문자열
        buffer += '■' + str + "\n";                                // ■ 이 있는 문자열
        buffer += "\n";                                             // 공란

    }
    public void makeItems(String[] items) {                     // 일반 텍스트에서의 항목
        for (int i = 0; i < items.length; i++) {
            buffer += "●" + items[i] + "\n";                     // ●이 있는 항목
        }
        buffer += "\n";                                             // 공란
    }
    public Object getResult() {                                 // 완성된 문서
        buffer += "==============================\n";               // 장식선
        return buffer;
    }
}
