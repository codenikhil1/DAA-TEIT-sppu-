import java.util.Scanner;
public class bellmon{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of edges");
		int E = s.nextInt();
		System.out.println("Enter no of vertices");
		int V = s.nextInt();
		edge graph[] = new edge[E];
		for(int i=0;i<E;i++){
			graph[i] = new edge();
			System.out.println("Enter for "+i+" edge");
			graph[i].src = s.nextInt();
			graph[i].dest= s.nextInt();
			graph[i].weight= s.nextInt();
		}
		bellmon(graph,E,V,0);

	}
	public static void bellmon(edge[] graph,int V,int E,int src){
		//System.out.println(E);
		//src to all vertices distance 0
		int dist[] = new int[V];
		for(int i=0;i<V;i++){
			dist[i] = Integer.MAX_VALUE;		
		}
		dist[src] = 0;

		//relax all edges V-1 times
		for(int i = 0;i<V-1;i++){
			for(int j=0;j<E;j++){
			    int src1 = graph[j].src;
			    int dest1 = graph[j].dest;
			    int weight1 = graph[j].weight;
				if(dist[dest1] > dist[src1]+weight1 && dist[src1] != Integer.MAX_VALUE){
					dist[dest1] = dist[src1]+weight1;
				}
		
			}
			
		}
		
		//check negative weight cycle
		for(int i = 0;i<V-1;i++){
			for(int j=0;j<E;j++){
			    int src1 = graph[j].src;
			    int dest1 = graph[j].dest;
			    int weight1 = graph[j].weight;
				if(dist[dest1] > dist[src1]+weight1 && dist[src1] != Integer.MAX_VALUE){
					System.out.println("Graph Contains Negative weight cycle");
					return;
				}
		
			}
			
		}
		System.out.println("Done");
		printGraph(dist,V);


		
		
	
	}
	public static void printGraph(int[] dist,int V){
		System.out.println("Vertex --> distance");
		for(int i=0;i<V;i++){
			System.out.println(i+"      -->"+ dist[i]);
		}
	}
}

class edge{
	int src;
	int dest;
	int weight;
	
}
