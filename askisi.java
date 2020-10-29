import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class askisi {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {


        File arxeio_data = userInterface.getfile_with_data();
        File arxeio_config = userInterface.getfile_configur();
        String eisodos_paragomeno = userInterface.get_new_file_name();
        encrypt kripto = new encrypt(arxeio_data, arxeio_config, eisodos_paragomeno);
        kripto.doencrypt();

    }
    }

