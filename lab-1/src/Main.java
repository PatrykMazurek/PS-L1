import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Thread th1 = new Thread(new Runnable() {
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
        });
//        th1.start();

//        new Thread(new RunnableExample()).start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureList = new ArrayList<>();

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        int taskNumber = 0;
        int task = 20;
        while (threadPool.getActiveCount() < 5){
            if (taskNumber < task){
                futureList.add( threadPool.submit(new CallableExample()));
                taskNumber+=1;
            }
            if (taskNumber == task){
                break;
            }
        }

        try {
            for (Future f : futureList){
                System.out.println(f.get(6000, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        threadPool.shutdown();
        System.out.println("Zakończenie wątka głównego");


    }
}