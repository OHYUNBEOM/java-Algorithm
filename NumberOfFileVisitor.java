import java.util.Iterator;
public class NumberOfFileVisitor extends Visitor{
	private String currentdir="";

	@Override
	public void visit(File file) {
		// TODO Auto-generated method stub
		//visit내에서 file 을 카운팅하는 방식이 아니므로 visit은 아무 동작도 하지 않도록 구현
	}

	@Override
	public void visit(Directory directory) {//Directory visit 시에 재귀함수 countFile로 file개수를 파악
		// TODO Auto-generated method stub
		String savedir=currentdir;
		Iterator it = directory.iterator();
		currentdir+="/"+directory.getName();
		System.out.println(currentdir+" has "+countFile(directory,0)+" Files.");
		while(it.hasNext())
		{
			Entry entry = (Entry)it.next();
			entry.accept(this);//entry 에 visit
		}
		currentdir=savedir;
	}
	public int countFile(Directory directory,int count)
	{
		Iterator children = directory.iterator();
		while(children.hasNext())//children 을 가지고 있다면, 즉 file을 가지고있다면
		{
			Entry entry = (Entry)children.next();
			if(entry.getClass().getName()=="File")
			{
				count+=1;//file개수를 카운팅
			}
			else if(entry.getClass().getName()=="Directory")
			{
				count+=countFile((Directory)entry,0);//Child가 directory 일 때 재귀적으로 복합 카운팅
			}
		}
		return count;
	}
}