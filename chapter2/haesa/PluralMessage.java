public class PluralMessage {
  private String number;
  private String verb;
  private String pluralModifier;

  public String make(char candidate, int count) {
    setPluralPart(count);
    return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
  }

  private void setPluralPart(int count) {
    if (count == 0) {
      handleThereAreNoLetters();
    } else if (count == 1) {
      handleThereIsOneLetter();
    } else {
      handleThereAreManyLetters();
    }
  }

  private void handleThereAreNoLetters() {
    number = "no";
    verb = "are";
    pluralModifier = "s";
  }

  private void handleThereIsOneLetter() {
    number = "1";
    verb = "is";
    pluralModifier = "";
  }

  private void handleThereAreManyLetters() {
    number = Integer.toString(count);
    verb = "are";
    pluralModifier = "s";
  }
}

