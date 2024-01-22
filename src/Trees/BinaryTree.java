package Trees;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(BinaryNode root){
        this.root = root;
    }

    /**
     * Insert elt x in the tree
     * @param x
     * @TimeComplexity O(log2(n)), where n is the number of nodes in the tree
     * @MemoryComplexity O(1)
     */
    public void insert(int x){
        if (root == null){
            root = new BinaryNode(x,null,null);
        }
        else{root.insert(x);}
    }

    /**
     * Returns the presence of x in the tree
     * @param x
     * @return boolean stating wether x is or not in the tree
     * @TimeComplexity O(n), worst case is when the elt is not in the tree
     * @MemoryComplexity O(1)
     */
    public boolean search(int x){
        return root.search(x);
    }

    /**
     * Print all the elts of the tree in a prefixe order
     * @TimeComplexity O(n)
     * @MemoryComplexity O(1)
     */
    public void preOrderTraversal(){
        if (root == null) {
            System.out.print("null");
        }
        else{
            root.preOrderTraversal();
        }
    }

    /**
     * Print all the elts of the tree in a infixe order
     * @TimeComplexity O(n)
     * @MemoryComplexity O(1)
     */
    public void inOrderTraversal(){
        if (root == null) {
            System.out.print("null");
        }
        else{
            root.inOrderTraversal();
        }
    }

    /**
     * Print all the elts of the tree in a postfixe order
     * @TimeComplexity O(n)
     * @MemoryComplexity O(1)
     */
    public void postOrderTraversal(){
        if (root == null) {
            System.out.print("null");
        }
        else{
            root.postOrderTraversal();
        }
    }
}
