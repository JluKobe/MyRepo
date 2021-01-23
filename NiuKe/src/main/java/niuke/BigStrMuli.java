package niuke;

import java.math.BigInteger;

/**
 * 大数乘法
 */
public class BigStrMuli {
    public String solve (String s, String t) {
        BigInteger b1 = new BigInteger(s);
        BigInteger b2 = new BigInteger(t);
        BigInteger b3 = b1.multiply(b2);

        return b3.toString();
    }
}
