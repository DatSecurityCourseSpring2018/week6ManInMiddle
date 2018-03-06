package cphkasper.rsa;

import java.math.BigInteger;

/**
 The purpose of PublicKey is to...

 @author kasper
 */
public class PublicKey implements RSAKey{

    private BigInteger N;
    private  BigInteger publicKey;
    
    public PublicKey( BigInteger publ, BigInteger N ) {
        this.publicKey = publ;
        this.N = N;
    }

    // Encrypt message
    @Override
    public byte[] encrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow(publicKey, N ).toByteArray();
    }


    // Decrypt message
    @Override
    public byte[] decrypt( byte[] message ) {
        return ( new BigInteger( message ) ).modPow(publicKey, N ).toByteArray();
    }

    @Override
    public RSAKey getPublicKey() {
        return this;
    }


}
