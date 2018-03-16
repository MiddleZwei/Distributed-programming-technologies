import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;

public class Main extends Thread {


    private static final File FILE =  new File("file.dat");
    private static final int ITERATIONS = 3;

    private static MappedByteBuffer _buffer;


    public static void main(String[] args) throws Exception {

        RunningMode mode;
        if (args.length == 0) throw new NullPointerException("No mode specified.");
        else mode = RunningMode.getMode(args[0]);

        MappedFile mappedFile;
            switch (mode) {
                case READ:
                    mappedFile = new MappedFile(FILE, RunningMode.READ);
                    _buffer = mappedFile.getMappedBuffer();
                    read();
                    break;
                case WRITE:
                    mappedFile = new MappedFile(FILE, RunningMode.WRITE);
                    _buffer = mappedFile.getMappedBuffer();
                    write(ITERATIONS);
                    break;
                case EXIT:
                    throw new IllegalArgumentException("Wrong mode. Application exits.");
            }


    }


    private static void write(int iterations) {
        new Writer(_buffer, iterations).run();

    }


    private static void read() {
        new Reader(_buffer).run();
    }

}



