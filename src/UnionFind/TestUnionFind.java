package UnionFind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TestUnionFind {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("number of points (from 0 to N-1)?");
        QuickFind qf = new QuickFind(Integer.parseInt(bf.readLine()));
        System.out.println("enter your instructions (enter nothing to stop the program)");
        while(true){
            String inst = bf.readLine();
            if (inst.isEmpty()){break;}
            String[] insts = inst.split(" ");
            if (insts.length != 2){
                System.out.println("bad usage, please re-enter a valid query");
            }
            else {
                int p = Integer.parseInt(insts[0]);
                int q = Integer.parseInt(insts[1]);
                int sizeIndex = qf.getIndex().length;
                if (p >= 0 && p < sizeIndex && q >= 0 && q < sizeIndex) {
                    if (!(qf.find(p) == qf.find(q))) {
                        qf.union(p, q);
                        System.out.println("Components remaining : " + qf.count());
                    }
                } else {
                    System.out.println("bad usage, please re-enter a valid query");
                }
            }
        }
    }
}
