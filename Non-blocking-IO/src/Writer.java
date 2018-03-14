import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Writer{
    private MappedByteBuffer mappedFile;
    private Random random;
    int iterations;

    Writer(MappedByteBuffer mappedFile, int iterations){
        this.mappedFile = mappedFile;
        this.iterations = iterations;
        this.random = new Random();
    }

    public void run(){

        IntBuffer intBuffer = mappedFile.asIntBuffer();

        for (int i = 0; i < iterations; i++){
            if (intBuffer.limit() == 0) writeNumbers(intBuffer);
            else
                switch (intBuffer.get(0)){
                    case 1:
                        sleep();
                        i--;
                        break;
                    case 0:
                        writeNumbers(intBuffer);
                        break;
                }
        }

    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeNumbers(IntBuffer intBuffer) {
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        intBuffer.put(RunningMode.WRITE.getMark()).put(a).put(b).rewind();
        System.out.println(String.format("Write: %d, %d", a, b));
    }
}
