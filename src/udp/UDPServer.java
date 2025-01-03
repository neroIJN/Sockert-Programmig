package udp; // Defines the package name for this class

import java.io.IOException; // Import for handling input/output exceptions
import java.net.DatagramPacket; // Import for creating and handling UDP packets
import java.net.DatagramSocket; // Import for creating a UDP socket
import java.net.SocketException; // Import for handling exceptions related to socket operations

public class UDPServer { // Define the UDPServer class
    public static void main(String[] args) throws IOException {
        // Main method where program execution begins
        // Declares that the method may throw IOException during execution

        var server = new DatagramSocket(4411);
        // Create a DatagramSocket instance bound to port 4411
        // This socket will listen for incoming UDP packets on the specified port

        System.out.println("Server is running......");
        // Inform the user that the server is running and ready to receive messages

        byte[] reciverBuffer = new byte[256];
        // Create a buffer (byte array) to store the incoming data
        // The buffer size is set to 256 bytes, which determines the maximum message size the server can handle

        var packet = new DatagramPacket(reciverBuffer, reciverBuffer.length);
        // Create a DatagramPacket object to receive data
        // - `reciverBuffer`: The byte array to store the received data
        // - `reciverBuffer.length`: The size of the buffer

        server.receive(packet);
        // Receive the data from the client and store it in the `packet` object
        // This call will block until a packet is received

        String response = new String(packet.getData(), 0, packet.getLength());

        // Convert the received data (bytes) into a string
        // `packet.getData()` retrieves the raw byte data stored in the packet

        System.out.println("Received Data :" + response);
        // Print the received message to the console

        server.close();
        // Close the DatagramSocket to release system resources
        // Note: Closing the socket here will stop the server after handling one message
    }
}
