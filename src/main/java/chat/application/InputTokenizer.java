package chat.application;

public class InputTokenizer {
  public static String[] tokenize(String line) {
    return line.split("\\s+");
  }
}
