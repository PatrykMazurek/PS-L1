import java.util.Random;
import java.util.concurrent.Callable;

public class CallableExample  implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int number = 0;
        Random rand = new Random();
        int i =0;
        do{
            number += rand.nextInt(450);
            i += 1;
            System.out.println("losowanie: " + i + " " + Thread.currentThread().getName());
            Thread.sleep(rand.nextInt(500, 1000));
        }while (number < 1250);
        return number;
    }
}
