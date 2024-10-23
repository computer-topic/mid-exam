public class WordCounter {
  private static int lineCount = 0;
  private static int charCount = 0;
  private static int wordCount = 0;

  public static void main(String[] args) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      calculateCount(bufferedReader);
      printWordCount();
    }
    catch (IOException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  private static void printWordCount() {
    System.out.println("wordCount = " + wordCount);
    System.out.println("lineCount = " + lineCount);
    System.out.println("charCount = " + charCount);
  }

  private static void calculateCount(BufferedReader bufferedReader) {
    String line;

    while ((line = bufferedReader.readLine()) != null) {
      lineCount++;
      charCount += line.length();
      countWord(line);
    }
  }

  private static void countWord(String line) {
    String words[] = line.split(n"\\W");
    wordCount += words.length;
  }
}