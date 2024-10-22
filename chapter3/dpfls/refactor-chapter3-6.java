public class UserValidator {
  private Cryptographer cryptographer;

  public boolean checkPassword(String userName, String password) {
    User user;

    user = UserGateway.findByName(userName);
    if (user == NULL)
      return false;
    if (isValidPassword(phrase)) {
      Session.initialize();
      return true;
    }
    return false;
  }

  private isValidPassword(String phrase) {
    String codedPhrase;
    String phrase;

    codedPhrase = user.getPhraseEncodedByPassword();
    phrase = cryptographer.decrypt(codedPhrase, password);
    return "Valid Password".equals(phrase);
  }
}