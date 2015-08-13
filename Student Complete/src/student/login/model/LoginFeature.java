package student.login.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import student.login.CustomerLogin;

public class LoginFeature {
    
    public static void readLoginFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CustomerLogin.LOGINFILE));
            String line = br.readLine();
            if (line != null) {
                String[] arr = line.split("::");
                String remember = arr[0];
                String username = arr[1];
                String password = arr[2];
                
                if (remember.equals("true")) {
                    CustomerLogin.getFld().setText(username);
                    CustomerLogin.getFld2().setText(password);
                    CustomerLogin.getBox1().setSelected(true);
                } else {
                    CustomerLogin.getFld().setText("");
                    CustomerLogin.getFld2().setText("");
                    CustomerLogin.getBox1().setSelected(false);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File unshhad oldsongui!");
        } catch (IOException ex) {
            System.out.println("File unshhad aldaa garlaa!");
        }
    }
    
    public static void refreshFile() {
        if (!CustomerLogin.LOGINFILE.exists()) {
            try {
                CustomerLogin.LOGINFILE.createNewFile();
            } catch (IOException ex) {
                System.out.println("File uusgej chadsangui!");
            }
        }
        String remember = "false";
        String username = "";
        String password = "";
        
        if (CustomerLogin.getBox1().isSelected()) {
            remember = "true";
        } else {
            remember = "false";
        }
        
        if (CustomerLogin.getTmp_username() == null) {
            username = "";
        } else {
            username = CustomerLogin.getTmp_username();
        }
        
        if (CustomerLogin.getTmp_password() == null) {
            password = "";
        } else {
            password = CustomerLogin.getTmp_password();
        }

        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CustomerLogin.LOGINFILE))) {
                String line = remember+"::"+username+"::"+password;
                bw.write(line);
                bw.flush();
            }
        } catch (IOException ex) {
            System.out.println("File luu bichij chadsangui!");
        }
    }

}
