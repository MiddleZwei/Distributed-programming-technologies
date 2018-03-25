package com.illia.halych.entities;

import com.illia.halych.protocols.Mode;
import com.illia.halych.protocols.IProtocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {
    private static ServerSocketChannel _serverChannel;
    private Selector _selector;
    private IProtocol _protocol;
    private SelectionKey _serverKey;
    private final static int PORT = 1111;



    private NIOServer(int port, IProtocol protocol){
        try {
            _serverChannel = ServerSocketChannel.open();
            _serverChannel.configureBlocking(false);
            InetAddress hostIP = InetAddress.getLocalHost();
            SocketAddress address = new InetSocketAddress(hostIP, port);
            _serverChannel.socket().bind(address);
            _selector = Selector.open();
            _serverKey =_serverChannel.register(_selector, SelectionKey.OP_ACCEPT);
            _protocol = protocol;
            System.out.println("Connected to "+_serverChannel.getLocalAddress());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {

            String mode = args[0];
            IProtocol protocol = Mode.getProtocol(mode);
            NIOServer server = new NIOServer(PORT, protocol); // port++ is just a new port
            server.handleIncomingConnections();

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    private void handleIncomingConnections() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Mode.BUFFER_SIZE);
        while (true){

            _selector.select();
            Iterator<SelectionKey> iterator = _selector.selectedKeys().iterator();

            while (iterator.hasNext()){
                SelectionKey key = getKey(iterator);
                if (key == _serverKey && key.isAcceptable()){

                    SocketChannel clientChannel = _serverChannel.accept();
                    clientChannel.register(_selector, SelectionKey.OP_READ);

                } else if (key != _serverKey && key.isReadable()){

                    byteBuffer.clear();
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.read(byteBuffer); // read the request from the client
                    byteBuffer.flip();
                    String request = new String(byteBuffer.array(), 0, byteBuffer.limit());
                    String response = _protocol.processRequest(request); // process request
                    byteBuffer.put(response.getBytes());
                    byteBuffer.flip();
                    channel.write(byteBuffer); // send the response to the client
                    channel.close();

                } else if (key != _serverKey && key.isWritable()){}

            }

        }
    }
    private SelectionKey getKey(Iterator<SelectionKey> iterator) {
        SelectionKey key = iterator.next();
        iterator.remove();
        return key;
    }




}