package edu.scu.csen160.lab6;

import java.util.LinkedList;
import java.util.Random;

class Buffer {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void put(int value) throws InterruptedException {
        while (list.size() == CAPACITY) {
            wait();
        }
        list.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (list.isEmpty()) {
            wait();
        }
        int value = list.removeFirst();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    	// Implement a loop that produces a random values to put on the buffer. Then sleep for half a second.
    	Random random = new Random(); 
        try {
            while (true) { // Infinite loop to continuously produce values
                int value = random.nextInt(100); // Generate a random value
                buffer.put(value); // Put the value into the buffer
                Thread.sleep(500); // Sleep for half a second
            }
        } catch (InterruptedException e) {
            System.err.println("Producer interrupted");
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    	// Implement a loop that consumes the next value from the buffer and then sleeps for one second
    	try {
            while (true) { // Infinite loop to continuously consume values
                buffer.get(); // Get the next value from the buffer
                Thread.sleep(1000); // Sleep for one second
            }
        } catch (InterruptedException e) {
            System.err.println("Consumer interrupted");
        }
    }
}

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer = new Producer(buffer);
        Thread consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}