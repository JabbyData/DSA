package Trees;

public class BTree {
    private int degree; /* degree of the BTree */
    private final int height; /* height of the tree, cf check leaves at the smae level */
    private int[] keys;
    private BTree[] children;

    public BTree(int height, int degree, int[] keys, BTree[] children) {
        this.height = height;
        this.degree = degree;
        this.keys = keys;
        this.children = children;
    }

    public boolean sortedIncr(int[] tab){
        int curr = tab[0];
        for (int i = 1; i < tab.length; i++){
            if (curr > tab[i]){return false;}
            curr = tab[i];
        }
        return true;
    }
    public boolean isBTree(int level, int height) {
        int kl = keys.length;
        int cl = children.length;
        /* checking root has at least key */
        if (kl < 1) {
            return false;
        }
        /* check leaves level */
        else if (cl == 0){return level == height;}
        /* check nb children = nb keys + 1 */
        else if (cl != kl + 1) {
            return false;
        }
        /* check nb max keys */
        else if (kl > 2 * degree - 1) {
            return false;
        }
        else if (!sortedIncr(keys)) {
            return false;
        }
        else {
            for (BTree btree : children) {
                if (!btree.isBTree(level + 1,height)) {
                    return false;
                }
            }
            return true;
        }
    }

}
