import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileCrawler {
  public static void main(String[] args) {
    System.out.println("What are you looking for?"); // Print user prompt.

    Scanner searchScanner = new Scanner(System.in); // Initialize Scanner for user input.
    String keyword = searchScanner.nextLine().toLowerCase(); // Users chosen input (broken out for readability).

    searchFile(new File(System.getProperty("user.dir")), keyword); // Initialize File and run method for searching.
    searchScanner.close(); // Close scanner after method is done.
  }

  private static void searchFile(File file, String search) { // Search method that takes a path and a search keyword.
    if (file.isDirectory()) { // If path is a directory
      File[] files = file.listFiles(); // Create array from files in directory.
      try {
        for (File f : files) { // For each file in array
          searchFile(f, search); // Run search method recursively.
        }
      } catch (Exception e) { // Handle all exceptions.
        System.out.println("Error opening folder: " + file.getAbsolutePath()); // Print error message and path.
      }

    } else {
      if (file.isFile()) { // If path is a file
        try {
          Scanner readFileScanner = new Scanner(file); // Initialize Scanner for looking in file.
          while (readFileScanner.hasNextLine()) { // Iterate through the file.
            if (readFileScanner.next().toLowerCase().matches(search)) { // If a word in the file matches search keyword
              System.out.println("Yay, found " + search +
                  "! Filepath: " + file.getAbsolutePath()); // Print success message and path.
            }
          }

          readFileScanner.close(); // Close scanner after file has been iterated through.
        } catch (FileNotFoundException e) { // Handle file not existing or cannot be opened.
          System.out.println("Error opening file: " + file.getAbsolutePath()); // Print error message and path.
        } catch (NoSuchElementException e) { // Handle file not containing search keyword.
        }
      }
    }
  }
}