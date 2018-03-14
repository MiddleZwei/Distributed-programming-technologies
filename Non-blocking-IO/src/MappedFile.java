import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFile {

    private MappedByteBuffer _buffer;

    MappedFile(File file, RunningMode mode) throws Exception {
//        System.out.println(mode);
        try {
            if (mode == RunningMode.WRITE)
                file.delete();
            else if (!file.canRead() || !file.canWrite() || !file.exists())
                throw new Exception("File either does not allow to r/w or doesn't exist");
//            _file = new RandomAccessFile(file, "rw");
//            FileChannel fileChannel = _file.getChannel();
//            _buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);
            _buffer = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MappedByteBuffer getMappedBuffer(){
        return _buffer;
    }
}
