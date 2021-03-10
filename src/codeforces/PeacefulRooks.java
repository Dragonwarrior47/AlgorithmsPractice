package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeacefulRooks {
    public static final Scanner sc = new Scanner(System.in);
    public static int time = 0;


    public static boolean dfsOld(List<Integer>[] graph, int u, boolean[] vis, boolean[] stack){
        vis[u] = stack[u] = true;
        if (graph[u].size() > 0){
            for(int v: graph[u]){
                if (!vis[v] && dfsOld(graph, v, vis, stack))
                    return true;
                else if (stack[v])
                    return true;
            }

        }
        stack[u] = false;
        return false;
    }

    public static void dfs(List<Integer>[] graph, int n){
        String [] color = new String[n];
        int [] parent = new int[n];
        int [] d = new int[n];
        int [] f = new int[n];
        time = 0;
        for (int i = 0; i<n; i++){
            color[i] = "white";
            parent[i] = -1;
        }
        for (int i=0; i<n; i++){
            if (color[i].equals("white")){
                dfsVisit(graph, i, color, parent, d, f);
            }
        }
    }

    public static void dfsVisit(List<Integer>[] graph, int u, String[] color, int [] parent, int [] d, int [] f){
        time = time +1;
        d[u] = time;
        color[u] = "grey";
        if (graph[u].size() > 0) {
            for (int v : graph[u]) {
                if (color[v].equals("white")){
                    parent[v] = u;
                    dfsVisit(graph, v, color, parent, d, f);
                }
                else if (color[v].equals("grey")){
                    System.out.println(""+(u+1)+" -> "+ (v+1) + ", is a back edge");
                }
            }
        }
        color[u] = "black";
        time = time + 1;
        f[u] = time;
    }

    public static void main(String args[]){
        int t = sc.nextInt();
        for (int cases=0;cases<t; cases++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> graph[] = new ArrayList[n];
            boolean stack[] = new boolean[n];
            boolean[] visited = new boolean[n];
            int ans = 0;
            for (int i = 0; i<n; i++){
                graph[i] = new ArrayList<>();
            }
            for (int lines = 0; lines<m; lines++){
                int x = sc.nextInt() -1;
                int y = sc.nextInt() -1;
                if (x != y){
                    ans +=1;
                    graph[x].add(y);
                }
            }
//            for (int i =0; i<n; i++){
//                if (!visited[i] && dfsOld(graph, i, visited, stack)){
//                    ++ans;
//                }
//            }

//            System.out.println(ans);
            dfs(graph, n);

        }
    }
}
