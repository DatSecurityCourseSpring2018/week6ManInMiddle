package cphkasper.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 The purpose of DiffieHellmanMerkle is to...

 @author kasper
 */
public class DiffieHellmanMerkle {

    private static final int BITSIZE = 4048;

    public static void main( String[] args ) {
        // Public knowledge (exchanged via unsafe channel)
        Random rnd = new SecureRandom();
        Long start = System.nanoTime();
        BigInteger Y = BigInteger.probablePrime( BITSIZE, rnd );
        Long done = System.nanoTime();
        System.out.println( "Time: " + ( done - start )/1_000_000 );
//        BigInteger P = BigInteger.probablePrime( BITSIZE, rnd );
//
//        // A picks AX as secret number
//        BigInteger AX = BigInteger.probablePrime( BITSIZE, rnd );
//        // A computes AN and sends AN to B
//        BigInteger AN = Y.modPow( AX, P );
//
//        // B picks BX as secret number
//        BigInteger BX = BigInteger.probablePrime( BITSIZE, rnd );
//        // B computes BN and sends BN to A
//        BigInteger BN = Y.modPow( BX, P );
//
//        // A computes the Key
//        BigInteger AK = BN.modPow( AX, P );
//        System.out.println( "AK: " + AK );
//
//        // B computes the key
//        BigInteger BK = AN.modPow( BX, P );
//        System.out.println( "BK: " + BK );

    }

}
