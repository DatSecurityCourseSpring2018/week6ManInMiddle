package cphkasper.rsa;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import java.security.SecureRandom;

public class RSAAlg extends RSAKey  {

    private final BigInteger priv;
    private static final int BITLENGTH = 128;

    public RSAAlg() {
        BigInteger p;
        BigInteger q;
        SecureRandom r = new SecureRandom();
        p = BigInteger.probablePrime( BITLENGTH, r );
        q = BigInteger.probablePrime( BITLENGTH, r );
        N = p.multiply( q );
        BigInteger phi = p.subtract( ONE ).multiply( q.subtract( ONE ) );
        priv = BigInteger.probablePrime( BITLENGTH / 2, r );
        while ( phi.gcd( priv ).compareTo( ONE ) > 0 && priv.compareTo( phi ) < 0 ) {
            priv.add( ONE );
        }
        publ = priv.modInverse( phi );
    }
    

    // Encrypt message
    public byte[] encrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( priv, N ).toByteArray();
    }
    


    // Decrypt message
    public byte[] decrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( priv, N ).toByteArray();
    }
    


    @Override
    public String toString() {
        return "Priv: " + priv + "\n publ: " + publ + "\n N: " + N + "\n";
    }

    @Override
    public RSAKey getPublicKey() {
        return new PublicKey(publ, N);
    }
}
