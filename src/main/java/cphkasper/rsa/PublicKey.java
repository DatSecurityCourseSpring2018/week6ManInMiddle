package cphkasper.rsa;

import java.math.BigInteger;

/**
 The purpose of PublicKey is to...

 @author kasper
 */
public class PublicKey extends RSAKey{

    private final BigInteger publ;
    private final BigInteger N;

    public PublicKey( BigInteger publ, BigInteger N ) {
        this.publ = publ;
        this.N = N;
    }

    // Encrypt message
    @Override
    public byte[] encrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( publ, N ).toByteArray();
    }


    // Decrypt message
    @Override
    public byte[] decrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow( publ, N ).toByteArray();
    }

    @Override
    public RSAKey getPublicKey() {
        return this;
    }


}
