public class WordCount {
  private static int lineCount = 0;
  private static int charCount = 0;
  private static int wordCount = 0;

  public static void main(String[] args) {
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    String line;

    try {
      calculateCountVariables(inputReader);
      printCounts();
    } catch (IOException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  private static void calculateCountVariables(BufferedReader inputReader) {
    String line;
    while ((line = inputReader.readLine()) != null) {
      lineCount++;
      charCount += line.length();
      wordCount += calculateWords(line);
    }
  }

  private static int calculateWords(String line) {
    String words[] = line.split("\\W");
    return words.length;
  }

  private static void printCounts() {
    System.out.println("wordCount = " + wordCount);
    System.out.println("lineCount = " + lineCount);
    System.out.println("charCount = " + charCount);
  }
}

// 메서드에 static이 붙지 않았을 경우, WordCount 객체 생성 후 객체로 메서드 접근
/*
WordCount wordCounter = new WordCount();

inputReader = new BufferedReader(new InputStreamReader(System.in));
try {
  line = inputReader.readLine();
  while (line != null) {
    wordCounter.calculateCounts(line);
    line = inputReader.readLine();
  }
  wordCounter.printCounts();
}*/
