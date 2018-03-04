package cphkasper.rsa;

import java.io.DataInputStream;
import java.io.IOException;

/**
 The purpose of Main is to...

 @author kasper
 */
public class Main {

    public static void main( String[] args ) throws IOException {
        RSAAlg priv = new RSAAlg();
        System.out.println( "RSA: " + priv );
        DataInputStream in = new DataInputStream( System.in );
        String teststring = "Secret AES key";
        
        System.out.println( "Encrypting String: " + teststring );
        
        // encrypt
        String encrypted = priv.encrypt( teststring );
        System.out.println( "Encrypted: " + encrypted);
        
        RSAKey publ = priv.getPublicKey();
        
        // in an other system, other program, other user...
        // decrypt
        String decrypted = publ.decrypt( encrypted );
        System.out.println( "Decrypted String: " + decrypted  );
    }
}
