
/**
 * 
 * Add to graph
 * BFS
 * DFS
 * Shortest path algo
 * Adjacency matrix
 * 
 **/
import java.util.*;
public class Graph {

	Map<Vertex, List<Vertex>> adjecencyList = new HashMap<>();

	public Graph (){}

	public static void main(String... args){

		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(4);
		Vertex v3 = new Vertex(7);
		Vertex v4 = new Vertex(8);
		Vertex v5 = new Vertex(3);


		Graph graph = new Graph();
		graph.adjecencyList.put(v1, Arrays.asList(v2));
		graph.adjecencyList.put(v2, Arrays.asList(v3, v4));
		graph.adjecencyList.put(v3, Arrays.asList(v5));
		graph.adjecencyList.put(v4, Arrays.asList(v3));
		graph.adjecencyList.put(v5, Arrays.asList(v1));

		dfs(graph);

	}

	public static void bfs(Graph graph){
		
		Set<Vertex> visited = new HashSet<>();
		Queue<Vertex> qu = new LinkedList<>();

		List<Vertex> keys = new ArrayList<Vertex>(graph.adjecencyList.keySet());

		// keys.stream().map( v -> v.value ).forEach(System.out::println);

		qu.add(keys.get(0));

		while(!qu.isEmpty()){
			Vertex v = qu.remove();

			if (!visited.contains(v)){
				System.out.println(v.value);
				visited.add(v);
				graph.adjecencyList.get(v).stream().forEach(edge -> qu.add(edge));
			}
		}

	}


	public static void dfs(Graph graph){
		
		Set<Vertex> visited = new HashSet<>();
		Stack<Vertex> stack = new Stack<Vertex>();

		List<Vertex> keys = new ArrayList<Vertex>(graph.adjecencyList.keySet());

		// keys.stream().map( v -> v.value ).forEach(System.out::println);

		stack.push(keys.get(0));

		while(!stack.isEmpty()){
			Vertex v = stack.pop();

			if (!visited.contains(v)){
				System.out.println(v.value);
				visited.add(v);
				graph.adjecencyList.get(v).stream().forEach(edge -> stack.push(edge));
			}
		}

	}


}

class Vertex {

	int value;

	public Vertex(int value){
		this.value = value;
	}

	@Override
	public boolean equals(Object o){
		return this.value == ((Vertex)o).value; 
	}

}