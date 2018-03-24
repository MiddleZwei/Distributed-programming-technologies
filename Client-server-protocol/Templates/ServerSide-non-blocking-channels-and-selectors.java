import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_WRITE;

public class ServerSide-non-blocking-channels-and-selectors {

    public static void main(String[] args) throws IOException {
        // Creating a server socket channel and binding it to a specific network address (host+port)
        String host = "localhost";
        int port = 8080;
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(host, port));

        // Setting non-blocking mode for server socket channel.
        serverChannel.configureBlocking(false);

        // Instantiating a selector
        Selector selector = Selector.open();

        // Registering a server socket channel with a selector.
        SelectionKey sscKey = serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        // Selection and handling operations ready to perform
        for (;;){
            selector.select();

            Set keys = selector.selectedKeys();

            Iterator iter = keys.iterator();

            while (iter.hasNext()){
                // getting key
                SelectionKey key = (SelectionKey) iter.next();
                iter.remove();

                if (key.isAcceptable()){
                    SocketChannel cc = serverChannel.accept();
                    // non-blocking  channel because it will be registered with selector
                    cc.configureBlocking(false);
                    //register client channel with the same selector
                    cc.register(selector, SelectionKey.OP_READ | OP_WRITE);
                    continue;
                }

                if (key.isReadable()){
                    SocketChannel cc = (SocketChannel) key.channel();
                    // handle client request
                    // .........
                }

                if (key.isWritable()){
                    SocketChannel cc = (SocketChannel) key.channel();
                    // writting to channel
                    // .......
                    continue;
                }
            }

        }

    }

}
