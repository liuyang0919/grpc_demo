package com.test.test;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    int[] arr = {1, 2, 3, 4, 5, 6,7, 2, 3, 4, 5, 6,7, 2, 3, 4, 5, 6,7, 2, 3, 4, 5, 6,7, 2, 3, 4, 5, 6,7};

    @Test
    public void test1() {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Ttt ttt = new Ttt();

        Thread thread1, thread2, thread3;
        thread1 = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    condition.await();
                    if(ttt.getIndex() >= arr.length){
                        break;
                    }
                    ttt(ttt);
                    condition1.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread2 = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    condition1.await();
                    if(ttt.getIndex() >= arr.length){
                        break;
                    }
                    ttt(ttt);
                    condition2.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread3 = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    condition2.await();
                    if(ttt.getIndex() >= arr.length){
                        break;
                    }
                    ttt(ttt);
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread1.setName("0");
        thread2.setName("1");
        thread3.setName("2");

        thread1.start();
        thread2.start();
        thread3.start();

        new Thread(() -> {
            lock.lock();
            condition.signalAll();
            lock.unlock();
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void ttt(Ttt ttt) {
        System.out.println(System.currentTimeMillis() + "---" + Thread.currentThread().getName() + "-----------" + arr[ttt.getIndex()]);
        ttt.setIndex();
    }

    class Ttt {
        private int index = 0;

        public void setIndex() {
            this.index += 1;
        }

        public int getIndex() {
            return this.index;
        }
    }


}
