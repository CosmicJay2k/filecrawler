import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCrawler {

  public static void main(String[] args) throws FileNotFoundException {

    // User input
    Scanner search = new Scanner(System.in);
    System.out.println("What are you looking for?");
    String keyword = search.nextLine();

    // Check file and print result
    File file = new File("text.txt");
    Scanner readFile = new Scanner(file);
    while (readFile.hasNextLine()) {
      String match = readFile.next();
      if (match.matches(keyword)) {
        System.out.println("Yay, found it! Filepath: " + file.getAbsolutePath());
      }
    }

    // Close scanners
    search.close();
    readFile.close();

  }
}