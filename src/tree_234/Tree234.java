package tree_234;

public class Tree234 {
	Node root = new Node();
	public void insert(){
		
	}
	public Node getNextChild(Node node,long key){
		int numberItem = node.dataNum();
		int j;
		for(j=0;j<numberItem;j++){
			if(key < node.getItem(j).dd){
				return node.getChild(j);
			}
		}
		return node.getChild(j);
	}
	public void insert(long key){
		Node curNode = root;
		DataItem tempItem = new DataItem(key);
		while(true){
			if(curNode.isFull()){
			spilt(curNode);
			curNode = curNode.getParent();
			curNode = getNextChild(curNode,key);
			}else if(curNode.isLeaf()){
				break;
			}else{
				curNode = getNextChild(curNode,key);
			}
			}
		curNode.insertData(tempItem);
	}
	public void spilt(Node node){//拆分树
		DataItem itemB,itemC;
		Node parent,child2,child3;
		int itemIndex;
		itemC = node.deleteItem();
		itemB = node.deleteItem();
		child2 = node.disConnectNode(2);
		child3 = node.disConnectNode(3);
		Node newRight = new Node();
		if(node == root){//如果是根
			root = new Node();
			parent=root;
			root.connectNode(0, node);
		}else{
			parent = node.getParent();
			
		}
		itemIndex = parent.insertData(itemB);
		int n = parent.dataNum();
		for(int j= n-1;j>itemIndex;j--){  //插入数据后，数据后面的子节点要后移
			Node item=parent.disConnectNode(j);
			parent.connectNode(j+1, item);
		}
		parent.connectNode(itemIndex+1, newRight);
		newRight.insertData(itemC);
		newRight.connectNode(0, child2);
		newRight.connectNode(1, child3);
	}
	public int find(long key){
		Node curNode = root;
		int childNumber;
		while(true){
			if((childNumber = curNode.findNum(key))!=-1){
				return childNumber;
			}else if(curNode.isLeaf()){
				return -1;
			}else{
				curNode = getNextChild(curNode,key);
			}
		}
	}
	public void displayTree(){
		recDisplay(root,0,0);
	}
	public void recDisplay(Node node,int level,int child){
		System.out.print("level"+level+" child"+child+" ");
		node.display();
		int numItems = node.dataNum();
		for(int j=0;j <= numItems;j++){
			Node nextNode = node.getChild(j);
			if(nextNode!=null){
				recDisplay(nextNode,level+1,j);//递归到下层
			}else{
				return;
			}
		}
	}
}
