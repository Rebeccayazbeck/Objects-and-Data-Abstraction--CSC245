package question2;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
import java.util.Arrays;

public class Graph {
		private int[] vertices;
		private Vertex[] edges;
		
		/**
		 * Constructor of class Graph
		 * @param num the number of verteces
		 */
		public Graph(int num) {
			vertices = new int[num];
			edges = new Vertex[num];
		}

		public int[] getVertices() {
			return vertices;
		}
		
		public Vertex[] getEdges() {
			return edges;
		}
		public void add(int u, int v) {
		    int indexU = -99;
		    int indexV = -99;
		    for (int i = 0; i < vertices.length; i++) {
		        if (vertices[i] == u) {
		            indexU = i;
		            if (indexV != -99) {
		                break;
		            }
		        }
		        if (vertices[i] == v) {
		            indexV = i;
		            if (indexU != -99) {
		                break;
		            }
		        }
		    }

		    if (indexU != -99 && indexV != -99) {
		        Vertex tempU = edges[indexU];
		        Vertex tempV = edges[indexV];

		        while (tempU != null && tempU.getInfo() != v) {
		            tempU = tempU.getNext();
		        }
		        if (tempU != null) {
		            System.out.println("The edge already exists");
		            return;
		        }
		        edges[indexU] = new Vertex(v, edges[indexU]);
		        edges[indexV] = new Vertex(u, edges[indexV]);
		    } else if (indexU == -99 && indexV == -99) {
		        System.out.println("The vertices \"" + u + "\" and \"" + v + "\" do not exist");
		    } else if (indexU == -99) {
		        System.out.println("The vertex \"" + u + "\" does not exist");
		    } else {
		        System.out.println("The vertex \"" + v + "\" does not exist");
		    }
		}

		
		public void remove(int u, int v) {
		    int indexU = -99;
		    int indexV = -99;
		    for (int i = 0; i < vertices.length; i++) {
		        if (vertices[i] == u) {
		            indexU = i;
		        }
		        if (vertices[i] == v) {
		            indexV = i;
		        }
		    }

		    if (indexU != -99 && indexV != -99) {
		        if (edges[indexU] == null) {
		            System.out.println("no existing edge");
		            return;
		        }
		        if (edges[indexV] == null) {
		            System.out.println("no existing edge");
		            return;
		        }
		        Vertex tempU = edges[indexU];
		        Vertex vV = new Vertex(v);
		        Vertex vU = new Vertex(u);
		        Vertex tempV = edges[indexV];
		        while (tempU.getNext() != null && !tempU.getNext().isEqual(vV)) {
		            tempU = tempU.getNext();
		        }
		        if (tempU.getNext() == null) {
		            System.out.println("The edge doesn't exist");
		            return;
		        }
		        tempU.setNext(tempU.getNext().getNext());
		        while (tempV.getNext() != null && !tempV.getNext().isEqual(vU)) {
		            tempV = tempV.getNext();
		        }
		        if (tempV.getNext() == null) {
		            System.out.println("The edge doesn't exist");
		            return;
		        }
		        tempV.setNext(tempV.getNext().getNext());
		        return;

		    }

		    if (indexU == -99) {
		        System.out.println("the vertex \"" + u + "\" does not exist");
		    }
		    if (indexV == -99) {
		        System.out.println("the vertex \"" + v + "\" does not exist");
		    }
		}

		public boolean areNeighbours(int u, int v) {
		    int indexU = -99;
		    int indexV = -99;
		    for (int i = 0; i < vertices.length; i++) {
		        if (vertices[i] == u) {
		            indexU = i;
		            if (indexV != -99) {
		                break;
		            }
		        }
		        if (vertices[i] == v) {
		            indexV = i;
		            if (indexU != -99) {
		                break;
		            }
		        }
		    }

		    if (indexU != -99 && indexV != -99) {
		        Vertex tempU = edges[indexU];
		        while (tempU != null) {
		            if (tempU.getInfo() == v) {
		                return true;
		            }
		            tempU = tempU.getNext();
		        }
		    }
		    return false;
		}


