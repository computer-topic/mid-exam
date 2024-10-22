public class GuessStatistics {
  private String number;
  private String verb;
  private String pluralModifier;

  public String getGuessMessage(char candidate, int count) {
    setUpVariables(count);
    String guessMessage = String.format(
      "There %s %s %s%s", verb, number, candidate, pluralModifier);
    print(guessMessage);
  }

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