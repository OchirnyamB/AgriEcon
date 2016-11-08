package authenticate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.mySQLconnect;
/**
 * Created by bazarsad on 11/7/2016.
 */
public class EncryptPassword {
    private String passwordToHash="";
    private String generatedSecuredPasswordHash;
    public EncryptPassword(String originalpassword){
        this.passwordToHash = originalpassword;
    }
    public void generateStrongPasswordHash() throws NoSuchAlgorithmException, SQLException {
        byte[] salt = getSalt();
        PreparedStatement ps = null;
        // Receiving the secured hash password
        this.generatedSecuredPasswordHash = get_SHA_1_SecurePassword(passwordToHash, salt);
    }
    // Salt - randomly generated text with pseudo random number sequence
    private static byte[] getSalt() throws NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    // Appends the salt to hash-able password and does 160 bits Hash
    private static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt){
        String generatedPassword = null;
        try{
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // Add salt bytes to digest
            md.update(salt);
            // Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff)+0x100, 16).substring(1));
            }
            // Get completed hashed password in hex format
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }
    public String getGeneratedHashKey(){
        return generatedSecuredPasswordHash;
    }
}
