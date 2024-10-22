public class UserValidator {
  private Cryptographer cryptographer;

  public boolean checkPasswordAndInitializeSession(String userName, String password) {
    User user = UserGateway.findByName(userName);

    if (user == User.NULL) {
      return false;
    }

    String codedPhrase = user.getPhraseEncodedByPassword();
    String phrase = cryptographer.decrypt(codedPhrase, password);
    if ("Valid Password".equals(phrase)) {
      Session.initialize();
      return true;
    }

    return false;
  }
}