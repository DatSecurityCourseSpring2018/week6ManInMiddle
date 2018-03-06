package cphkasper.rsa;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import java.security.SecureRandom;

public class RSAKeyPair implements RSAKey {

    private final BigInteger publicKey;
    private final BigInteger privateKey;
    private final BigInteger N;
    
    private static final int BITLENGTH = 2048;

    public RSAKeyPair() {
        BigInteger p;
        BigInteger q;
        SecureRandom r = new SecureRandom();
        p = BigInteger.probablePrime( BITLENGTH, r );
        q = BigInteger.probablePrime( BITLENGTH, r );
        N = p.multiply( q );
        BigInteger phi = p.subtract( ONE ).multiply( q.subtract( ONE ) );
        //publicKey = BigInteger.probablePrime( BITLENGTH / 2, r ); // 65537
        publicKey = BigInteger.valueOf( 65537 );
        privateKey = publicKey.modInverse( phi );
    }

    // Encrypt message
    public byte[] encrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( privateKey, N ).toByteArray();
    }

    // Decrypt message
    public byte[] decrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( privateKey, N ).toByteArray();
    }

    @Override
    public String toString() {
        return "\nPriv: " + privateKey
                + "\n   N: " + N
                + "\nPubl: " + publicKey;
    }

    @Override
    public RSAKey getPublicKey() {
        return new PublicKey( publicKey, N );
    }
}
