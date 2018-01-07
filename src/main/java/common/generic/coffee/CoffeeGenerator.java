package common.generic.coffee;

import java.util.Iterator;
import java.util.Random;

import common.generic.Generator;

/**
 * @author shuwei
 * @version 创建时间：2017年12月15日 上午9:53:00
 * 类说明
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class};
    private static Random rand = new Random(47);
    
    public CoffeeGenerator() {}
    // For iteration
    private int size = 0;
    
    public CoffeeGenerator (int sz) {
        size = sz;
    }
    
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        System.out.println("--------------");
        for(Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
            System.out.println("==");
        }
    }
}
