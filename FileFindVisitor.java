import java.util.Iterator;
import java.util.Vector;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private Vector found = new Vector();
    public FileFindVisitor(String filetype) {           // ".txt"처럼 확장자를 .을 붙여 지정
        this.filetype = filetype;
    }
    public Iterator getFoundFiles() {                   // 발견한 파일을 얻는다.
        return found.iterator();
    }
    public void visit(File file) {                  // 파일을 방문했을 때에 호출된다.
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }
    public void visit(Directory directory) {   // 디렉토리를 방문했을 때 호출된다.
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
