package com.concurrency;

public class ProducerConsumer {

   private static int[] buffer;
   private static int count ;
  private static Object lock = new Object();


    static class Producer{

    void produce() {

      synchronized (lock) {
        if (count == buffer.length) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[count++] = 1;

        lock.notify();
      }
        }
    }

    static class Consumer{

    static void consume() {

      synchronized (lock) {
        if (count == 0) {

            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[--count] = 0;
        lock.notify();
      }
        }
    }

  public static void main(String[] args) throws InterruptedException {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        buffer = new int[10];
        count = 0;

        Runnable produceTask =()->{
            for (int i=0;i<50;i++){
                producer.produce();

            }
            System.out.println("Production completed");
        };

        Runnable consumeTask = ()-> {

            for (int i=0;i<50;i++){

                Consumer.consume();
            }

            System.out.println("Consumtion is completed");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        System.out.println("producerThread state is : "+producerThread.getState());
        producerThread.start();
      System.out.println("producerThread state is : "+producerThread.getState());

      consumerThread.start();

        producerThread.join();
      System.out.println("producerThread state is : "+producerThread.getState());

      consumerThread.join();

      System.out.println("Data in buffer = "+ count);
  }
  }
