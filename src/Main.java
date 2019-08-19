public class Main {
    public static void main(String[] args) {
        int[][] state = {{1,0,3}, {4,2,6}, {7, 5, 8}};
        int [][] goal = {{1, 2,3}, {4, 5, 6}, {7, 8, 0}};

        BFS bfs = new BFS();
        DFS dfs = new DFS();
        UniformCost uniformCost = new UniformCost();
        Bidirectional bd = new Bidirectional();
        AStar as = new AStar();
        Problem p = new Problem(new Node(state, 0, null), new Node(goal, 0, null));
        as.aStar(p);
       // dfs.search(p, 5);
       // uniformCost.uniformCostSearch(p);
        //bfs.search(p);
       // dfs.search(p);
       // dfs.iterativeDeepeningSearch(p);
       // bd.search(p);
    }
}
