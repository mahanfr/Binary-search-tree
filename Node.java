
public class Node {

	private long key;
	private String name;
	private long studentId;
	private int units;
	private Node leftChild;
	private Node rightChild;
	
	public Node() {
		name = "";
		studentId = 0;
		units = 0;
		leftChild = null;
		rightChild = null;
	}
	
	public Node(String name,long studentId,int units) {
		this.name = name;
		this.studentId = studentId;
		this.units = units;
		leftChild = null;
		rightChild = null;
		key = name.hashCode();
	}
	
	@Override
	public String toString() {
		return "Name: "+ name + " Id: " +studentId+" Units: "+units;
	}
	
	public void setKey(long key) {this.key = key;}
	
	public long getKey() {return key;}
	
	public String getName() {return name;}
	
	public long getStudentId() {return studentId;}

	public void setName(String name) {this.name = name;}
	
	public void setStudentId(long studentId) {this.studentId = studentId;}
	
	public int getUnits() {return units;}
	
	public void setUnits(int data) {this.units = data;}
	
	public Node getLeftChild() {return leftChild;}
	
	public Node getRightChild() {return rightChild;}
	
	public void setLeftChild(Node leftChild) {this.leftChild = leftChild;}
	
	public void setRightChild(Node rightChild) {this.rightChild = rightChild;}

}
