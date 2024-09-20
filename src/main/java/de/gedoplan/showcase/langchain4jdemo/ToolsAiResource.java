package de.gedoplan.showcase.langchain4jdemo;

import de.gedoplan.showcase.langchain4jdemo.tools.ToolsAiService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ai")
public class ToolsAiResource {

  @Inject
  ToolsAiService toolsAiService;

  @POST
  @Path("/tools")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.TEXT_PLAIN)
  public Response tools(String question) {
    return Response.ok(toolsAiService.chat(question)).build();
  }

}
