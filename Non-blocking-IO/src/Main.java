import com.sun.org.omg.CORBA.OperationMode;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main extends Thread {

    private static final int SLEEPTIME = 1000;
    private static final File FILE =  new File("file.dat");
    private static final String FILEPATH = "file.dat";
    private static final Random RANDOM = new Random();
    private static final int BUFFER_SIZE = 1024;
    private static final int CONTINUE = 1;
    private static final int STOP = -1;
    private static final int ITERATIONS = 10;

    private static MappedByteBuffer _buffer;


    public static void main(String[] args) throws Exception {
        RunningMode mode = RunningMode.getMode(args[0]);
        MappedFile mappedFile;

        switch (mode){
            case READ:
//                System.out.println(mode);
                mappedFile = new MappedFile(FILE, RunningMode.READ);
                _buffer = mappedFile.getMappedBuffer();
                read();
                break;
            case WRITE:
//                System.out.println(mode);
                mappedFile = new MappedFile(FILE, RunningMode.WRITE);
                _buffer = mappedFile.getMappedBuffer();
                write(ITERATIONS);
        }


    }


    private static void write(int iterations) {
        new Writer(_buffer, iterations).run();

    }


    private static void read() throws IOException { //add filepath
        new Reader(_buffer).run();
    }

}



