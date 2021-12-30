import java.util.ArrayList;
import java.util.List;

public class ParallelMonteCarloPi{

    private final float iters = 10000000f;
    private final List<Float> partialAnswers = new ArrayList<>();

    public void evaluateAndPrintPi(int threads){
        long time = System.nanoTime();
        evaluateMultiThreadAnswer(threads);
        time = System.nanoTime()-time;
        System.out.println("TIME " + time +"ns");
    }

    private void evaluateMultiThreadAnswer(int threads) {

        List<IterationalThread> threadsList = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            IterationalThread thread = new IterationalThread(iters/threads, partialAnswers);
            thread.start();
            threadsList.add(thread);
        }
        try {
            for (IterationalThread thread: threadsList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("PI is " + getPiFromAnswer());
        System.out.println();
        System.out.println("THREADS " + threads);
        System.out.println();
        System.out.println("ITERATIONS " + (int)iters);
        System.out.println();
    }

    private float getPiFromAnswer(){
        return 4*partialAnswers.stream().reduce(0f, Float::sum)/iters;
    }

}
