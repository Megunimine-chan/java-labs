import java.util.List;

public class IterationalThread extends Thread{

    private final int iterations;
    private final List<Float> partialAnswers;

    public IterationalThread(float iterations, List<Float> answer) {
        this.iterations = (int)iterations;
        this.partialAnswers = answer;
    }

    @Override
    public void run(){
        float amountInsideCircle = 0f;
        for (int i = 0; i <= iterations; i++) {
            double x = Math.random();
            double y = Math.random();

            double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            if (c <= 1) {
                amountInsideCircle++;
            }
        }

        synchronized (partialAnswers) {
            partialAnswers.add(amountInsideCircle);
        }
    }
}
