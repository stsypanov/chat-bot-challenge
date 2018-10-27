package chat.application;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputValidator {
  private static final List<String> availableStrategies = Arrays.asList("rand", "upseq", "downseq");

  private final String[] arguments;

  public InputValidator(String line) {
    this.arguments = InputTokenizer.tokenize(line);
  }

  public InputValidator(String[] args) {
    this.arguments=args;
  }

  public boolean inputValid() {

    UserInputProvider userInputProvider = new UserInputProvider();
    Optional<UserInput> userInput = userInputProvider.getUserInput(arguments);

    if (!userInput.isPresent()) {
      return false;
    }

    UserInput input = userInput.get();

    if (!availableStrategies.contains(input.getStrategy())) {
      return false;
    }

//        URL resource = this.getClass().getClassLoader().getResource("dictionary.txt");
//        String path = resource.toString();
//        String externalForm = resource.toExternalForm();
//        resource.getPath()
//
//        if (Files.isReadable(new File(dictionaryFileName).toPath())) {
//            return true;
//        }

    if (input.getDictionaryFileName().isEmpty()) {
      return false;
    }
    return true;
  }
}
