package chat.application;

import java.util.Optional;

public class UserInputProvider {
  public Optional<UserInput> getUserInput(String[] arguments) {
    if (arguments.length != 4) {
      return Optional.empty();
    }
    if (!"-r".equals(arguments[0])) {
      return Optional.empty();
    }
    if (!"-f".equals(arguments[2])) {
      return Optional.empty();
    }

    String strategy = arguments[1];
    String dictionaryFileName = arguments[3];
    UserInput userInput = new UserInput(strategy, dictionaryFileName);
    return Optional.of(userInput);
  }
}
