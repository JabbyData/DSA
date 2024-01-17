package UnionFind;

public class QuickFind extends UnionFind{

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return super.getIndex()[p];
    }
    /*** Time Complexity : O(1) ***/

    @Override
    public void union(int p, int q) {
        int[] index = super.getIndex();
        if (index[p] != index[q]){
            int pid = index[p];
            // update all elt within p's component
            for (int i = 0; i < index.length ; i++){
                if (index[i] == pid){
                    index[i] = index[q];
                }
            }
            super.setCount(super.count()-1);
        }
    }
    /*** Time Complexity : O(N**2) ***/
}
