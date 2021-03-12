import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Dijkastra {
	public static class Edge implements Comparable<Edge>{
		public int loc, weight, from;
		
		public Edge(int loc, int w, int f){
			this.loc = loc;
			this.weight = w;
			this.from = f;
		}
		
		public int compareTo(Edge o){
			return weight - o.weight;
		}
		public String toString(){
			return String.format("loc=%s, weight=%s, from=%s", loc, weight, from);
		}



	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<List<Edge>> adj = new ArrayList<>();
		for (int i =0; i< n; i++){
			List<Edge> tmp = new ArrayList<>();
			adj.add(tmp);
		}
		for(int i =0; i<m; i++){
			int s = in.nextInt()-1;
			int e = in.nextInt()-1;
			int w = in.nextInt();
			adj.get(s).add(new Edge(e, w, s));
			adj.get(e).add(new Edge(s,w, e));
		}
		
		boolean visited[] = new boolean[n];
		int [] from = new int[n];
		Arrays.fill(visited, false);
		Arrays.fill(from, -1);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0, -1));
		while (!pq.isEmpty()){
			Edge now = pq.poll();
			if(visited[now.loc])
				continue;
			visited[now.loc] = true;
			from[now.loc] = now.from;
			for(Edge to: adj.get(now.loc)){
				pq.add(new Edge(to.loc, to.weight + now.weight, now.loc));
			}
		}
		if(!visited[n-1])
			System.out.println(-1);
		else
		{
			ArrayList<Integer> path = new ArrayList<Integer>();
			int now = n-1;
			while(now != -1)
			{
				path.add(now+1);
				now = from[now];
			}
			Collections.reverse(path);
			System.out.print(path.get(0));
			for(int i = 1; i<path.size(); i++) {
				System.out.print(" "+path.get(i));
			}
			System.out.println();
		}
	
	}

}
