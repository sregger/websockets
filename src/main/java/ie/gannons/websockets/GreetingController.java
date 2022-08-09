package ie.gannons.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@MessageMapping("/app")
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/ping")
    @SendTo("/websocket/ping")
    public Greeting ping(HelloMessage message) throws Exception {
        return new Greeting("Ping, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}