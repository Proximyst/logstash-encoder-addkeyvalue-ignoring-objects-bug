package com.spotify.logstashbug;

import com.spotify.logstashbug.proto.TestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(final String[] args) {
    LOGGER
        .atError()
        .addKeyValue(
            "some-context", TestMessage.newBuilder().setHello("world").setWorld(123).build())
        .log("Super mega important log message with large business value");

    LOGGER
        .atError()
        .addKeyValue(
            "some-context",
            TestMessage.newBuilder().setHello("world").setWorld(123).build().toString())
        .log("Just to show stuff is logged at all");
  }
}
