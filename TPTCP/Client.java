import java.io.*;
import java.net.*;
import java.net.InetAddress;
class Client {
    public static void main(String args[]) {
        //data is taken as command line argument
        String ipAddress = "localhost";
        int portNumber = 123;
        String request = "test #";
        // # acts as a terminator
        try {
            Socket socket = new Socket(ipAddress, portNumber);
            // Socket is initialized and attempt is made for connecting to the server
            // Declaring other properties and streams
            OutputStream outputStream;
            OutputStreamWriter outputStreamWriter;
            InputStream inputStream;
            InputStreamReader inputStreamReader;
            StringBuffer stringBuffer;
            String response;
            int x;
            // retrieving output Stream and its writer, for sending request or acknowledgement
            outputStream = socket.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(request);
            outputStreamWriter.flush(); // request is sent
            // retrieving input stream and its reader, for receiving    acknowledgement or response
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            stringBuffer = new StringBuffer();
            while (true) {
                x = inputStreamReader.read();
                if (x == '#' || x == -1) break; // reads till the terminator 
                stringBuffer.append((char) x);
            }
            response = stringBuffer.toString();
            System.out.println(response);
            socket.close(); //closing the connection
        } catch (Exception exception) {
            // Raised in case, connection is refused or some other technical issue
            System.out.println(exception);
        }
    }
}