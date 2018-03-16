import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFile {

    private static final int BUFFER_SIZE = 1024;
    private MappedByteBuffer _buffer;

    MappedFile(File file, RunningMode mode) throws Exception {
        try {
            if (mode == RunningMode.WRITE)
                file.delete();
            else if (!file.canRead() || !file.canWrite() || !file.exists())
                throw new Exception("File either does not allow to r/w or doesn't exist");

            _buffer = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MappedByteBuffer getMappedBuffer(){
        return _buffer;
    }
}
