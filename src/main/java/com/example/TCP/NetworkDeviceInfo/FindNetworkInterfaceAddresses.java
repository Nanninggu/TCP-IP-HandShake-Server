package com.example.TCP.NetworkDeviceInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class FindNetworkInterfaceAddresses {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();

            // Check if the interface is up and loopback interface
            if (networkInterface.isUp() && !networkInterface.isLoopback()) {

                System.out.println("Interface: " + networkInterface.getName() + " (" + networkInterface.getDisplayName() + ")");

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();

                    // Filter out non-link-local or loopback addresses
                    if (!address.isLinkLocalAddress() && !address.isLoopbackAddress()) {
                        System.out.println("\tAddress: " + address.getHostAddress());
                    }
                }
            }
        }
    }
}
