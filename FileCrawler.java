import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileCrawler {
  public static void main(String[] args) {
    System.out.println("What are you looking for?");

    Scanner searchScanner = new Scanner(System.in);
    String keyword = searchScanner.nextLine().toLowerCase();

    searchFile(new File(System.getProperty("user.dir")), keyword);
    searchScanner.close();
  }

  private static void searchFile(File file, String search) {
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      try {
        for (File f : files) {
          searchFile(f, search);
        }
      } catch (Exception e) {
        System.out.println("Error opening folder: " + file.getAbsolutePath());
      }

    } else {
      if (file.isFile()) {
        try {
          Scanner readFileScanner = new Scanner(file);
          while (readFileScanner.hasNextLine()) {
            if (readFileScanner.next().toLowerCase().matches(search)) {
              System.out.println("Yay, found " + search +
                  "! Filepath: " + file.getAbsolutePath());
            }
          }

          readFileScanner.close();
        } catch (FileNotFoundException e) {
          System.out.println("Error opening file: " + file.getAbsolutePath());
        } catch (NoSuchElementException e) {
        }
      }
    }
  }
}