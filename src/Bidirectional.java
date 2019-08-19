import java.util.*;

public class Bidirectional {

    public void search(Problem p) {

        Queue<Node> queueI = new LinkedList<>();
        Queue<Node> queueG = new LinkedList<>();
        Set<Node> visitedI = new HashSet<>();
        Set<Node> visitedG = new HashSet<>();
        visitedI.add(p.getInitialState());
        visitedG.add(p.getGoal());
        queueI.add(p.getInitialState());
        queueG.add(p.getGoal());
        while (!queueI.isEmpty() || !queueG.isEmpty()) {
            if (pathExistsHelper(queueI, visitedI, visitedG)) {
                return;
            }
            if (pathExistsHelper(queueG, visitedG, visitedI)) {
                return;
            }
        }

        return;
    }

    private  boolean pathExistsHelper(Queue<Node> queue, Set<Node> visitedA, Set<Node> visitedB) {
        if (!queue.isEmpty()) {
            Node next = queue.remove();
            Set<Node> adjacentNodes = new HashSet<>();
            List<Integer> actions = next.getActions();
            for (Integer i: actions) {
                adjacentNodes.add(next.getNext(i));
            }

            for (Node adjacent : adjacentNodes) {

                Node n;
                if ((n = containsNode(visitedB, adjacent) )!= null) {
                    System.out.println("here: ");
                    adjacent.print();
                    System.out.println(".........");
                    Stack<Node> stack = new Stack<>();
                    while (adjacent != null){
                        stack.add(adjacent);
                        adjacent = adjacent.getParent();
                    }
                    while (!stack.isEmpty()) {
                        stack.pop().print();
                        System.out.println();

                    }

                    n = n.getParent();
                    while (n!= null) {
                        n.print();
                        System.out.println();
                        n = n.getParent();
                    }
                    return true;
                } else if (containsNode(visitedA, adjacent) == null) {
                    visitedA.add(adjacent);
                    queue.add(adjacent);
                }
            }
        }
        return false;
    }

    private  Node containsNode(Set<Node> s, Node a){
        for (Node n: s) {
            if( n.isEqual(a))
                return n;
        }
        return null;
    }

}

