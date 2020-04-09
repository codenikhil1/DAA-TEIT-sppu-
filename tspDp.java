import java.util.Scanner;
import java.util.Stack;
public class tsp_dp{

	public static void tsp(int[][] graph,int city){
		Stack<Integer> stack = new Stack<>();
		int start = 0;
		stack.push(start);
		int visited[] = new int[city];
		visited[start] = 1;
		int min = Integer.MAX_VALUE;
		int node = 0;
		boolean flag = false;
		System.out.println(start);
		while(!stack.isEmpty()){
			int element = stack.pop();
			flag=false;
			min = Integer.MAX_VALUE;;
			for(int i=0;i<city;i++){
				if(visited[i] == 0 && graph[element][i] >= 1 ){
					if(graph[element][i] < min){
						min = graph[element][i];
						node = i;
						flag = true;
					}

				}
			}
			if(flag){
				visited[node] = 1;
				stack.push(node);
				System.out.println(node + "\t");
				//continue;

			}

			//stack.pop();
		}
	}

	public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	System.out.println("Enter no of cities");
	int city = s.nextInt();
	int graph[][] = new int[city][city];
	for(int i=0;i<city;i++){
		System.out.println("Enter for row"+i);
		for(int j=0;j<city;j++){
			graph[i][j] = s.nextInt();
		}	
	}
	System.out.println("Enter matrix is :");
	for(int i=0;i<city;i++){
		System.out.println();
		for(int j=0;j<city;j++){
			System.out.print(graph[i][j] + " ");
		}	
	}
	System.out.println();
	tsp(graph,city);	

	}


}
