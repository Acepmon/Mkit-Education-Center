package login.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import login.ui.CustomerLogin;

public class IPFeature {
    
    public static String ip = "192.168.0.114";
    
     public static void readFeature() {
        try {
            if (!CustomerLogin.IPFile.exists()) {
                CustomerLogin.IPFile.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(CustomerLogin.IPFile));
                bw.write("192.168.0.114");
                bw.flush();
                bw.close();
            }
            BufferedReader br = new BufferedReader(new FileReader(CustomerLogin.IPFile));
            String line = br.readLine();
            ip = line;
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File unshhad oldsongui!");
        } catch (IOException ex) {
            System.out.println("File unshhad aldaa garlaa!");
        }
    }
    
}
