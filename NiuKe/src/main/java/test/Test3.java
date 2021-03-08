package test;

import java.math.BigInteger;

public class Test3 {

    public String solve (String s, String t) {
        // write code here
        BigInteger bi1 = new BigInteger(s);
        BigInteger bi2 = new BigInteger(t);
        BigInteger result = bi1.add(bi2);

        return result.toString();
    }
}
