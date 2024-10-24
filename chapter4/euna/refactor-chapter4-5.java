// 교재에서는 리눅스 프로그래밍으로 생각하고 그냥 wc로 내비둠..
// class단에서 멤버변수 분리는 하지 않고 함수만 추출하도록 수업하심
public class WordCounter {
  private int lineCount = 0;
  private int charCount = 0;
  private int wordCount = 0;

  public static void main(String[] args) {
    WordCounter wordCount = new WordCounter();
    
    try {
      wordCount.calculateCountVariables();
      wordCount.printCountVariables();
    }
    catch (IOException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  private void calculateCountVariables() {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = in.readLine()) != null) {
      lineCount++;
      charCount += line.length();
      word += calculateWordCount(line);
    }
  }

  private int calculateWordCount(String line) {
    String words[] = line.split("\\W");
    return words.length;
  }

  private void printCountVariables() {
    System.out.println("wordCount = " + wordCount);
    System.out.println("lineCount = " + lineCount);
    System.out.println("charCount = " + charCount);
  }
}