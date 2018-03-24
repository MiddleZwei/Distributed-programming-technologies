package com.illia.halych.entities;

import com.illia.halych.protocols.Commons;
import com.illia.halych.protocols.IProtocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    private static ServerSocketChannel _serverChannel;
    private Selector _selector;
    private IProtocol _protocol;
    private SelectionKey _serverKey;



    private NIOServer(int port, IProtocol protocol){
        try {
            _serverChannel = ServerSocketChannel.open();
            InetAddress hostIP = InetAddress.getLocalHost();
            SocketAddress address = new InetSocketAddress(hostIP, port);
            _serverChannel
                    .socket()
                    .bind(address);
            _selector = Selector.open();
            _serverKey = register(_serverChannel, SelectionKey.OP_ACCEPT);
            _protocol = protocol;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {

            String mode = args[0];
            IProtocol protocol = Commons.getProtocol(mode);
            NIOServer server = new NIOServer(Commons.PORT+1, protocol); // port++ is just a new port
            server.handleIncomingConnections();

        } catch (Exception e){
            e.printStackTrace();
        }

//        Selector selector = Selector.open(); // selector is open here // Selector: multiplexor of SelectableChannel objects
//
//        ServerSocketChannel socketChannel = ServerSocketChannel.open(); // ServerSocketChannel: selectable channel for stream-oriented listening sockets
//        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 1111);
//
//        socketChannel.bind(socketAddress); // Binds the channel's socket to a local address and configures the socket to listen for connections
//
//        socketChannel.configureBlocking(false); // Adjusts this channel's blocking mode.
//
//        int ops = socketChannel.validOps();
//        SelectionKey selectionKey = socketChannel.register(selector, ops, null);
//
//        // Infinite loop..
//        // Keeps server running
//        while (true) {
//
//            System.out.println("I'm a server and I'm waiting for new connection and buffer select...");
//
//            selector.select(); // Selects a set of keys whose corresponding channels are ready for I/O operations
//
//            Set<SelectionKey> keys = selector.selectedKeys(); // token representing the registration of a SelectableChannel with a Selector
//            Iterator<SelectionKey> iter = keys.iterator();
//
//            while (iter.hasNext()) {
//                SelectionKey key = iter.next();
//
//                // Tests whether this key's channel is ready to accept a new socket connection
//                if (key.isAcceptable()) {
//                    SocketChannel cc = socketChannel.accept();
//
//                    cc.configureBlocking(false); // Adjusts this channel's blocking mode to false
//
//                    cc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_READ); // Operation-set bit for read operations
//                    System.out.println("Connection Accepted: " + cc.getLocalAddress() + "\n");
//
//                    // Tests whether this key's channel is ready for reading
//                } else if (key.isReadable()) {
//
//                    SocketChannel cc = (SocketChannel) key.channel();
//                    ByteBuffer buffer = ByteBuffer.allocate(256);
//                    cc.read(buffer);
//                    String result = new String(buffer.array()).trim();
//
//                    System.out.println("Message received: " + result);
//
//                    if (result.equals("Crunchify")) {
//                        cc.close();
//                        System.out.println("\nIt's time to close connection as we got last company name 'Crunchify'");
//                        System.out.println("\nServer will keep running. Try running client again to establish new connection");
//                    }
//                }
//                iter.remove();
//            }
//        }
    }



    private SelectionKey register(ServerSocketChannel serverChannel, int opAccept) {
        return null;
    }
    private void register(SocketChannel socketChannel, int opRead){

    }
    private void handleIncomingConnections() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Commons.BUFFER_SIZE);
        while (true){

            _selector.select();
            Iterator<SelectionKey> iterator = _selector
                    .selectedKeys()
                    .iterator();

            while (iterator.hasNext()){
                SelectionKey key = key(iterator);
                if (key == _serverKey && key.isAcceptable()){

                    SocketChannel clientChannel = _serverChannel.accept();
                    register(clientChannel, SelectionKey.OP_READ);

                } else if (key != _serverKey && key.isReadable()){

                    byteBuffer.clear();
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.read(byteBuffer); // read the request from the client
                    byteBuffer.flip();
                    String request = new String(byteBuffer.array(), 0, byteBuffer.limit());
                    String response = _protocol.processRequest(request); // process request
                    byteBuffer.put(response.getBytes());
                    byteBuffer.flip();
                    channel.write(byteBuffer); //
                    channel.close();

                } else if (key != _serverKey && key.isWritable())

                    System.out.println("writable");

            }

        }
    }
    private SelectionKey key(Iterator<SelectionKey> iterator) {
        SelectionKey key = iterator.next();
        iterator.remove();
        return key;
    }




}