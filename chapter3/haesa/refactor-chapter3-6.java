public class UserValidator {
  private Cryptographer cryptographer;

  public boolean checkPasswordAndInitializeSession(String userName, String password) {
    User user = UserGateway.findByName(userName);
    if (user == User.NULL) {
      return false;
    }
    if (isValidPassword(user, password)) {
      Session.initialize();
      return true;
    }
    return false;
  }

  public boolean isValidPassword(User user, String password) {
    String codedPhrase = user.getPhraseEncodedByPassword();
    String phrase = cryptographer.decrypt(codedPhrase, password);
    return "Valid Password".equals(phrase);
  }
}