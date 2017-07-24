package chapter1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午5:12:10
 * 类说明
 */
public class PrimeTest {
    
    @Test
    public void testIsPrime() {
        assertEquals(true, Prime.isPrime(2));
        assertEquals(true, Prime.isPrime(3));
        assertEquals(true, Prime.isPrime(53));
        assertEquals(true, Prime.isPrime(193));
        assertEquals(true, Prime.isPrime(521));
        assertEquals(true, Prime.isPrime(809));
        assertEquals(true, Prime.isPrime(1009));
        assertEquals(true, Prime.isPrime(1543));
        assertEquals(false, Prime.isPrime(1541));
        assertEquals(false, Prime.isPrime(657));
        assertEquals(false, Prime.isPrime(111));
    }
    @Test
    public void testIsPrimeFermat() {
        assertEquals(true, Prime.isPrimeFermat(2));
        assertEquals(true, Prime.isPrimeFermat(3));
        assertEquals(true, Prime.isPrimeFermat(53));
        assertEquals(true, Prime.isPrimeFermat(193));
        assertEquals(true, Prime.isPrimeFermat(521));
        assertEquals(true, Prime.isPrimeFermat(809));
        assertEquals(true, Prime.isPrimeFermat(1009));
        assertEquals(true, Prime.isPrimeFermat(1543));
        assertEquals(false, Prime.isPrimeFermat(1541));
        assertEquals(false, Prime.isPrimeFermat(657));
        assertEquals(false, Prime.isPrimeFermat(111));
    }
    
    @Test
    public void testIsPrimeBook() {
        assertEquals(true, Prime.isPrimeBook(2));
        assertEquals(true, Prime.isPrimeBook(3));
        assertEquals(true, Prime.isPrimeBook(53));
        assertEquals(true, Prime.isPrimeBook(193));
        assertEquals(true, Prime.isPrimeBook(521));
        assertEquals(true, Prime.isPrimeBook(809));
        assertEquals(true, Prime.isPrimeBook(1009));
        assertEquals(true, Prime.isPrimeBook(1543));
        assertEquals(false, Prime.isPrimeBook(1541));
        assertEquals(false, Prime.isPrimeBook(657));
        assertEquals(false, Prime.isPrimeBook(111));
    }
    
    @Test
    public void testCheck() {
        assertEquals(true, Prime.check(2, 3));
        assertEquals(true, Prime.check(3, 5));
        
    }
}
