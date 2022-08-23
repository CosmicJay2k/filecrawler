import java.util.Scanner;

public class FileCrawler {

  public static void main(String[] args) {

    Scanner search = new Scanner(System.in);

    System.out.println("What are you looking for?");

    String keyword = search.nextLine();

    System.out.println("Looking for " + keyword);

  }
}