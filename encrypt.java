import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class encrypt {
   File dedomena;
   File configuration;
   String onoma_arxeiou;
   String line;
   Utilities util = new Utilities();

    encrypt(File x, File a,String b){
        this.dedomena=x;
        this.configuration=a;
        this.onoma_arxeiou=b;

    }

    public void doencrypt() throws IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Scanner data = new Scanner(new FileReader(dedomena));
        data.useDelimiter("\\t");
        line = data.nextLine();
        int[] stiles_gia_kriptografisi=util.euresiPedion(line,configuration);
        int k = userInterface.get_method_crypto();
        FileWriter newfile = new FileWriter(onoma_arxeiou);
        newfile.write(line + '\n');
        switch (k)
        {
            case 1:
                Aes aes = new Aes(data,stiles_gia_kriptografisi,newfile);
                aes.doaes();
                break;
            case 2:
                SimpleMethod simple = new SimpleMethod(data,stiles_gia_kriptografisi,newfile);
                simple.dosimple();
                break;
        }
    }

}
