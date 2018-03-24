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
    private IProtocol _protocol;
    private ByteBuffer _byteBuffer;
    private SocketChannel _channel;



    public NIOClient(String host, int port, IProtocol protocol) {
        try {
            _channel = SocketChannel.open();
            SocketAddress address = new InetSocketAddress(host, port);
            _channel.configureBlocking(false);
            _channel.connect(address);
//            System.out.println("Connecting...");
//            while (!_channel.finishConnect()){
//                System.out.println("----");
//            }
            _byteBuffer = ByteBuffer.allocate(Commons.BUFFER_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        try {
            String mode = args[0];
            IProtocol protocol = Commons.getProtocol(mode);
            NIOClient client = new NIOClient(HOST, Commons.PORT, protocol);
            String[] arguments = new String[args.length - 1];
            for (int i = 1; i < args.length; i++)
                arguments[i - 1] = args[i];
            IRequest request = getRequest(mode, arguments); // get request from arguments
            IResponse response = client.doRequestResponseConversation(request); // process request to send
            System.out.println("response: " + response.toString()); // output given result
            client.close(); // close the connection
        } catch (Exception e){
            e.printStackTrace();
        }


//        InetSocketAddress address = new InetSocketAddress("localhost", 1111);
//        SocketChannel client = SocketChannel.open(address);
//
//        log("Connecting to Server on port 1111...");
//
//        // SHOULD BE CHANGED
//        ArrayList<String> companyDetails = new ArrayList<String>();
//        companyDetails.add("Facebook");
//        companyDetails.add("Twitter");
//        companyDetails.add("IBM");
//        companyDetails.add("Google");
//        companyDetails.add("Crunchify");
//        for (String companyName : companyDetails) {
//
//            byte[] message = new String(companyName).getBytes();
//            ByteBuffer buffer = ByteBuffer.wrap(message);
//            client.write(buffer);
//
//            log("sending: " + companyName);
//            buffer.clear();
//
//            // wait for 2 seconds before sending next message
//            Thread.sleep(2000);
//        }
//        client.close();
    }



    private void close() {
        try {
            _channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private IResponse doRequestResponseConversation(IRequest request) {
        try {
            _byteBuffer.put(request.toString().getBytes()); // put request into a buffer
            _byteBuffer.flip();
            _channel.write(_byteBuffer); // write to the channel to be read by server
            _byteBuffer.clear();
            _channel.read(_byteBuffer);
            _byteBuffer.flip();
            String input = new String(_byteBuffer.array(), 0, _byteBuffer.limit());
            IResponse response = _protocol.deserializeResponse(input);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
    private static IRequest getRequest(String mode, String[] arguments) throws IllegalAccessException, InstantiationException {
        try {
            IRequest request = null;
            switch (mode) {

                case Commons.MODE_ADD:
                    int a = Integer.parseInt(arguments[0]);
                    int b = Integer.parseInt(arguments[1]);
                    request = new AddRequest(a, b);
                    break;
                case Commons.MODE_ECHO:
                    StringBuffer buffer = new StringBuffer();
                    for (String arg : arguments) {
                        buffer.append(arg)
                                .append(" ");
                    }
                    request = new EchoRequest(buffer.toString());
                    break;
            }
            return request;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
