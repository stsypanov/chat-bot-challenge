package chat;

import chat.application.Chat;
import chat.application.InputValidator;

public class Main {

  public static void main(String[] args) {
    InputValidator inputValidator = new InputValidator(args);
    if (inputValidator.inputValid()) {
      new Chat(args).run();
    } else {
      System.out.println("Invalid command line arguments!");
    }
  }



}
