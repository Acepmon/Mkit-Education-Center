package bodlogo;
/*
7 îðîíãîîñ õýòðýõã¿é áàéõ 0-1 õîîðîíä îðøèõ áóòàðõàé òîîíóóäûã ºñºõ ýðýìáýýð õýâëýõ ïðîãðàìì áè÷.
*/

import java.util.Arrays;
import java.util.Random;

public class Bodlogo37 {
    static String str;
    static String str2;
    public static void main (String args[]){
    
    double[] array = new double[10];
    Random rand = new Random();
    int i;
    for (i = 0; i < array.length; i++){
    array[i] = rand.nextDouble();
   
    }
    
  for (i = 0; i < array.length; i++){   
    Arrays.sort(array);
    str = String.valueOf(array[i]);
    str2 = str.substring(0, 8);
    
    System.out.print(str2 + " ");
    }
   }
  }   