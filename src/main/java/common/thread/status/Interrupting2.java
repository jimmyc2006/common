package common.thread.status;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shuwei
 * @version 创建时间：2017年12月14日 下午5:34:42
 * 使用ReentrantLock处理线程阻塞的问题
 */
class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }
    
    public void f() {
        try {
            lock.lockInterruptibly();
            System.out.println(">>lock acquired in f()");
        } catch(InterruptedException e) {
            System.out.println("interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();
    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }}

public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t. interrupt()");
        t.interrupt();
    }
}
