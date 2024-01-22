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
    }
}