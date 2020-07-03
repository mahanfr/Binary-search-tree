public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert("mahan", 961120020, 70);
		bst.insert("ali", 981320015, 30);
		bst.insert("hassan", 971120021, 62);
		bst.insert("akbar", 971120022, 41);
		bst.insert("hossein", 961120023, 90);
		bst.insert("mehdi", 951120024, 130);
		bst.insert("mehdi2", 951120024, 130);
		bst.insert("babak", 981120025, 20);
		bst.remove(31);
		bst.remove("mahan");
		System.out.println(bst.getSize());
		System.out.println(bst.contains("mahan"));
		System.out.println(bst.contains((long)981120025));
		bst.printInorder();
		bst.printLevelOrder();
	}

}
