import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private Random r;

    public RSA() {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public RSA(BigInteger e, BigInteger d, BigInteger n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }

    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, n).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, n).toByteArray();
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        String message = "Hello, World!";
        byte[] encrypted = rsa.encrypt(message.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + new String(encrypted));
        System.out.println("Decrypted message: " + new String(decrypted));
    }
}
