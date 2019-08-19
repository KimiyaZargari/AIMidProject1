import java.util.ArrayList;
import java.util.List;

public class Node {
    int[][] state;
    private Node parent;

    public final int depth;

    public Node(int[][] state, int depth, Node parent){
        this.parent = parent;
        this.depth = depth;
        this.state = state;
    }

    public Node getNext(int action){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j]  == 0){
                    return new Node(shift(i, j, action), depth + 1, this);

                }
            }
        }
        return null;
        }

    public  void print() {
        System.out.println(state[0][0] + " " + state[0][1] + " " + state[0][2]);
        System.out.println(state[1][0] + " " + state[1][1] + " " + state[1][2]);
        System.out.println(state[2][0] + " " + state[2][1] + " " + state[2][2]);
    }
private int[][] shift(int i, int j, int d) {
        int [][] s = new int [3][3];
    if (d == 0) {
        for (int k = 0; k <3 ; k++) {
            for (int l = 0; l < 3; l++) {
                if (k == i & l == j)
                    s[k][l] = state[i+1][j];
                else
                    s[k][l] = state[k][l];
            }
        }
        s[i+1][j] = 0;
    }
     if( d == 1){
         for (int k = 0; k <3 ; k++) {
             for (int l = 0; l < 3; l++) {
                 if (k == i & l == j)
                     s[k][l] = state[i-1][j];
                 else
                     s[k][l] = state[k][l];
             }
         }
         s[i-1][j] = 0;
     }
     if( d == 2){
        for (int k = 0; k <3 ; k++) {
            for (int l = 0; l < 3; l++) {
                if (k == i & l == j)
                    s[k][l] = state[i][j+1];
                else
                    s[k][l] = state[k][l];
            }
        }
        s[i][j+1] = 0;
    }
    if( d == 3){
        for (int k = 0; k <3 ; k++) {
            for (int l = 0; l < 3; l++) {
                if (k == i & l == j)
                    s[k][l] = state[i][j-1];
                else
                    s[k][l] = state[k][l];
            }
        }
        s[i][j-1] = 0;
    }
    return s;
}
public List<Integer> getActions(){
        List<Integer> actions  = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (state[i][j]  == 0){

                if (j> 0) {
                    actions.add(3);
                }
                if (i>0) {
                    actions.add(1);
                }
                if (j< 2) {
                    actions.add(2);
                }
                if (i< 2) {
                    actions.add(0);
                }


                break;
            }
        }
    }
    return actions;
}

    public Node getParent() {
        return parent;
    }
    public int getH() {
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (state[i][j]) {
                    case 0:
                        h += 4 - i - j;
                        break;
                    case 1:
                        h += i + j;
                        break;
                    case 2:
                        h += Math.abs(i) + Math.abs(1 - j);
                        break;
                    case 3:
                        h += Math.abs(i) + Math.abs(2 - j);
                        break;
                    case 4:
                        h += Math.abs(1 - i) + Math.abs(j);
                        break;
                    case 5:
                        h += Math.abs(1 - i) + Math.abs(1 - j);
                        break;
                    case 6:
                        h += Math.abs(1 - i) + Math.abs(2 - j);
                        break;
                    case 7:
                        h += Math.abs(2 - i) + Math.abs(j);
                        break;
                    case 8:
                        h += Math.abs(2 - i) + Math.abs(1 - j);
                        break;
                }
            }
        }
        return h;
    }

    public boolean isEqual(Node n) {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if(state[i][j] != n.getState()[i][j])
                    return false;
            }
        }
        return true;
    }

    public int[][] getState() {
        return state;
    }
}

