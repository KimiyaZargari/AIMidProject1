import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class UniformCost {
    public void uniformCostSearch(Problem problem) {
        List<Pair<Node, Integer>> frontier = new ArrayList<>();
        List<Pair<Node, Integer>> discovered = new ArrayList<>();
        Node s = problem.getInitialState();
        if (problem.isGoal(s)) {
            s.print();
            return;
        }
        int c = 0;
        frontier.add(new Pair<>(s, c));
        while (!frontier.isEmpty()) {
            Pair<Node, Integer> pair = frontier.get(0);
            for (Pair<Node, Integer> p : frontier) {
                if (p.getValue() < pair.getValue()) {

                    pair = p;
                }
                System.out.println(pair.getValue());
            }
            frontier.remove(pair);
            Node state = pair.getKey();
            int cost = pair.getValue();

            if (problem.isGoal(state)) {

                while (state != null){
                    state.print();
                    state = state.getParent();
                    System.out.println();
                }
              return;
            }

            List<Integer> actions = problem.getActions(state);


            for (int action : actions) {
                s = problem.getNextState(state, action);
                c = cost + 1;
                Pair<Node, Integer> p = new Pair<>(s, c);

                if (!containsPair(discovered, p)) {
                    frontier.add(new Pair<>(s, c));
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

