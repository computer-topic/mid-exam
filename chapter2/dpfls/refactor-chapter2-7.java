public class GuessStatistics {
    private String number;
    private String verb;
    private String pluralModifier;

    public void printGuessStatistics(char candidate, int count) {
        makeSentence(count);
        printSentence(candidate);
    }

    private void makeSentence(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters();
        }
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreManyLetters() {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void printSentence(String candidate) {
        String message = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        print(message);
    }
}