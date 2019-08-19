import java.util.*;

public class BFS {

    private Set<Node> discovered;
    private Queue<Node> frontier;

    public void search(Problem p) {
        discovered = new HashSet<>();
        frontier = new LinkedList<>();

        discovered.add(p.getInitialState());
        frontier.add(p.getInitialState());

        while (!frontier.isEmpty()) {
            Node c = frontier.remove();


            if (p.isGoal(c)) {
                while (c != null){
                    c.print();
                    c = c.getParent();
                    System.out.println();
                }
                return;

            }

            for (Integer i : p.getActions(c)) {
                Node n = p.getNextState(c, i);
                if (!discovered.contains(n)) {
                    discovered.add(n);
                    frontier.add(n);
                }
            }
        }
    }
}

