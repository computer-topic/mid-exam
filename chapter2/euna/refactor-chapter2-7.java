// 교재에서는 GuessStatisticsMessage로 클래스 명을 지정
public class GuessStatistics {
  private String number;
  private String verb;
  private String pluralModifier;

  // 교재에서는 클래스 이름이 ~Message임에 따라 포매터를 바탕으로 메시지를 만드는 함수를 작성함
  // public String make(char candidate, int count) {
  //   createPluralDependentMessageParts(count);
  //   return String.format(
  //     "There %s %s %s%s", verb, number, candidate, pluralModifier);
  // }
  public void getGuessMessage(char candidate, int count) {
    setUpVariables(count);
    String guessMessage = String.format(
      "There %s %s %s%s", verb, number, candidate, pluralModifier);
    print(guessMessage);
  }

  // 교재에서는 createPluralDependentMessageParts라는 함수명을 사용함
  private void setUpVariablesRelatedPluralModifier(int count) {
    if (count == 0) {
      handleWhenThereAreNoLetters();
    } else if (count == 1) {
      handleWhenThereIsOneLetter();
    } else {
      handleWhenThereAreManyLetters(count);
    }
  }

  private void handleWhenThereAreNoLetters() {
    number = "no";
    verb = "are";
    pluralModifier = "s";
  }

  private void handleWhenThereIsOneLetter() {
    number = "1";
    verb = "is";
    pluralModifier = "";
  }

  private void handleWhenThereAreManyLetters(int count) {
    number = Integer.toString(count);
    verb = "are";
    pluralModifier = "s";
  }
}