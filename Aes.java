import javax.crypto.*;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Aes {

Scanner data;
int[] stiles_gia_kriptografisi;
FileWriter newfile;
Utilities util = new Utilities();

Aes(Scanner a, int[] b, FileWriter c){
    this.data=a;
    this.stiles_gia_kriptografisi=b;
    this.newfile=c;
}

public void doaes() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecretKey skey = kgen.generateKey();
    Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
    ci.init(Cipher.ENCRYPT_MODE, skey);
    String line;
    int arithmos_stilon;
    while (data.hasNextLine()) {
        line = data.nextLine();
        arithmos_stilon=line.split("\t").length;
        String[] pinakas = line.split("\t");
        for (int i = 0; i < arithmos_stilon; i++) {
            if (util.contains(stiles_gia_kriptografisi, i)) {
                byte[] input = pinakas[i].getBytes("UTF-8");
                byte[] encoded = ci.doFinal(input);
                newfile.write(String.valueOf(encoded) + '\t');
            } else {
                newfile.write(pinakas[i] + '\t');
            }
        }
        newfile.write('\n');
    }
    newfile.close();
    data.close();
}
}
