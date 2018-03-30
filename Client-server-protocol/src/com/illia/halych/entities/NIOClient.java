package com.illia.halych.entities;

import com.illia.halych.protocols.*;
import com.illia.halych.protocols.Add.AddRequest;
import com.illia.halych.protocols.Echo.EchoRequest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    private final static String HOST = "localhost";
    private final static int PORT = 1121;
    private IProtocol _protocol;
    private ByteBuffer _byteBuffer;
    private SocketChannel _channel;

    private NIOClient(String host, int port, IProtocol protocol) {
        try {
            _protocol = protocol;
            _channel = SocketChannel.open();

            SocketAddress address = new InetSocketAddress(host, port);
            _channel.bind(address);
            _channel.configureBlocking(false);
            _channel.connect(address);

            ensureConnection(_channel);
            System.out.println("Connected to "+_channel.getLocalAddress());

            _byteBuffer = ByteBuffer.allocate(Mode.BUFFER_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ensureConnection(SocketChannel _channel) throws IOException {
        try {
            System.out.println("Connecting...");
            while(!_channel.finishConnect()){
                System.out.print(".");
            }
        } catch (IOException e) {
            throw new IOException("Connection failed.");
        }
    }

    public static void main(String[] args) {

        try {
            String protocolMode = args[0];

            IProtocol protocol = Mode.getProtocol(protocolMode);
            NIOClient client = new NIOClient(HOST, PORT, protocol);

            String[] arguments = new String[args.length - 1];
            for (int i = 1; i < args.length; i++)
                arguments[i - 1] = args[i];

            IRequest request = getRequest(protocolMode, arguments);
            System.out.print("Request: "+protocolMode+" ");
            for (String arg : arguments) System.out.print(arg+" ");
            System.out.println();

            IResponse response = client.talkToTheServer(request);
            System.out.println("Reply: " + response.toString());

            client.closeConnections();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private IResponse talkToTheServer(IRequest request) {
        try {
            _byteBuffer.put(request.toString().getBytes());
            _byteBuffer.flip();
            _channel.write(_byteBuffer);
            _byteBuffer.clear();
            _channel.read(_byteBuffer);
            _byteBuffer.flip();
            String input = new String(_byteBuffer.array(), 0, _byteBuffer.limit());
            return _protocol.deserializeResponse(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static IRequest getRequest(String mode, String[] arguments) {
        try {
            IRequest request = null;
            switch (mode) {

                case Mode.MODE_ADD:
                    request = new AddRequest(arguments);
                    break;
                case Mode.MODE_ECHO:
                    request = new EchoRequest(arguments);
                    break;
            }
            return request;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private void closeConnections() {
        try {
            _channel.close();
            System.out.printf("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
