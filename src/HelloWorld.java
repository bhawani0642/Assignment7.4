
import java.util.Arrays;
/**
 * Created a class HelloWorld
 * @author Pri
 *
 */
public class HelloWorld{
	//Main method
  public static void main(String args[]){
    int[] abc ={5,8,2,0,1};
    int n = 5;
  HelloWorld.recursiveCall(abc, n);
    
  }
  public static void recursiveCall(int[] abc, int n){
      if(abc.length <= 1) return;               // Base case: just 1 elt
    int[] a = new int[abc.length / 2];        // Split array into two
    int[] b = new int[abc.length - a.length]; //   halves, a and b
    for(int i = 0; i < abc.length; i++) {
        if(i < a.length) a[i] = abc[i];
        else             b[i - a.length] = abc[i];
    }
    recursiveCall(a, n);                              // Recursively sort first
    recursiveCall(b, n);                              //   and second half.
    int ai = 0;                                // Merge halves: ai, bi
    int bi = 0;                                //   track position in
    while(ai + bi < abc.length) {             //   in each half.
        if(bi >= b.length || (ai < a.length && a[ai] < b[bi])) {
            abc[ai + bi] = a[ai]; // (copy element of first array over)
            ai++;
        } else {
            abc[ai + bi] = b[bi]; // (copy element of second array over)
            bi++;
        }
    }
    System.out.println(Arrays.toString(abc));
  }
  
}