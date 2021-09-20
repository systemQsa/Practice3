import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.util.Arrays;


public class Part4 {
    public static void main(String[] args) {

        System.out.println(hash("asdf", "MD5"));

        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm) {
        String output = "";
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(input.getBytes(),0,input.length());
            byte[] hash = digest.digest();
            output = DatatypeConverter.printHexBinary(hash);
        } catch ( NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return output;
    }
}
