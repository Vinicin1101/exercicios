import java.io.*;
import java.util.Scanner;
import java.util.stream.*;
import java.nio.file.*;

public class App {
    public static void main(String args[]) {

        // Leitura com BufferedReader
        String fileBuffer = "buffer.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileBuffer))) {
            System.out.println("Dados lidos com BufferRead");

            String line;

            // leitura de linha por linha
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            // Tratamento de exceção
            System.out.println("Ops!! Algo deu errado :/");
            e.printStackTrace();
        }

        // Leitura com Stream
        String fileStream = "stream.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileStream))) {
            System.out.println("\n");
            System.out.println("Dados lidos com BufferRead");

            // leitura de linha por linha com ForEach e Method Reference.
            stream.forEach(System.out::println);
        } catch (Exception e) {
            // Tratamento de exceção
            System.out.println("Ops!! Algo deu errado :/");
            e.printStackTrace();
        }

        // Leitura com Scanner
        File fileScan = new File("scan.txt");

        Scanner scan;
        try {
            scan = new Scanner(fileScan);

            // leitura de linha por linha
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Tratamento de exceção
            System.out.println("Ops!! Algo deu errado :/");
            e.printStackTrace();
        }
        
    }
}