package de.gedoplan.showcase.langchain4jdemo.tools;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = AiTools.class)
public interface ToolsAiService {
  String chat(@UserMessage String question);
}
