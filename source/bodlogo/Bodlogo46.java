package bodlogo;
/*
ªãºãäñºí Ì òîîã á¿õëýýð õóâààæ ÷àäàõ òîîí îëîíëîãèéã îëîõ ïðîãðàìì áè÷.
*/
import java.util.Scanner;

public class Bodlogo46 {
    public static void main(String args[]){
        
        Scanner orolt = new Scanner(System.in);
        System.out.println("Тоогоо оруунна уу: ");
        int m ;
        m = orolt.nextInt(); 
        int h = 1;
        do {
              
                    if(m%h ==0){
          System.out.println(h);
        }
      h++; 
    }while (h<=m);
     
    }  
}
