import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class AStar {
    public void aStar(Problem problem) {
        List<Pair<Node, Integer>> frontier = new LinkedList<>();
        List<Pair<Node, Integer>> discovered = new LinkedList<>();
        Node s = problem.getInitialState();
        int c = 0;
        frontier.add(new Pair<>(s, c));
        while (!frontier.isEmpty()) {
            Pair<Node, Integer> pair = frontier.get(0);
            for (Pair<Node, Integer> p : frontier) {
                if (p.getValue() + p.getKey().getH() < pair.getValue() + pair.getKey().getH()) {
                    pair = p;
                }
            }
            System.out.println(pair.getValue());
            frontier.remove(pair);
            Node state = pair.getKey();
            int cost = pair.getValue();

            List<Integer> actions = problem.getActions(state);
            for (int action : actions) {
                s = problem.getNextState(state, action);
                c = cost + 1;
                Pair<Node, Integer> p = new Pair<>(s, c);
                if (!containsPair(discovered, p)) {
                    if (problem.isGoal(s)) {
                        while (s != null){
                            s.print();
                            s = s.getParent();
                            System.out.println();
                        }
                        return;
                    }
                    frontier.add(p);
                }
            }
            discovered.add(pair);
        }
    }
    public static boolean containsPair(List<Pair<Node, Integer>> list, Pair<Node, Integer> item) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j).getKey().isEqual( item.getKey()))
                return true;
        }
        return false;
    }
}
