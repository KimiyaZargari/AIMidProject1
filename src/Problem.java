import java.util.List;

public class Problem {
   private Node initialState;
   private Node goal;
   public Problem(Node initialState, Node goal){
      this.initialState = initialState;
      this.goal = goal;
   }
   public boolean isGoal(Node n){
      return n.isEqual(goal);
   }
   public List<Integer> getActions(Node n){
      return n.getActions();
   }
   public Node getNextState(Node n, int action){
       return n.getNext(action);
   }

   public Node getInitialState() {
      return initialState;
   }

   public Node getGoal() {
      return goal;
   }
}
