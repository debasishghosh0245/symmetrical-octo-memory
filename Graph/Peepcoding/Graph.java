import java.util.*;
import java.io.*;
public class Graph{

	public static void main(String[] args) throws Exception{
	
		int vertices=7;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		int edges=8;
		for(int i=0;i<edges;i++){
			String edge=br.readLine();
			String[] parts=edge.split(" ");
			int v1=Integer.parseInt(parts[0]);
			int v2=Integer.parseInt(parts[1]);
			int weight=Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1,v2,weight));
			graph[v2].add(new Edge(v2,v1,weight));
		}
		
		for(int i=0;i<vertices;i++){
			System.out.println(graph[i]);
		}
		int src = 0;
		int dest = 6;
	}
	
	public static class Edge{
		int source;
		int neighbour;
		int weight;
		
		public Edge(){}

		public Edge(int source,int neighbour,int weight){
			this.source=source;
			this.neighbour=neighbour;
			this.weight=weight;
		}
	
	}
	
}