package Trees;

public class BinaryNode {
    private int value;
    private BinaryNode leftSon;
    private BinaryNode rightSon;

    public BinaryNode(int value, BinaryNode leftSon, BinaryNode rightSon) {
        this.value = value;
        this.leftSon = leftSon;
        this.rightSon = rightSon;
    }

    /* getters */
    public int getValue() {
        return value;
    }

    public BinaryNode getLeftSon() {
        return leftSon;
    }

    public BinaryNode getRightSon() {
        return rightSon;
    }

    public void insert(int x) {
        if (x <= value) {
            /* goes to the left child */
            if (leftSon == null) {
                leftSon = new BinaryNode(x, null, null);
            } else {
                leftSon.insert(x);
            }
        } else if (rightSon == null) {
            rightSon = new BinaryNode(x, null, null);
        } else {
            rightSon.insert(x);
        }
    }

    public boolean search(int x){
        if (value == x){return true;}
        else if (value < x){return rightSon != null && rightSon.search(x);}
        else{return leftSon != null && leftSon.search(x);}
    }

    public void inOrderTraversal(){
        if (leftSon != null){
            leftSon.inOrderTraversal();
        }
        System.out.print(value + "->");
        if (rightSon != null){
            rightSon.inOrderTraversal();
        }
    }

    public void preOrderTraversal(){
        System.out.print(value + "->");
        if (leftSon != null){
            leftSon.preOrderTraversal();
        }
        if (rightSon != null){
            rightSon.preOrderTraversal();
        }
    }

    public void postOrderTraversal(){
        if (leftSon != null){
            leftSon.postOrderTraversal();
        }
        if (rightSon != null){
            rightSon.postOrderTraversal();
        }
        System.out.print(value + "->");
    }
}

