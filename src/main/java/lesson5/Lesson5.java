package lesson5;

import java.util.Arrays;

public class Lesson5 {
    private static final int ARRAY_SIZE = 10000000;

    public static void main(String[] args) {
        System.out.println("Run Method 1:");
        checkExecTime();
        System.out.println("Run Method 2:");
        checkExecTimeOnTwoThreads();
    }

    private static void checkExecTime() {
        float[] array = new float[ARRAY_SIZE];
        Arrays.fill(array, 1.0f);

        long startExecTime = System.currentTimeMillis();
        computeValues(array);
        System.out.printf("Execution time: %d \n", System.currentTimeMillis() - startExecTime);
    }

    private static void checkExecTimeOnTwoThreads() {
        float[] array = new float[ARRAY_SIZE];
        Arrays.fill(array, 1.0f);
        int halfArraySize = array.length / 2;

        float[] array1 = new float[halfArraySize];
        float[] array2 = new float[halfArraySize];
        long startExecTime = System.currentTimeMillis();

        System.arraycopy(array, 0, array1, 0, halfArraySize);
        System.out.printf("Create Array 1 Execution time: %d \n", System.currentTimeMillis() - startExecTime);

        long startCreateArray2Time = System.currentTimeMillis();
        System.arraycopy(array, halfArraySize, array2, 0, halfArraySize);
        System.out.printf("Create Array 2 Execution time: %d \n", System.currentTimeMillis() - startCreateArray2Time);

        Thread thread1 = new Thread(() -> computeValues(array1), "Thread 1");
        Thread thread2 = new Thread(() -> computeValues(array2), "Thread 2");

        long startComputeOntThread1Time = System.currentTimeMillis();
        thread1.start();
        long startComputeOntThread2Time = System.currentTimeMillis();
        thread2.start();

        try {
            thread1.join();
            System.out.printf("Execution Thread 1 time: %d \n", System.currentTimeMillis() - startComputeOntThread1Time);

            thread2.join();
            System.out.printf("Execution Thread 2 time: %d \n", System.currentTimeMillis() - startComputeOntThread2Time);

        }
        catch (InterruptedException ignore) {
        }

        long startCreateResultArray = System.currentTimeMillis();
        System.arraycopy(array1, 0, array, 0, halfArraySize);
        System.arraycopy(array2, 0, array, halfArraySize, halfArraySize);

        System.out.printf("Create result Array time: %d \n", System.currentTimeMillis() - startCreateResultArray);
        System.out.printf("All Execution time: %d \n", System.currentTimeMillis() - startExecTime);
    }

    private static void computeValues(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
    }
}
