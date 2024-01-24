package Trees;
public class AVLNode {
    private int value;
    private int height;
    private AVLNode leftSon;
    private AVLNode rightSon;

    /* constructor */
    public AVLNode(int value, int height, AVLNode leftSon, AVLNode rightSon){
        this.value = value;
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        this.height = height;
    }

    public AVLNode getLeftSon() {
        return leftSon;
    }

    public AVLNode getRightSon() {
        return rightSon;
    }

    public int height() {
        return height;
    }

    /**
     * Detailed if an AVL Node is balanced
     * @return the unbalanced ratio of the node (negative if leftSon is deeper than rightSon, 0 if balanced and positive if rightSon is deeper than leftSon)
     * @TimeComplexity O(log(N)) where N is the number of nodes in the subtree having this node as root
     */
    public int UnbalancedRatio(){
        if (leftSon == null && rightSon == null){
            return 0;
        }
        else{
            int hl = 0; int hr = 0;
            if (leftSon != null){
                hl = leftSon.height();
            }
            if (rightSon != null){
                hr = rightSon.height();
            }
            return hr-hl;
        }
    }

    public AVLNode leftRotate(){
        AVLNode x = rightSon;
        AVLNode T2 = x.leftSon;
        rightSon = T2;
        x.leftSon = this;
        return x;
    }

    public AVLNode rightRotate(){
        AVLNode T2 = leftSon.rightSon;
        AVLNode y = leftSon;
        leftSon = T2;
        y.rightSon = this;
        return y;
    }

    public AVLNode insert(int x){
        /* classic insertion in binary tree */
        if (x <= value) {
            if (leftSon == null) {
                leftSon = new AVLNode(x, 1, null, null);
            } else {
                leftSon = leftSon.insert(x);
            }
        }
        else {
            /* x > value */
            if (rightSon == null) {
                rightSon = new AVLNode(x, 1, null, null);
            } else {
                rightSon = rightSon.insert(x);
            }
        }

        /* update height */
        int hl = 0; int hr = 0;
        if (leftSon != null){
            hl = leftSon.height();
        }
        if (rightSon != null){
            hr = rightSon.height();
        }
        if (hl > hr){
            height = 1 + hl;
        }
        else{
            height = 1 + hr;
        }

        /* get the balanced ratio */
        int ublRatio = UnbalancedRatio();

        /* if unbalanced, need to re balance the tree */
        if (ublRatio < -1 && x <= leftSon.value){
            // left left case
            return this.rightRotate();

        }

        if (ublRatio < -1 && x > leftSon.value){
            // left right case
            leftSon = leftSon.leftRotate();
            return this.rightRotate();
        }

        if (ublRatio > 1 && x > rightSon.value){
            // right right case
            return this.leftRotate();
        }

        if (ublRatio > 1 && x <= rightSon.value){
            // right left case
            rightSon = rightSon.rightRotate();
            return this.leftRotate();
        }
        return this;
        }


        public void preOrderTraversal(){
            if (this != null) {
                System.out.print(value + "->");
                if (leftSon != null){leftSon.preOrderTraversal();}
                if (rightSon != null){rightSon.preOrderTraversal();}
            }
        }
    }