		public Graph complement() {
		    Graph complement = new Graph(vertices.length);
			for (int i = 0; i<vertices.length; i++) {
				complement.vertices[i] = vertices[i];
			}
		    for (int i = 0; i < vertices.length; i++) {
		        for (int j = i + 1; j < vertices.length; j++) {
		            if (!areNeighbours(vertices[i], vertices[j])) {
		                complement.add(vertices[i], vertices[j]);
		            }
		        }
		    }
		    return complement;
		}



		
		public void dfs(int start) {
		    boolean[] visited = new boolean[vertices.length];
		    dfs(start, visited);
		}

		private void dfs(int vertex, boolean[] visited) {
		    visited[vertex - 1] = true;
		    System.out.print(vertex + " ");

		    Vertex temp = edges[vertex - 1];
		    while (temp != null) {
		        int neighbor = temp.getInfo();
		        if (!visited[neighbor - 1]) {
		            dfs(neighbor, visited);
		        }
		        temp = temp.getNext();
		    }
		}

		public boolean inCycle(int vertex) {
		    boolean[] visited = new boolean[vertices.length];
		    return inCycle(vertex, visited, -1);
		}

		private boolean inCycle(int vertex, boolean[] visited, int parent) {
		    visited[vertex - 1] = true;

		    Vertex temp = edges[vertex - 1];
		    while (temp != null) {
		        int neighbor = temp.getInfo();
		        if (!visited[neighbor - 1]) {
		            if (inCycle(neighbor, visited, vertex)) {
		                return true;
		            }
		        } else if (neighbor != parent) {
		            return true;
		        }
		        temp = temp.getNext();
		    }

		    return false;
		}


		public static void main(String[] args) {
		    Graph g = new Graph(5);
		    g.getVertices()[0] = 1;
		    g.getVertices()[1] = 2;
		    g.getVertices()[2] = 3;
		    g.getVertices()[3] = 4;
		    g.getVertices()[4] = 5;
		    
		    g.add(1, 2);
		    g.add(1, 3);
		    g.add(2, 3);
		    g.add(3, 4);
		    g.add(4, 5);
		    
		    System.out.println("Graph ");
		    System.out.println(Arrays.toString(g.getVertices()));
		    for (Vertex v : g.getEdges()) {
		        if (v != null) {
		            System.out.print(v.getInfo() + " ");
		            Vertex temp = v.getNext();
		            while (temp != null) {
		                System.out.print(temp.getInfo() + " ");
		                temp = temp.getNext();
		            }
		            System.out.println("null");
		        }
		    }
		    
		    g.remove(1, 2);
		    g.remove(3, 5);
		    
		    System.out.println("Graph after");
		    System.out.println(Arrays.toString(g.getVertices()));
		    for (Vertex v : g.getEdges()) {
		        if (v != null) {
		            System.out.print(v.getInfo() + " ");
		            Vertex temp = v.getNext();
		            while (temp != null) {
		                System.out.print(temp.getInfo() + " ");
		                temp = temp.getNext();
		            }
		            System.out.println();
		        }
		    }
		    
		    Graph complement = g.complement();
		    System.out.println("Complement");
		    System.out.println(Arrays.toString(complement.getVertices()));
		    for (Vertex v : complement.getEdges()) {
		        if (v != null) {
		            System.out.print(v.getInfo() + " ");
		            Vertex temp = v.getNext();
		            while (temp != null) {
		                System.out.print(temp.getInfo() + " ");
		                temp = temp.getNext();
		            }
		            System.out.println("null");
		        }
		    }
		    
		   g.dfs(1);
		   System.out.println();
		    System.out.println(g.inCycle(1));
		    System.out.println( g.inCycle(2));
		    g.add(1, 2);
		    System.out.println(g.inCycle(1));
		    System.out.println( g.inCycle(2));
		}

		
		
		
}
