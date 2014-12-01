/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.nio.ByteOrder;

/**
 * http://stackoverflow.com/questions/9431526/find-endianness-of-system-in-java
 *
 * @author Garden
 */
public class Endianness {

    public static void main(String[] args) {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }
    }
}
