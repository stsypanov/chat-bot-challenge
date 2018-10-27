package chat.application;

import chat.application.bots.ChatBot;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Chat {

  private final String[] arguments;

  public Chat(String line) {
    this.arguments = InputTokenizer.tokenize(line);
  }

  public Chat(String[] args) {
    this.arguments = args;
  }

  public void run() {
    UserInputProvider userInputProvider = new UserInputProvider();
    UserInput input = userInputProvider.getUserInput(arguments).orElseThrow(UserInputNotValidateException::new);
    List<String> dictionary = readDictionary(input);

    System.out.println("talk_to_me (or type 'quit' to finish)>");

    Scanner commandLineReader = new Scanner(System.in);
    Strategy strategy = Strategy.valueOf(input.getStrategy());

    ChatBot bot = ChatBot.forStrategy(strategy, dictionary);

    while (commandLineReader.hasNext()) {
      String line = commandLineReader.nextLine();
      if ("quit".equals(line)) {
        return;
      }

      String nextPhrase = bot.nextPhrase();
      print(nextPhrase);
    }
  }

  private static void print(String message) {
    System.out.println(message);
  }

  private List<String> readDictionary(UserInput input) {
    String dictionaryFileName = input.getDictionaryFileName();
    File file = new File(dictionaryFileName);
    try {
      return Files.readAllLines(file.toPath());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static class UserInputNotValidateException extends RuntimeException {
    UserInputNotValidateException() {
      super("Please validate input!");
    }
  }
}
//-r rand -f D:\Сергей\pro\chat-bot-challenge\src\main\resources\dictionary.txt