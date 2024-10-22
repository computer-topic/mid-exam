public class wordCount {
  private int lineCount = 0;
  private int charCount = 0;
  private int wordCount = 0;

  public static void main(String[] args) {
    BufferedReader inputReader;
    String line;

    inputReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      line = inputReader.readLine();
      while (line != null) {
        calculateCounts(line);
        line = inputReader.readLine();
      }
      printCounts(wordCount, lineCount, charCount)
    } catch (IOException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  private void calculateCounts(String line) {
    lineCount++;
    charCount += line.length();
    wordCount = countWords(line, wordCount);
  }

  private int countWords(String line, int wordCount) {
    String words[] = line.split("\\W");
    return wordCount + words.length;
  }

  private void printCounts(int wordCount, int lineCount, int charCount) {
    System.out.println("wordCount = " + wordCount);
    System.out.println("lineCount = " + lineCount);
    System.out.println("charCount = " + charCount);
  }
}