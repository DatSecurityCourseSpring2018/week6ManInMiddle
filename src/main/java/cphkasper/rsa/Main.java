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
        RSAKeyPair myPair = new RSAKeyPair();
        System.out.println( "RSA: " + myPair );
        RSAKeyPair other = new RSAKeyPair();

        //SignMessage(myPair);
        //EndcryptMessage(pair);
        
        String msg = "Iam really me";
        String enc = myPair.encrypt( msg);
        System.out.println( "Encoded: " + enc);
        enc = other.getPublicKey().encrypt( enc);
        
        // Send enc to the other....
        String dec = other.decrypt( enc);
        dec = myPair.getPublicKey().decrypt( dec);
        
        System.out.println( "Signed encrypted message was: " +dec );
        
        
        

    }

    private static void SignMessage( RSAKeyPair pair ) {
        String signature = "I am me";
        String signedMessage = pair.encrypt( signature );
        
        // send to the world who has my public key
        RSAKey world = pair.getPublicKey();
        String message = world.decrypt( signedMessage);
        System.out.println( "Public decrypted message: " + message );
    }

    private static void EndcryptMessage( RSAKeyPair pair ) {
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
