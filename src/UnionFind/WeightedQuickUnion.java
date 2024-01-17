package UnionFind;

public class WeightedQuickUnion extends UnionFind{
    private int[] sizes; //sizes of component (roots)
    private int count; // nb of component

    /**
     * initialize a WeightedQuickUnion structure
     * @param N int
     * @timecomplexity O(N)
     * @memorycomplexity O(N)
     */
    public WeightedQuickUnion(int N){
        super(N);
        this.sizes = new int[N];
        for (int i = 0 ; i < N; i++){
            sizes[i] = 1;
        }
    }

    /**
     * Find the component of the elt at index p
     * @param p int
     * @timecomplexity O(log(N))
     * @memorycomplexity O(N)
     * @return component's number (index of the root)
     */
    @Override
    public int find(int p){
        int[] index = super.getIndex();
        while (index[p] != p){
            p = index[p];
        }
        return p;
    }


    /**
     * Create union between components (trees) of p and q, the smaller component become a subtree of the other
     * @param p int
     * @param q int
     * @timecomplexity O(log(N))
     * @memorycomplexity O(N)
     */
    @Override
    public void union(int p, int q) {

        // find roots
        int r1 = find(p);
        int r2 = find(q);
        if (r1 == r2) {
            return;
        }
        // smaller tree => substree of the bigger one
        if (sizes[r1] < sizes[r2]) {
            super.setIndex(r1, r2); sizes[r2] += sizes[r1]; super.setCount(super.count()-1);
        } else {
            super.setIndex(r2, r1); sizes[r1] += sizes[r2]; super.setCount(super.count()-1);
        }
    }

}
