package teacher.login.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import teacher.login.ui.CustomerLogin;

public class LoginFeature {
    
    
    // 1. LoginFile uusgej textfield deh utga hadgalna
    // 2. LoginFile unshij encryptedFile uusgeed loginFile ustgana
    // 3. encryptedFile iig unshij decryptedFile uusgene
    // 4. decryptedFile aas utgaa unshij textfield deer tavina
    
    private static String key = "Sugraaaa";
//    public static File decFile = new File("decrypted.txt");
    private static File encFile = new File("encrypted.txt");
    
    private static void step1() {
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
    
    private static void step2() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(CustomerLogin.LOGINFILE);
            FileOutputStream fos = new FileOutputStream(encFile);
            encrypt(key, fis, fos);
            if (CustomerLogin.LOGINFILE.delete()) {
                System.out.println("Login file deleted");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void step3() {
        FileOutputStream fos2 = null;
        try {
            FileInputStream fis2 = new FileInputStream(encFile);
            fos2 = new FileOutputStream(CustomerLogin.decFile);
            decrypt(key, fis2, fos2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos2.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginFeature.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    private static void step4() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CustomerLogin.decFile));
            String line = br.readLine();
            if (line != null) {
                String[] arr = line.split("::");
                if (arr.length > 2) {
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
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File unshhad oldsongui!");
        } catch (IOException ex) {
            System.out.println("File unshhad aldaa garlaa!");
        }
        
    }
    
    public static void refreshEncFiles(int actions) {
        if (actions == 1) {
            step1();
            step2();
            step3();
            step4();
        } else if (actions == 2) {
            if (encFile.exists()) {
                step3();
                step4();
            } else {
                refreshEncFiles(1);
            }
        }
        
        if (CustomerLogin.decFile.delete()) {
                System.out.println("Decrypted file deleted");
            }
    }

    public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }

    public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }

    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
        }
    }

    public static void doCopy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();

    }
    
}


