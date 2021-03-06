import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    
    public boolean isValidMove(int A, int B, int x, int y, boolean [][] visited){
        if (x < 1 || y <1)
            return false;
        if (x > A || y > B)
            return false;
        if (visited[x][y])
            return false;
        return true;
    }
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean [][] visited = new boolean[A+1][B+1];
        int [][] moves = {
                            {1,2},
                            {1, -2},
                            {-1, 2},
                            {-1, -2},
                            {2,1},
                            {2, -1},
                            {-2,1},
                            {-2, -1}
            
        };
        
        
        Deque<Node> q = new ArrayDeque<>();
        Node start = new Node(C, D, 0);
        q.addLast(start);
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node u = q.pollFirst();
            System.out.println(String.format("x=%s, y=%s, depth=%s", u.x, u.y, u.depth));
            if ((u.x == E) && (u.y == F)){
                ans = u.depth;
            }
            visited[u.x][u.y] = true;
            
            for(int [] arr: moves){
                
                int new_x = u.x + arr[0];
                int new_y = u.y + arr[1];
                int new_depth = u.depth + 1;
                
                System.out.println(String.format("new_x=%s, new_y=%s, new_depth=%s", new_x, new_y, new_depth));
                if (isValidMove(A, B, new_x, new_y, visited)){
                    Node v = new Node(new_x, new_y, new_depth);
                    q.addLast(v);
                }
            }
        }
        if (ans < Integer.MAX_VALUE)
            return ans;
        else
            return -1;
    }
    
    public static class Node{
        public int x;
        public int y;
        public int depth;
        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
	public static void main(String args[]){
		Solution s = new Solution();
		int ans = s.knight(4,7, 2, 6, 2, 4);
		System.out.println("ans="+ans);


}
}

