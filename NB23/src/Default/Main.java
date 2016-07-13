package Default;
import Eight.*;
import Unlimited.*;


/**
 * @author Gustaf Nilstadius
 */
public class Main {
    public static void main (String[] args){
        System.out.println("Hello!");
        if(args.length >= 1){
            Queens q = new Queens(Integer.parseInt(args[0]));
            System.out.println("Nr of possible solutions with " + args[0] + " queens: " + q.addQueen());
        } else {
            EightQueens q = new EightQueens();
            q.addQueen();
        }


    }

}
