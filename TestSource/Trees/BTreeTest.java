package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {
    /**** Test of valid Btree ****/
    @Test
    void BtreeTest() {
        BTree l3_1 = new BTree(1, 2, new int[]{10, 20}, new BTree[]{});
        BTree l3_2 = new BTree(1, 2, new int[]{40, 50}, new BTree[]{});
        BTree l3_3 = new BTree(1, 2, new int[]{70, 80, 90}, new BTree[]{});
        BTree l3_4 = new BTree(1, 2, new int[]{110, 120}, new BTree[]{});
        BTree l3_5 = new BTree(1, 2, new int[]{140, 160}, new BTree[]{});
        BTree l3_6 = new BTree(1, 2, new int[]{190, 240, 260}, new BTree[]{});
        BTree l2_1 = new BTree(2, 2, new int[]{35, 65}, new BTree[]{l3_1, l3_2, l3_3});
        BTree l2_2 = new BTree(2, 2, new int[]{10, 20}, new BTree[]{l3_4, l3_5, l3_6});
        BTree l1 = new BTree(3, 2, new int[]{100}, new BTree[]{l2_1, l2_2});
        assertEquals(true, l1.isBTree(1,3));
    }

    /**** Test Invalid Btree ****/
    @Test
    void NotBtreeTest() {
        /**** No elt in root ****/
        BTree l3_1 = new BTree(1, 2, new int[]{10, 20}, new BTree[]{});
        BTree l3_2 = new BTree(1, 2, new int[]{40, 50}, new BTree[]{});
        BTree l3_3 = new BTree(1, 2, new int[]{70, 80, 90}, new BTree[]{});
        BTree l3_4 = new BTree(1, 2, new int[]{110, 120}, new BTree[]{});
        BTree l3_5 = new BTree(1, 2, new int[]{140, 160}, new BTree[]{});
        BTree l3_6 = new BTree(1, 2, new int[]{190, 240, 260}, new BTree[]{});
        BTree l2_1 = new BTree(2, 2, new int[]{35, 65}, new BTree[]{l3_1, l3_2, l3_3});
        BTree l2_2 = new BTree(2, 2, new int[]{10, 20}, new BTree[]{l3_4, l3_5, l3_6});
        BTree l1 = new BTree(3, 2, new int[]{}, new BTree[]{l2_1, l2_2});
        assertEquals(false, l1.isBTree(1,3));

        /**** Too much elt in node ****/
        BTree l2_2_new = new BTree(2, 2, new int[]{10,20,21,22}, new BTree[]{l3_4, l3_5, l3_6});
        BTree l1_new = new BTree(3, 2, new int[]{100}, new BTree[]{l2_1, l2_2_new});
        assertEquals(false,l1_new.isBTree(1,3));

        /**** Keys not sorted in increase order ****/
        l2_2_new = new BTree(2, 2, new int[]{21,10,22}, new BTree[]{l3_4, l3_5, l3_6});
        assertEquals(false,l1_new.isBTree(1,3));

        /**** Leaves not at the same level ****/
        l1 = new BTree(4, 2, new int[]{100}, new BTree[]{l2_1, l2_2});
        BTree l4_1 = new BTree(1, 2, new int[]{5}, new BTree[]{});
        l3_1 = new BTree(1, 2, new int[]{10, 20}, new BTree[]{l4_1});
        assertEquals(false,l1_new.isBTree(1,4));
    }
}