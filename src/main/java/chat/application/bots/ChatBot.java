package chat.application.bots;

import chat.application.Strategy;

import java.util.List;

public interface ChatBot {
  String nextPhrase();

  static ChatBot forStrategy(Strategy strategy, List<String> dictionary) {
    switch (strategy) {
      case rand:
        return new RandomBot(dictionary);
      case upseq:
        return new UpseqBot(dictionary);
      case downseq:
        throw new UnsupportedOperationException("not implemented");
    }
    throw new IllegalArgumentException("Unsupported strategy" + strategy);
  }
}
