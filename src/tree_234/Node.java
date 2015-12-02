package tree_234;

public class Node {
	public static final int num = 4;
	private Node parent;
	private int numItems=0;
	private  Node[] childNode = new Node[num];
	private  DataItem[] dataItem = new DataItem[num-1];
	public Node getChild(int n){//��ȡ�ӽڵ�
		return childNode[n];
	}
	public Node getParent(){
		return parent;
	}
	public boolean isLeaf(){ //�ж��Ƿ���Ҷ�ڵ�
		return(childNode[0]==null?true:false);
	}
	public int dataNum(){
		return numItems;
	}
	public DataItem getItem(int n){//��ȡ������
		return dataItem[n];
	}
	public boolean isFull(){
		return (numItems == num-1)?true:false;
	}
	public void connectNode(int n,Node child){ //�����ӽڵ�
		childNode[n] = child;
		if(child!=null){
			child.parent=this;
		}
	}
	public Node disConnectNode(int num){
		Node temp = childNode[num];
		childNode[num] = null;
		return temp;	
	}
	public int findNum(long key){//�ӵ�ǰ�ڵ����������λ��

		for(int i = 0;i < num-1;i++){
			if(dataItem[i]==null)break;
			else if(dataItem[i].dd == key){
				return i;
			}						
	}
		return -1;
}
	public int  insertData(DataItem data){
		numItems++;
		long d = data.dd;
		for(int i = num-2;i>=0;i--){
			if(dataItem[i]==null)continue;
			else{
			if(dataItem[i].dd > d){
				dataItem[i+1] = dataItem[i];
			}else{
				dataItem[i+1] = data;
				return i+1;
			}
			}
		}
		dataItem[0] = data;
		return 0;
	}
	public DataItem deleteItem(){
		DataItem temp = dataItem[numItems-1];
		dataItem[numItems-1] = null;
		numItems--;
		return temp;
	}
	public void display(){
		for(int i = 0;i < numItems;i++){
			dataItem[i].display();
		}
		System.out.println();
	}
}
