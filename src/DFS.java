
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    private Set<Node> discovered;
    private Stack<Node> frontier;


    public void search(Problem p, int depthLimit) {

        discovered= new HashSet<>();
        frontier = new Stack<>();

        discovered.add(p.getInitialState());
        frontier.push(p.getInitialState());



        while (!frontier.empty()) {
            Node c = frontier.pop();


            if (p.isGoal(c)){
                System.out.printf("Found final state.\n");
                while (c != null){
                    c.print();
                    c = c.getParent();
                    System.out.println();
                }
                return;
            }

            for (Integer i : p.getActions(c)) {
                Node n = p.getNextState(c, i);
                if (n.depth <= depthLimit && !discovered.contains(n)) {
                    discovered.add(n);
                    frontier.add(n);
                }
            }
        }

    }

    public void search(Problem p) {
         search(p, Integer.MAX_VALUE);
    }

    public void iterativeDeepeningSearch(Problem p) {
        int depthLimit = 1;

        Node node = null;

        while (node == null) {
            search(p, depthLimit);
            depthLimit++;
        }
    }

}

