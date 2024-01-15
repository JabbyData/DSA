package UnionFind;

public abstract class UnionFind {
    private int[] index; // ith elt belong to the component nb index[i]
    private int count; // nb of components

    /* constructor */
    public UnionFind(int N) {
        count = N;
        index = new int[N];
        for (int i = 0; i < N; i++) {
            index[i] = i;
        }
    }

    /* getters */
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return index[p] == index[q];
    }

    public int[] getIndex() {
        return index;
    }
    /* setters */

    public void setCount(int count) {
        this.count = count;
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}
