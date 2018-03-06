package cphkasper.rsa;

import java.math.BigInteger;

/**
 * The purpose of DiffieHellmanMerkle is to...
 * @author kasper
 */
public class DiffieHellmanMerkle {
    public static void main( String[] args ) {
        // Public knowledge (exchanged via unsafe channel)
        BigInteger Y = BigInteger.valueOf(23);
        BigInteger P = BigInteger.valueOf(117);
        
        // A picks AX as secret number
        BigInteger AX = BigInteger.valueOf(17);
        // A computes AN and sends AN to B
        BigInteger AN = Y.modPow( AX, P );
        

        // B picks BX as secret number
        BigInteger BX = BigInteger.valueOf(7);
        // B computes BN and sends BN to A
        BigInteger BN = Y.modPow( BX, P );
        
        // A computes the Key
        BigInteger AK = BN.modPow( AX, P );
        System.out.println( "AK: " + AK );
        
        // B computes the key
        BigInteger BK = AN.modPow( BX, P );
        System.out.println( "BK: " + BK );
        
        
    }
    
    
}
