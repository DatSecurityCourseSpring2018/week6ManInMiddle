package cphkasper.rsa;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 The purpose of RSAKey is to...

 @author kasper
 */
public interface RSAKey {

    public abstract RSAKey getPublicKey();

    // Encrypt message
    public abstract byte[] encrypt( byte[] message );

    public default String encrypt( String message ) {
        byte[] bytes = message.getBytes();
        byte[] cifer = encrypt( bytes );
        return Base64.getEncoder().encodeToString( cifer );
    }

    // Decrypt message
    public abstract byte[] decrypt( byte[] message );

    public default String decrypt( String base64String ) {
        byte[] cifer = Base64.getDecoder().decode( base64String );
        byte[] bytes = decrypt( cifer );
        return new String( bytes, StandardCharsets.UTF_8 );
    }

}
