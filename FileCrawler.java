import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileCrawler {

  public static void main(String[] args) throws FileNotFoundException {

    // User input
    Scanner search = new Scanner(System.in);
    System.out.println("What are you looking for?");
    String keyword = search.nextLine();

    // Check file and print result
    Scanner readFile = new Scanner(new FileReader("./text.txt"));
    while (readFile.hasNextLine()) {
      String match = readFile.next();
      if (match.matches(keyword)) {
        System.out.println("Yay, found it!");
      }
    }

    search.close();
    readFile.close();

  }
}