//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int first;
    int wt;
    Pair(int first, int wt){
        this.first = first;
        this.wt = wt;
    }
}
//User function Template for Java
class Solution {
    void buildGraph(int N, int M, int [][] edges,List<List<Pair>> adjList ){
        // build adj list
		for (int i =0;i< N;i++){
		    adjList.add (new ArrayList<Pair>());
		}
		
		for (int i=0;i< M;i++){
		    int u = edges[i][0];
		    int v = edges[i] [1];
		    int d = edges[i][2];
		    adjList.get(u).add(new Pair(v, d));
		}
    }
    void topoSortUsingDFS(int node,  List<List<Pair>> adjList , int [] vis, Stack<Integer> st ){
        vis[node] =1;
        for (int i =0;i <adjList.get(node).size();i++){// iterate for all nodes for that starting node
           int v = adjList.get(node).get(i).first;
            if (vis[v]==0){
                topoSortUsingDFS(v, adjList, vis, st);
            }
        }
        st.add(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		// build graph
		List<List<Pair>> adjList = new ArrayList<>();
		buildGraph(N, M, edges, adjList);
		
		//toposort
		int [] vis = new int [N];
		Stack <Integer> st = new Stack<>();
		//for all connected components
		for (int i =0;i<N;i++){
		    if (vis[i]==0)
		        topoSortUsingDFS(i,  adjList, vis, st);
		}
		
		//Further, we declare a vector ‘dist’ in which we update the value of the nodes’
        //distance from the source vertex after relaxation of a particular node.
        int dist[] = new int[N];
        Arrays.fill(dist,(int)(1e9));
        
        //Update correct distances for all nodes
        dist[0]=0;
        while (!st.isEmpty()){
            int node = st.pop();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                
                int v = adjList.get(node).get(i).first;
                int wt = adjList.get(node).get(i).wt;
                if (dist[node]+ wt < dist[v] ){
                    dist[v] = dist[node] +wt;
                }
            }
        }
        
        //convert any 
       for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
	}
}