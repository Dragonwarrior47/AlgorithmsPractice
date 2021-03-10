import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ComparableTest{
	public static class Edge implements Comparable<Edge>{
		private int u, v, w;
		public Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Edge other){
			return this.w - other.w;
		}
		
		public String toString(){
			return String.format("%s-----%s----->%s", u,w,v);
		}
		
	}
	public static void main(String[] args){
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(1,2,3));
		edges.add(new Edge(1,3,10));
		edges.add(new Edge(2,3, 5));
		edges.add( new Edge(3,4,1));
		edges.add(new Edge(4,5,13));
		Collections.sort(edges);
		System.out.println(edges);
		
		

	}
}
