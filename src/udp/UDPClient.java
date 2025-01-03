package udp; // Defines the package name for the code

import java.io.IOException; // Import the IOException class for handling input/output exceptions
import java.net.DatagramPacket; // Import the DatagramPacket class for creating and handling data packets
import java.net.DatagramSocket; // Import the DatagramSocket class for sending and receiving packets
import java.net.InetAddress; // Import the InetAddress class for handling IP addresses

public class UDPClient { // Define the UDPClient class
    public static void main(String[] args) throws IOException {
        // Main method where program execution begins
        // Declares that the method may throw IOException during execution

        var client = new DatagramSocket();
        // Create a DatagramSocket instance to act as the client for sending UDP packets

        var ipAdress = InetAddress.getLocalHost();
        // Get the local host IP address (the address of the machine running this code)

        String str = "Hello World";
        // Create a string message to be sent

        byte[] buf = str.getBytes();
        // Convert the string message into a byte array to send as a UDP packet
        // UDP packets transmit raw bytes, not text directly

        var pac = new DatagramPacket(buf, buf.length, ipAdress, 4411);
        // Create a DatagramPacket with:
        // - `buf`: The byte array containing the message
        // - `buf.length`: The length of the byte array
        // - `ipAdress`: The destination IP address (local machine in this case)
        // - `4411`: The destination port number for the packet

        client.send(pac);
        // Use the DatagramSocket `client` to send the DatagramPacket `pac`

        // Note: This code does not close the DatagramSocket or handle responses from the server.
    }
}
