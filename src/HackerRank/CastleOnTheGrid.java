package HackerRank;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

/*** TODO revoir l'exo ***/
class Node{
    private int[] coordinates;
    private int nb_moves;
    public Node(int[] coordinates, int nb_moves){
        this.coordinates = coordinates;
        this.nb_moves = nb_moves;
    }
    public int getNb_moves() {
        return nb_moves;
    }
    public int[] getCoordinates() {
        return coordinates;
    }
}

public class CastleOnTheGrid {
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY){
            int dimX = grid.size();
            int dimY = grid.get(0).length();
            ArrayDeque<Node> moves = new ArrayDeque<>();
            Hashtable<int[],Boolean> visited = new Hashtable<>();
            int[] start = new int[]{startX,startY};
            moves.add(new Node(start,0));
            visited.put(start,true);
            while(!moves.isEmpty()){
                Node currentMove = moves.pop();
                int[] coord = currentMove.getCoordinates();
                // if not already visited
                int x = coord[0];
                int y = coord[1];
                visited.put(coord,true);
                if (x == goalX && y==goalY){return currentMove.getNb_moves();}
                // Else trying every move possible
                int i = x+1;
                while (i < dimX && grid.get(i).charAt(y) == '.' && (visited.get(new int[]{i,y})==null || !visited.get(new int[]{i,y}))) {
                    // Rows
                    moves.add(new Node(new int[]{i,y}, currentMove.getNb_moves()+1));
                    i++;
                }
                i = x-1;
                while (i >= 0 && grid.get(i).charAt(y) == '.' && (visited.get(new int[]{i,y})==null || !visited.get(new int[]{i,y}))){
                    // Rows
                    moves.add(new Node(new int[]{i, y}, currentMove.getNb_moves() + 1));
                    i--;
                }
                int j = y+1;
                while (j < dimY && grid.get(x).charAt(j) == '.' && (visited.get(new int[]{x,j})==null || !visited.get(new int[]{x,j}))){
                    // Columns
                    moves.add(new Node(new int[]{x,j}, currentMove.getNb_moves()+1));
                    j++;
                }
                j = y-1;
                while (j >= 0 && grid.get(x).charAt(j) == '.' && (visited.get(new int[]{x,j})==null || !visited.get(new int[]{x,j}))){
                    // Columns
                    moves.add(new Node(new int[]{x, j}, currentMove.getNb_moves() + 1));
                    j--;
                    }
                }
            return -1;
    }

    public static void main(String[] args){
        String s1 = ".X.";
        String s2 = ".X.";
        String s3 = "...";
        ArrayList<String> grid = new ArrayList<>();
        grid.add(s1);
        grid.add(s2);
        grid.add(s3);
        System.out.println(minimumMoves(grid,0,0,1,2));
    }
}