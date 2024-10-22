public class UserValidator {
  private Cryptographer cryptographer;

  public boolean checkPasswordAndInitialzeSession(String userName, String password) {
    User user = UserGateway.findByName(userName);

    if (user == User.NULL) {
      return false;
    }
    if (validatePassword(user, password)) {
      Session.initialize();
      return true;
    }
    return false;
  }

  private boolean validatePassword(User user, String password) {
    String codedPhrase = user.getPhraseEncodedByPassword();
    String phrase = cryptographer.decrypt(codedPhrase, password);

    if ("Valid Password".equals(phrase)) {
      return true;
    }
    return false;
  }
}