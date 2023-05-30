package com.example.projectexercise.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadDemo implements Runnable {

    private int startNumber;
    private int endNumber;
    private int threadId;
    private int totalThreads;
    private static int count = 1;

    public ThreadDemo(int startNumber, int endNumber, int threadId, int totalThreads) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.threadId = threadId;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        synchronized (ThreadDemo.class) {
            while (count <= 75) {
                if (count >= startNumber && count <= endNumber) {
                    System.out.println("Thread " + threadId + ": " + count);
                    count++;
                    ThreadDemo.class.notifyAll();
                } else {
                    try {
                        ThreadDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ThreadDemo.class.notifyAll();
        }
    }

    public static void main(String[] args) {
//        ThreadDemo thread1 = new ThreadDemo(1, 5, 1, 3);
//        ThreadDemo thread2 = new ThreadDemo(6, 10, 2, 3);
//        ThreadDemo thread3 = new ThreadDemo(11, 15, 3, 3);
//
//        Thread t1 = new Thread(thread1);
//        Thread t2 = new Thread(thread2);
//        Thread t3 = new Thread(thread3);
//
//        t1.start();
//        t2.start();
//        t3.start();
        List<Integer> numss=new ArrayList<>();
        numss.add(1);
        numss.add(2);
        numss.add(3);
        numss.add(7);
        List<Integer> nums = findTwoNumbers(numss,8);
        System.out.println(nums);
    }
    public static List<Integer> findTwoNumbers(List<Integer> nums, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> a=new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if (map.containsKey(complement)) {
                a.add(complement);
                a.add(nums.get(i));
                return a;
            }
            map.put(nums.get(i), i);
        }
        return null;
    }
}

