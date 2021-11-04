import java.util.Iterator;
public class NumberOfFileVisitor extends Visitor{
	private String currentdir="";

	@Override
	public void visit(File file) {
		// TODO Auto-generated method stub
		//visit������ file �� ī�����ϴ� ����� �ƴϹǷ� visit�� �ƹ� ���۵� ���� �ʵ��� ����
	}

	@Override
	public void visit(Directory directory) {//Directory visit �ÿ� ����Լ� countFile�� file������ �ľ�
		// TODO Auto-generated method stub
		String savedir=currentdir;
		Iterator it = directory.iterator();
		currentdir+="/"+directory.getName();
		System.out.println(currentdir+" has "+countFile(directory,0)+" Files.");
		while(it.hasNext())
		{
			Entry entry = (Entry)it.next();
			entry.accept(this);//entry �� visit
		}
		currentdir=savedir;
	}
	public int countFile(Directory directory,int count)
	{
		Iterator children = directory.iterator();
		while(children.hasNext())//children �� ������ �ִٸ�, �� file�� �������ִٸ�
		{
			Entry entry = (Entry)children.next();
			if(entry.getClass().getName()=="File")
			{
				count+=1;//file������ ī����
			}
			else if(entry.getClass().getName()=="Directory")
			{
				count+=countFile((Directory)entry,0);//Child�� directory �� �� ��������� ���� ī����
			}
		}
		return count;
	}
}