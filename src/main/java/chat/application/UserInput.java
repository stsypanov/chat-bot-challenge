package chat.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserInput {
  private final String strategy;
  private final String dictionaryFileName;
}
