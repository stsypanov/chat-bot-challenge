package chat.application.bots;

import chat.application.bots.ChatBot;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UpseqBot implements ChatBot {
  private final List<String> dictionary;
  private int count;

  @Override
  public String nextPhrase() {
    if (count >= dictionary.size()) {
      count = 0;
    }
    return dictionary.get(count++);
  }
}
