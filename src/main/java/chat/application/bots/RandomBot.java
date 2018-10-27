package chat.application.bots;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class RandomBot implements ChatBot {
  private final List<String> dictionary;

  @Override
  public String nextPhrase() {
    int bound = dictionary.size() - 1;
    int random = ThreadLocalRandom.current().nextInt(bound);
    return dictionary.get(random);
  }
}
