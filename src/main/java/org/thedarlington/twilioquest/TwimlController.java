package org.thedarlington.twilioquest;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwimlController {

  @PostMapping(value = "/hello", produces = MediaType.APPLICATION_XML_VALUE)
  public String twiml() {
    Say one = new Say.Builder("Hello there! You have successfully configured a web hook.").build();
    Say two = new Say.Builder("Good luck on your Twilio quest!").build();

    VoiceResponse voiceResponse = new VoiceResponse.Builder().say(one).say(two).build();

    return voiceResponse.toXml();
  }

}
