public class RunnableExample implements Runnable{

    public RunnableExample(){
        System.out.println("Uruchamiam klasę z wątkiem Runnable");
    }

    @Override
    public void run() {
        System.out.println("Rozpoczynam pracę ");
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<5; i++){
            System.out.println("number: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
