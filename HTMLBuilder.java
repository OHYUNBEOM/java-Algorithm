import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename;                                    // 작성할 파일명
    private PrintWriter writer;                                 // 파일에 써넣을 PrintWriter
    public void makeTitle(String title) {                       // HTML 파일에서의 타이틀
        filename = title + ".html";                                 // 타이틀로 토대로 파일명을 결정
        try {
            writer = new PrintWriter(new FileWriter(filename));     // PrintWriter를 작성
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");    // 타이틀을 출력
        writer.println("<h1>" + title + "</h1>");
    }
    public void makeString(String str) {                        // HTML 파일에서의 문자열
        writer.println("<p>" + str + "</p>");                       // <p>태그로 출력
    }
    public void makeItems(String[] items) {                     // HTML 파링에서의 항목
        writer.println("<ul>");                                     // <ul>과<li>로 출력
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }
    public Object getResult() {                                 // 완성된 문서
        writer.println("</body></html>");                           // 태그를 닫는다.
        writer.close();                                             // 파일을 클로즈
        return filename;                                            // 파일명을 반환한다.
    }
}
