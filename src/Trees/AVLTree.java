package Trees;

public class AVLTree{
    private AVLNode root;

    public AVLTree(AVLNode root){
        this.root = root;
    }

    public AVLNode getRoot() {
        return root;
    }

    public void insert(int x){
        if (root == null){
            root = new AVLNode(x,1,null,null);
        }
        else {
            root.insert(x);
        }
    }

}
