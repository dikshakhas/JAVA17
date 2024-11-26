import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BadJavaCodeExample {

    private static List<String> largeList = new ArrayList<>();

    public static void main(String[] args) {
        // Memory Leak Example: Unnecessary holding of references in a static list
        createMemoryLeak();

        // Poor Resource Utilization: File input stream not properly closed
        readFileWithoutClosing();

        // Null Pointer Exception Example: Dereferencing null object
        dereferenceNullPointer();
    }

    // Memory Leak Example
    public static void createMemoryLeak() {
        // Adding a large number of strings to a static list
        for (int i = 0; i < 1000000; i++) {
            largeList.add("String number: " + i);  // Holding unnecessary references in a static list
        }
        // The largeList will never be cleared and keeps holding onto memory even after the method completes.
        // This can lead to a memory leak if the program runs for a long time or keeps accumulating large data.
    }

    // Poor Resource Utilization Example
    public static void readFileWithoutClosing() {
        FileInputStream fis = null;
        try {
            // Opening a file input stream without closing it
            File file = new File("somefile.txt");
            fis = new FileInputStream(file);
            int data;
            while ((data = fis.read()) != -1) {
                // Read data from file
            }
            // fis.close() is missing here, leading to resource leak.
            // File input stream should be closed in a finally block or try-with-resources to prevent resource leak.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Null Pointer Exception Example
    public static void dereferenceNullPointer() {
        String str = null;
        // This will throw a NullPointerException because we are trying to call a method on a null object
        int length = str.length();  // NullPointerException will be thrown here
        System.out.println("Length of string: " + length);
    }
}
