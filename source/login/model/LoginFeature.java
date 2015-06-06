package login.model;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import login.ui.CustomerLogin;

public class LoginFeature {

    private File file;

    public LoginFeature() {
        file = new File("login.txt");
        if (file.exists()) {
            readFromFile();
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("File uusgej chadsangui!");
            }
            readFromFile();
        }
    }

    private void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            if (line != null) {
                String[] arr = line.split("::");
                String remember = arr[0];
                String username = arr[1];
                String password = arr[2];

                if (remember.equals("true")) {
                    CustomerLogin.getFld().setText(username);
                    CustomerLogin.getFld2().setText(password);
                }
            } else {
                resetFile();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File unshhad oldsongui!");
        } catch (IOException ex) {
            System.out.println("File unshhad aldaa garlaa!");
        }
    }

    // File deer dutuu mor baihiin bol teriig hevend ni oruulj ogno.
    
    private void resetFile() {
        String remember = "";
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line = remember+"::"+username+"::"+password;
            bw.write(line);
            
            bw.flush();
            bw.close();
        } catch (IOException ex) {

        }

    }

}
