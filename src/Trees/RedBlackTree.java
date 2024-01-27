package Trees;

public class RedBlackTree {
    private char color; /* either 'B' or 'R'*/
    private RedBlackTree leftSon;
    private RedBlackTree rightSon;
    private int value;

    private RedBlackTree parent; /* root has itself as root */

    /* constructor */
    public RedBlackTree(char color,RedBlackTree leftSon, RedBlackTree rightSon, int value, RedBlackTree parent){
        this.color = color;
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        this.value  = value;
        this.parent = parent;
    }

    /* setters */
    public void setColor(char color) {
        this.color = color;
    }

    public void setParent(RedBlackTree newParent){
        parent = newParent;
    }

    public void setLeftSon(RedBlackTree newLeftSon){
        leftSon = newLeftSon;
    }

    public void setRightSon(RedBlackTree rightSon) {
        this.rightSon = rightSon;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /* getters */

    public RedBlackTree getParent() {
        return parent;
    }

    public RedBlackTree getRightSon() {
        return rightSon;
    }

    public RedBlackTree getLeftSon() {
        return leftSon;
    }

    /**
     * Operates a right rotation on the tree
     * @return the right rotated tree
     * @TimeComplexity O(1)
     */
    public RedBlackTree rightRotate(){
        RedBlackTree y = leftSon;
        RedBlackTree T2 = y.rightSon;
        setLeftSon(T2);
        if(T2 != null){
            T2.setParent(this);
        }
        if (parent == this){
            /* in this case y becomes the root */
            y.setParent(y);
        }
        else{
            y.setParent(parent);
        }
        setParent(y);
        y.setRightSon(this);
        return y;
    }

    /**
     * Operates a left rotation on the tree
     * @return the left rotated tree
     * @TimeComplexity O(1)
     */
    public RedBlackTree leftRotate(){
        RedBlackTree z = rightSon;
        RedBlackTree T3 = z.leftSon;
        setRightSon(T3);
        if(T3 != null) {
            T3.setParent(this);
        }
        if (parent == this){
            /* in this case z becomes the root */
            z.setParent(z);
        }
        else{
            z.setParent(parent);
        }
        setParent(z);
        z.setLeftSon(this);
        return z;
    }

    /**
     * Recolor the tree given its structure
     * @param parent
     * @param uncle
     * @param grandFather
     * @TimeComplexity : 0(log(n))
     */
    public void RecolorUncleRedCase(RedBlackTree parent, RedBlackTree uncle,RedBlackTree grandFather){
        /* parent and uncle to black */
        uncle.setColor('B');
        parent.setColor('B');
        /* grandFather to red if not root */
        if (grandFather.parent != grandFather){
            grandFather.setColor('R');
            /* iterate process */
            RedBlackTree newParent = grandFather.parent;
            if (newParent.parent != newParent){
                /* new grandfather exists */
                RedBlackTree newUncle;
                RedBlackTree newGrandFather = newParent.parent;
                if (newGrandFather.leftSon == newParent){
                    newUncle = newGrandFather.rightSon;
                }
                else{
                    newUncle = newGrandFather.leftSon;
                }
                RecolorUncleRedCase(newParent,newUncle,newGrandFather);
            }
        }
    }

    /**
     * Insert x in the tree from the current node
     * @param x
     * @return the whole tree (root)
     * @TimeComplexity : O(log(n))
     */
    public RedBlackTree insert(int x) {
        /* first binary search tree insertion with red color */
        if (x <= value && leftSon != null) {
            leftSon.insert(x);
        }
        else if (x > value && rightSon != null){
            rightSon.insert(x);
            }
        else{
            /* insertion as a node with red color */
            if (x <= value && leftSon == null){
                leftSon = new RedBlackTree('R',null,null,x,this);
            }
            else if (x > value && rightSon == null){
                rightSon = new RedBlackTree('R',null,null,x,this);
            }
            /* check color of parent node once the node is inserted */
            /* we are exploring from the parent level so far */
            if (color == 'R'){
                /* check the color of the uncle */
                RedBlackTree uncle;
                RedBlackTree grandFather = parent;
                if (this == grandFather.leftSon){
                    uncle = grandFather.rightSon;
                }
                else{ uncle = grandFather.leftSon;}
                if (uncle.color == 'R'){
                    /* parent and uncle to black, then gf to red if not root + iteration */
                    RecolorUncleRedCase(this,uncle,grandFather);
                }
                else{
                    /* uncle is black, 4 cases to treat, remember parent vision level */
                    if (grandFather.leftSon.leftSon != null && grandFather.leftSon.leftSon.value == x){
                        // LL case
                        grandFather.rightRotate(); /* no need to get the return this time */
                        setColor('B');
                        rightSon.setColor('R');
                    }
                    else if (grandFather.leftSon.rightSon != null && grandFather.leftSon.rightSon.value == x){
                        // LR case
                        parent.setLeftSon(leftRotate());
                        parent.parent = parent.parent.rightRotate();
                        parent.setColor('B');
                        parent.rightSon.setColor('R');
                    }
                    else if (grandFather.rightSon.rightSon != null && grandFather.rightSon.rightSon.value == x){
                        // RR case
                        grandFather.leftRotate(); /* no need to get the return this time */
                        setColor('B');
                        leftSon.setColor('R');
                    }
                    else if (grandFather.rightSon.leftSon != null && grandFather.rightSon.leftSon.value == x){
                        // RL case
                        parent.setRightSon(rightRotate());
                        parent.parent = parent.parent.leftRotate();
                        parent.setColor('B');
                        parent.leftSon.setColor('R');
                    }
                }
            }
        }
        /* return root of the tree */
        RedBlackTree root = this;
        while (root.parent != root){
            root = root.parent;
        }
        return root;
    }

    /**
     * Everything is in the name
     * @TimeComplexity : O(n)
     */
    public void preOrderTraversal(){
        System.out.print("(value : " + value + ",color : " + color + ") -> ");
        if (leftSon != null){
            leftSon.preOrderTraversal();
        }
        if (rightSon != null){
            rightSon.preOrderTraversal();
        }
    }
}
