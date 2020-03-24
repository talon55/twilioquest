package org.thedarlington.twilioquest;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioquestApplication {

  private static final String ENV_SID = "TQ_TWILIO_ACCOUNT_SID";
  private static final String ENV_TOKEN = "TQ_TWILIO_AUTH_TOKEN";
  private static final String ACCOUNT_SID = System.getenv(ENV_SID);
  private static final String AUTH_TOKEN = System.getenv(ENV_TOKEN);

  public static void main(String[] args) {
    ensureEnv();
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    SpringApplication.run(TwilioquestApplication.class, args);
  }

  private static void ensureEnv() {
    if (ACCOUNT_SID == null) {
      throw new RuntimeException(String.format("%s Environment Variable is null", ENV_SID));
    }

    if (AUTH_TOKEN == null) {
      throw new RuntimeException(String.format("%s Environment Variable is null", ENV_TOKEN));
    }
  }
}
