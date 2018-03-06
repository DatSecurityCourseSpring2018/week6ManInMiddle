package cphkasper.rsa;

import java.io.DataInputStream;
import java.io.IOException;

/**
 The purpose of Main is to...

 @author kasper
 */
public class Main {

    public static void main( String[] args ) throws IOException {
        // Setup
        RSAKeyPair pair = new RSAKeyPair();
        System.out.println( "RSA: " + pair );

        // Send public key to the world
        RSAKey publ = pair.getPublicKey();

        // in an other system, other program, other user...
        // encrypt
        String teststring = "Secret AES key";
        System.out.println( "Secret message: " + teststring );
        String encrypted = publ.encrypt( teststring );
        System.out.println( "Encrypted String: " + encrypted );

        // Back on our system

        // encrypt
        String decrypted = pair.decrypt( encrypted );
        System.out.println( "Decrypted: " + decrypted );

    }
}
