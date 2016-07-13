import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Gustaf Nilstadius
 * @version 1.0
 */
public class NB20Main {
    public  static void main (String [] args){
        System.out.println("Hello!");
        System.out.println("To reach 109 you need minimum: " + myntmaskin(109));

    }

    private static class State{
        public int points, cent;
        public State(int points, int cent){
            this.points = points;
            this.cent = cent;
        }
    }

    public static int myntmaskin(int goal){
        Queue<State> q = new LinkedList<State>();
        Queue<State> g = new LinkedList<State>();
        State s = new State(1, 0);
        do {
            if (s.points == goal){
                g.offer(new State(s.points, s.cent));
            } else {
                if (s.points * 3 <= goal) {
                    q.offer(new State(s.points * 3, s.cent + 10));
                }
                if (s.points + 4 <= goal) {
                    q.offer(new State(s.points + 4, s.cent + 5));
                }
            }
            s = q.poll();
        } while(!q.isEmpty());

        s = g.poll();
        while(!g.isEmpty()){
            if(s.cent > g.peek().cent){
                s = g.poll();
            } else {
                g.poll();
            }
        }
        return s.cent;
    }
}
