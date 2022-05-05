package htwz.tuling;

import java.util.Arrays;

/**
 * 使用埃塞法寻找素数
 *
 * @author : wangyu
 * @since :  2021/9/25 7:49
 */
public class PrimeSolution {

    public static void main(String[] args) {
        int prime = 100;
        boolean[] primes = primeSolution(prime);
        System.out.println(Arrays.toString(primes));
    }

    /**
     * primeFlag true表示不是素数，false表示是素数，
     * 如果一个数是素数，那么该数乘以将该数进行倍增，得到的结果一定不是素数，比如2是素数，2*3,2*4...得到的结果都不是素数
     *
     * @param prime 素数
     * @return
     */
    private static boolean[] primeSolution(int prime) {
        boolean[] primeFlag = new boolean[prime];
        for (int i = 2; i <= primeFlag.length; i++) {
            int j = 2;
            if (!primeFlag[i] && isPrime(i)) {
                while (i * j < prime) {
                    primeFlag[i * j] = true;
                    j++;
                }
            }
        }
        return primeFlag;
    }

    private static boolean isPrime(int prime) {
        return false;
    }
}
