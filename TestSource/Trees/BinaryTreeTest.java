package Trees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void binaryTreeTest(){
        BinaryTree b = new BinaryTree(null);
        b.insert(1);
        b.insert(-1);
        b.insert(3);
        b.insert(2);
        b.insert(-9);
        assertTrue(b.search(-9));
        assertFalse(b.search(5));
        b.preOrderTraversal();
        System.out.println();
        b.inOrderTraversal();
        System.out.println();
        b.postOrderTraversal();
        assertTrue(b.height() == 3);

        AVLTree avl = new AVLTree(null);
        avl.insert(1);
        avl.insert(-1);
        avl.insert(3);
        avl.insert(-9);
        avl.insert(2);
        avl.insert(-10);
        assertTrue(avl.getRoot().getLeftSon().UnbalancedRatio() == -2);

        /**** Tests left rotation ****/
        AVLNode a = new AVLNode(2,1,null,null);
        a.insert(0);
        a.insert(4);
        a.insert(3);
        a.insert(5);

        AVLNode a2 = a.leftRotate();
        AVLNode a3 = a2.rightRotate();
        System.out.println("finito");
    }
}