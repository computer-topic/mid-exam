public class WordCounter {
  private int lineCount;
  private int charCount;
  private int wordCount;

  public static void main(String[] args) {
    WordCounter wordCount = new WordCounter();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    initialzeCountVariables();
    try {
      wordCount.calculateCountVariables(input);
      wordCount.printCountVariables();
    }
    catch (IOException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  private void initialzeCountVariables() {
    lineCount = 0;
    charCount = 0;
    wordCount = 0;
  }

  private void calculateCountVariables(BufferedReader input) {
    String line;

    while ((line = in.readLine()) != null) {
      lineCount++;
      charCount += line.length();
      String words[] = line.split("\\W");
      wordCount += words.length;
    }
  }

  private void printCountVariables() {
    System.out.println("wordCount = " + wordCount);
    System.out.println("lineCount = " + lineCount);
    System.out.println("charCount = " + charCount);
  }
}