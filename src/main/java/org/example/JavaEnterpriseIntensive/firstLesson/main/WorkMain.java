package org.example.JavaEnterpriseIntensive.firstLesson.main;


import org.example.JavaEnterpriseIntensive.firstLesson.api.AutoPart;
import org.example.JavaEnterpriseIntensive.firstLesson.dto.Door;
import org.example.JavaEnterpriseIntensive.firstLesson.dto.Engine;
import org.example.JavaEnterpriseIntensive.firstLesson.dto.Wheel;

/**
 * its a main class to run program
 */
public class WorkMain {
    /**
     *
     * @param args = Arguments from command line
     */
    public static void main(String[] args) {
        AutoPart[] autoParts = new AutoPart[3];
        autoParts[0] = new Engine("V8", 2);
        autoParts[1] = new Wheel(17, 2);
        autoParts[2] = new Door(2, "Yellow");

        for (AutoPart autoPart : autoParts) {
            System.out.println(autoPart);
        }
    }
}
