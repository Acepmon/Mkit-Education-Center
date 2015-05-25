package bodlogo;
/*
Äóðûí ºãºãäñºí A(N) ìàññèâ äàõü óòãóóäûã èõýýñ áàãà ðóó ýðýìáýëýõ ïðîãðààìì áè÷.
*/
import java.util.Arrays;
import java.util.Random;

public class Bodlogo31 {
    public static void main (String args[]){
    
    int[] array = new int[10];
    Random rand = new Random();
    for (int i = 0; i < array.length; i++)
    array[i] = rand.nextInt(100) + 1;
   

    System.out.println(Arrays.toString(array));
    
    Arrays.sort(array);
    for (int i = array.length - 1; i >= 0; i--)
    System.out.print(array[i] + " ");
    System.out.println();
        }
    }   