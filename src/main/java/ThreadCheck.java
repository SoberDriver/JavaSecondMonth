public class ThreadCheck {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();


    }

    public  static  void firstMethod(){
    float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - a));
    }


    public  static  void secondMethod() throws InterruptedException {
    float[] arr  = new float[SIZE];
    float[] arr1 = new float[HALF];
    float[] arr2 = new float[HALF];

    for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
    long a = System.currentTimeMillis();

    Thread thread = new Thread(() -> {
        System.arraycopy(arr, 0, arr1, 0, HALF );
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(arr1, 0, arr, 0, HALF);
    });

    Thread thread1 = new Thread(() -> {
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(arr2, 0, arr, HALF, HALF);
    });
    thread.start();
    thread1.start();
    thread.join();
    thread1.join();

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - a));
    }
}
