import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;
	private int size;
	// Each Node Have an string hash key
	// this list associate other variables with the key
	private LinkedList<AddressNode> addressKeys;
	
	public BinarySearchTree() {
		addressKeys = new LinkedList<AddressNode>();
		root = null;
		size = 0;
	}
	
	public Node getMin() {
		return getMin(root);
	}
	
	private Node getMin(Node r) {
		if (r == null)
            return null;
        else if (r.getLeftChild() == null)
            return r;
        else
            return getMin(r.getLeftChild());
	}
	
	public Node getMax() {
		return getMax(root);
	}
	
	private Node getMax(Node r) {
		if (r == null)
            return null;
        else if (r.getRightChild() == null)
            return r;
        else
            return getMin(r.getRightChild());
	}
	
	// Recursive function to get height of the tree
	private int height(Node r) { 
        if (r == null) return 0; 
        else{ 
            int lheight = height(r.getLeftChild()); 
            int rheight = height(r.getRightChild()); 
              
            if (lheight > rheight) return(lheight+1); 
            else return(rheight+1);  
        } 
    }
	
	// Prints all tree nodes with Level-order-traversal or BFS
	public void printLevelOrder() {
		System.out.println("Print Level Order");
		Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
            Node node = queue.poll(); 
            System.out.println(node.toString());
  
            if (node.getLeftChild() != null) { 
                queue.add(node.getLeftChild()); 
            } 
  
            if (node.getRightChild() != null) { 
                queue.add(node.getRightChild()); 
            } 
        }    
    } 
    
	// Public function to get In-Order-traversal
    public void printInorder() {
    	System.out.println("Print In Order");
    	printInorder(root);
    }
    
    // Recursive function to go throw all nodes by IOT
    private void printInorder(Node node) { 
        if (node == null) 
            return; 
        
        printInorder(node.getLeftChild()); 
  
        System.out.println(node.toString());
  
        printInorder(node.getRightChild()); 
    } 

    // Creates a new node and calls insert
    public void insert(String name,long studentId,int units){
		Node newNode = new Node(name,studentId,units);
		addressKeys.add(new AddressNode(newNode.getKey(), newNode.getStudentId(), newNode.getUnits()));
		root = insert(root, newNode);
		size++;
	}
    
    // Recursive function to insert new nodes into the tree
	private Node insert(Node r, Node value) {
		if (r == null)
			r = value;
		else if (value.getKey() < r.getKey())
			r.setLeftChild(insert(r.getLeftChild(), value));
		else if (value.getKey() >= r.getKey())
			r.setRightChild(insert(r.getRightChild(), value));
		return r;
	}
	
	// Checks all nodes and returns true if find an instance of a name
	public boolean contains(String name) {
		long key = name.hashCode();
		return contains(root, key);
	}
	
	// Checks all nodes and returns true if find an instance of an student-id
	public boolean contains(long studentId) {
		long key;
		for(int i=0;i<addressKeys.size();i++) {
			if(addressKeys.get(i).studentId == studentId) {
				key = addressKeys.get(i).key;
				return contains(root, key);
			}
		}
		return false;
	}
	
	// Checks all nodes and returns true if find an instance of number of units
	public boolean contains(int units) {
		long key;
		for(int i=0;i<addressKeys.size();i++) {
			if(addressKeys.get(i).units == units) {
				key = addressKeys.get(i).key;
				return contains(root, key);
			}
		}
		return false;
	}

	// Recursive function to find the node with provided key
	private boolean contains(Node root, long key) {
		if (root == null)
			return false;
		if (root.getKey() == key)
			return true;
		else if (root.getKey() > key)
			return contains(root.getLeftChild(), key);
		else
			return contains(root.getRightChild(), key);
	}
	
	// Remove an object using student-id
	public void remove(long studentId) {
		long key = -1;
		for(int i=0;i<addressKeys.size();i++) {
			if(addressKeys.get(i).studentId == studentId) {
				key = addressKeys.get(i).key;
				root = remove(root, key);
				addressKeys.remove(i);
			}
		}
		if(key == -1)
			size--;
	}
	
	// Remove an object using number of units
	public void remove(int units) {
		long key = -1;
		for(int i=0;i<addressKeys.size();i++) {
			if(addressKeys.get(i).units == units) {
				key = addressKeys.get(i).key;
				root = remove(root, key);
				addressKeys.remove(i);
			}
		}
		if(key != -1)
			size--;
	}

	// Remove an object using name
	public void remove(String name) {
		long key = name.hashCode();
		root = remove(root, key);
		size--;
	}

	// Recursive function to remove node using provided key
	private Node remove(Node root, long key) {
		if(root == null)
	        return null;
	    if(key < root.getKey()){
	        root.setLeftChild(remove(root.getLeftChild(), key));
	    }
	    else if (key > root.getKey()){
	        root.setRightChild(remove(root.getRightChild(), key));
	    }
	    else{
	        if(root.getLeftChild() == null && root.getRightChild() == null){
	            root = null;
	        }
	        else if(root.getLeftChild() == null){
	            root = root.getRightChild();
	        }
	        else if(root.getRightChild() == null){
	            root = root.getLeftChild();
	        }
	        else{
	            Node successor = getMin(root.getRightChild());
	            root.setKey(successor.getKey());
	            root.setName(successor.getName());
	            root.setStudentId(successor.getStudentId());
	            root.setUnits(successor.getUnits());
	            root.setRightChild(remove(root.getRightChild(), successor.getKey()));
	        }
	    }
	    return root; 
	}
	
	public int getHight() {return height(root);}
	
	public Node getRoot() {return root;}
	
	public int getSize() {return size;}
}
