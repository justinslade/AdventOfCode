package za.co.justinslade.AdventOfCode;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventOfCode5 {

    public static void main(String... args) throws NoSuchAlgorithmException {
        String input = "reyedfim";
        long i = 0;
        StringBuilder password = new StringBuilder();
        while (password.length() < 8){
            String format = String.format("%s%d", input, i);
            System.out.println(format);
            String md5Hash = AdventOfCode5.getMD5Hash(format);
            System.out.println(md5Hash);
            if (md5Hash.startsWith("00000")){
                char c = md5Hash.charAt(5);
                System.out.println(c);
                password.append(c);
            }
            i++;
        }
        System.out.print(password.toString());
    }

    /**
     * Returns a hexadecimal encoded MD5 hash for the input String.
     * @param data
     * @return
     */
    private static String getMD5Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

        /**
         * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
         * to a hexadecimal string. Note that this generates hexadecimal in upper case.
         * @param hash
         * @return
         */
    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }

}
