public class UserValidator {
  private Cryptographer cryptographer;

  public boolean checkPasswordAndInitializeSession(String userName, String password) {
    User user;

    user = UserGateway.findByName(userName);
    if (user == NULL)
      return false;
    if (isValidPassword(user)) {
      Session.initialize();
      return true;
    }
    return false;
  }

  private boolean isValidPassword(User user) {
    String codedPhrase;
    String phrase;

    codedPhrase = user.getPhraseEncodedByPassword();
    phrase = cryptographer.decrypt(codedPhrase, password);
    return "Valid Password".equals(phrase);
  }
}