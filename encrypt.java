import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class encrypt {
   File dedomena;
   File configuration;
   String onoma_arxeiou;
   String line;
   Utilities util =new Utilities();

    encrypt(File x, File a,String b){
        this.dedomena=x;
        this.configuration=a;
        this.onoma_arxeiou=b;

    }



    public void doencrypt() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Scanner data = new Scanner(new FileReader(dedomena));
        data.useDelimiter("\\t");
        line = data.nextLine();
        int[] stiles_gia_kriptografisi=util.euresiPedion(line,configuration);
        int arithmos_stilon=line.split("\t").length;
        FileWriter newfile = new FileWriter(onoma_arxeiou);
        newfile.write(line + '\n');
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecretKey skey = kgen.generateKey();
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.ENCRYPT_MODE, skey);
        while (data.hasNextLine())
        {
            line = data.nextLine();
            String[] pinakas1 =line.split("\t");
            for (int i = 0; i < arithmos_stilon; i++)
            {
                if (util.contains(stiles_gia_kriptografisi,i)) {
                    byte[] input = pinakas1[i].getBytes("UTF-8");
                    byte[] encoded = ci.doFinal(input);
                    newfile.write(String.valueOf(encoded) + '\t');
                }
                else {newfile.write(pinakas1[i] + '\t');}
            }
            newfile.write('\n');
        }
        newfile.close();
        data.close();

    }

}
