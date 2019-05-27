package com.mmn.ms.ali;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class CharArray {
    //题目3：有3个线程和1个公共的字符数组。线程1的功能就是向数组输出A，
    //线程2的功能就是向数组输出l，线程3的功能就是向数组输出i。要求按顺序向数组赋值AliAliAli，Ali的个数为n

    // 计数器
    public static int counter;

    // 字符数组
    public static char[] charArray = {};

    // 数组下标
    public static int index;

    // 同步计数器
    private static CountDownLatch countDown = null;

    // 定义一个锁
    public static ReentrantLock lock = new ReentrantLock();

    public static class A implements Runnable {

        private int base = 0;

        public A(int num) {
            int total = num * 3;
            countDown = new CountDownLatch(total); //初始化同步计数器
            counter = num; //初始化计数器
            charArray = new char[total]; //初始化char数组
        }

        @Override
        public void run() {
            while (base < counter) { //控制while循环的次数
                if (index % 3 == 0) {
                    System.out.println("第" + (base + 1) + "轮抢锁");
                    try {
                        lock.lock();
                        System.out.println("A抢到锁");
                        charArray[index] = 'A';
                        countDown.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("A释放锁");
                        index++;
                        base++;
                        lock.unlock();
                    }
                }
            }
        }

    }

    public static class B implements Runnable {

        private int base = 0;

        @Override
        public void run() {
            while (base < counter) { //控制while循环的次数
                if (index % 3 == 1) {
                    try {
                        lock.lock();
                        System.out.println("B抢到锁");
                        charArray[index] = 'l';
                        countDown.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("B释放锁");
                        index++;
                        base++;
                        lock.unlock();
                    }
                }
            }
        }
    }

    public static class C implements Runnable {

        private int base = 0;

        @Override
        public void run() {
            while (base < counter) { //控制while循环的次数
                if (index % 3 == 2) {
                    try {
                        lock.lock();
                        System.out.println("C抢到锁");
                        charArray[index] = 'i';
                        countDown.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("C释放锁");
                        index++;
                        base++;
                        lock.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("请输入要打印的Ali的数量:");
        Scanner scanner = new Scanner(System.in);

        int inputNum = scanner.nextInt();

        //创建一个定长的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new A(inputNum));
        executorService.submit(new B());
        executorService.submit(new C());

        try {
            //阻塞主线程直至线程池中的线程任务执行完毕
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(charArray);
        executorService.shutdown();
        scanner.close();
    }
}