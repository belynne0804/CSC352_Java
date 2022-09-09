import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIOExamples {

    static class EscapeCharDemo {
        public static void main(String[] args) {
            // \n causes a new line:
            System.out.println("First line\nSecond line!");

            // \t inserts a tab, i.e. a small block of whitespace.
            System.out.println("This will be separated from\tThis with a tab!");

            // Use \" to write " and \' to write '
            System.out.println("Then Chuck said, \"It\'s above the table\".");

            // To print a slash
            System.out.println("\\ wears a top hat!");
        }
    }
    static class ReaderDemo {
        public static void main(String[] args) throws IOException {
            FileReader inputStream = null;
            FileWriter outputStream = null;

            try {
                inputStream = new FileReader("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/ozymandius.txt");
                outputStream = new FileWriter("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/ozymandius_output.txt");

                int c;
                while ((c = inputStream.read()) != -1) {
                    outputStream.write(c);
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }


    static class ScanSumOzy {
        public static void main(String[] args) throws IOException {
            Scanner myScan = null;
            double sum = 0.0;
            try {
                myScan = new Scanner(
                        new BufferedReader(
                                new FileReader("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/numbersToAdd.txt")
                        )
                );

                while (myScan.hasNext()) {
                    if (myScan.hasNextDouble()) {
                        sum += myScan.nextDouble();
                    } else {
                        myScan.next();
                    }
                }
            } finally {
                myScan.close();
            }

            System.out.println(sum);
        }
    }

    static class ScanOzy {
        public static void main(String[] args) throws IOException {
            Scanner s = null;
            try {
                s = new Scanner(new BufferedReader(new FileReader("/Users/amydixon/Documents/GitHub/CSC352-Language-Study-Java-RMC-Fall-2022/Palindrome/SelectionSort/Week4FIleIO/FileIO/src/ozymandius.txt")));

                while (s.hasNext()) {
                    System.out.println(s.next());
                }
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }
    }

    static class SerializationDemo_Animal implements Serializable {
        // Member variables
        float height;
        String name;
        boolean extinct;
        // Constructor
        public SerializationDemo_Animal(String name, float height, boolean extinct) {
            this.name = name;
            this.height = height;
            this.extinct = extinct;
        }
        // Output method
        public void print() {
            System.out.println("Name: " + name + "\n" +
                    "Height: " + height + "\n" +
                    "Extinct: " + extinct + "\n");
        }

        public static void main(String[] args) throws FileNotFoundException, IOException {

            // Create some animals from our Serializable class:
            SerializationDemo_Animal stego = new SerializationDemo_Animal("Stegosaurus", 12.5f, true);
            SerializationDemo_Animal croc = new SerializationDemo_Animal("Crocodile", 3.2f, false);

            stego.print();
            croc.print();

            // Specify the name of our file:
            File file = new File("animals.dat");

            // Create a FileOutputStream for writing to the file.
            FileOutputStream fileOutput = new FileOutputStream(file);
            // Create object output stream to write serialized objects to the file stream:
            ObjectOutputStream objectOutput = new
                    ObjectOutputStream(fileOutput);
            // Write our objects to the stream:
            objectOutput.writeObject(stego);
            objectOutput.writeObject(croc);

            // Close the streams:
            objectOutput.close();
            fileOutput.close();
        }
    }

    static class StringTokenizerDemo {
        public static void main(String[] args) {
            StringTokenizer st = new StringTokenizer("Java is cool"," ");
            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }
        }
    }

}

