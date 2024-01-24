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
        System.out.println();
        assertTrue(b.height() == 3);

        /**** Tests left rotation ****/
        AVLNode a = new AVLNode(2,1,null,null);
        a = a.insert(0);
        a = a.insert(4);
        a = a.insert(3);
        a = a.insert(5);

        AVLNode a2 = a.leftRotate();
        AVLNode a3 = a2.rightRotate();

        /**** Testing insertion ****/
        a3 = a3.insert(6);
        a3.preOrderTraversal();
        System.out.println();
        a3 = a3.insert(-1);
        a3.preOrderTraversal();
        System.out.println();
        a3 = a3.insert(-2);
        a3.preOrderTraversal();
        System.out.println();
    }
}