package UnionFind;

public class QuickUnion extends UnionFind{
    public QuickUnion(int N){
        super(N);
    }

    /**
     * Find the component number (root index) of the elt at index p
     * @param p
     * @return index of the component's root
     * @complexity Time complexity : O(1)
     *             Memory complexity : O(N)
     */
    @Override
    public int find(int p) {
        int[] index = super.getIndex();
        while (index[p] != p) {
            p = index[p];
        }
        return p;
    }


    @Override
    public void union(int p, int q){
        super.getIndex()[p] = q;
        super.setCount(super.count()-1);
    }
}
