import java.io.IOException;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;

public class Reader {

    private MappedByteBuffer _buffer;

    public Reader(MappedByteBuffer buffer) {
        _buffer = buffer;
    }

    public void run() throws IOException {

      IntBuffer intBuffer = _buffer.asIntBuffer();

        while (true) {
            switch (intBuffer.get(0)){
                case 1:
                    sum(intBuffer);
                    break;
                case 0:
                    sleep();
                    break;
            }
        }

    }

    private void sum(IntBuffer intBuffer) {
        intBuffer.get();
        int a = intBuffer.get();
        int b = intBuffer.get();
        System.out.println(String.format("Read: %d + %d = %d", a, b, a + b));
        intBuffer.rewind();
        intBuffer.put(RunningMode.READ.getMark());
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
