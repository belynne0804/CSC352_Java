import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LineInverter {

    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(
                    new FileReader("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/ozymandius.txt")
            );

            //make a new list to store the contents of the original file
            ArrayList list = new ArrayList();
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }

            //close your reader
            input.close();

            //use the reverse() method in Collections
            Collections.reverse(list);

            PrintWriter output = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/ozymandius_reverse.txt")
                    )
            );

            //write the reversed list object to a new file
            for (Object o : list) {
                output.println((String) o);
            }

            //close writer
            output.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
