package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {
    @Test
    public void BRTest(){
        RedBlackTree y = new RedBlackTree('R',null,null,4,null);
        RedBlackTree z = new RedBlackTree('R',null,null,8,null);
        RedBlackTree x = new RedBlackTree('B',y,z,6,null);
        x.setParent(x); y.setParent(x); z.setParent(x);

        /*** test leftRotation and rightRotation ***/
        RedBlackTree x1 = x.leftRotate();
        x1 = x1.rightRotate();
        assertEquals(x,x1);
        assertEquals(x1,x1.getParent());

        /*** test insert ***/
        // RL case
        /* trees may become unblanced but it's ok we just check valid insertion */
        x1.getLeftSon().setColor('B');
        x1 = x1.insert(7);
        x1.preOrderTraversal();
        System.out.println();

        //RR case
        x1.getLeftSon().setColor('B');
        x1 = x1.insert(9);
        x1.preOrderTraversal();
        System.out.println();

        // LR case
        x1.setValue(9);
        x1.getRightSon().setValue(10);
        x1.getRightSon().setColor('B');
        x1 = x1.insert(8);
        x1.preOrderTraversal();
        System.out.println();

        // LR case
        x1.getLeftSon().setLeftSon(null);
        x1.getRightSon().setColor('B');
        x1 = x1.insert(6);
        x1.preOrderTraversal();
        System.out.println();
    }

}