# Reproduction repo: Logstash bug ignoring unknown types

This project exists as a proof of a Logstash encoder bug which causes it to ignore unknown types, silently ignoring logs.

See: (link to be added when bug ticket is open)

## Compiling and checking

You need a Java 17 JDK installed and on the PATH.

```shell
$ ./mvnw clean compile assembly:single
...
$ java -jar ./target/logstash-encoder-addkeyvalue-ignoring-objects-bug-1.0-SNAPSHOT-jar-with-dependencies.jar 
{"@timestamp":"2024-02-12T15:29:49.027406+01:00","@version":"1","message":"Just to show stuff is logged at all","logger_name":"com.spotify.logstashbug.Main","thread_name":"main","level":"ERROR","level_value":40000,"some-context":"hello: \"world\"\nworld: 123\n"}
```

This has been tested on macOS and in Linux x64 production environments.

## Output

The output you should get from running the app is:

```
{"@timestamp":"2024-02-12T15:29:49.027406+01:00","@version":"1","message":"Just to show stuff is logged at all","logger_name":"com.spotify.logstashbug.Main","thread_name":"main","level":"ERROR","level_value":40000,"some-context":"hello: \"world\"\nworld: 123\n"}
```

There should however be 2 logs, as per the [Main class](./src/main/java/com/spotify/logstashbug/Main.java).

## Licence

Note that this code is not owned by the author, but rather Spotify AB.
This project is licensed under the MIT Licence. See the licence text [here](./LICENCE).

Ownership details:

```
Spotify AB
Regeringsgatan 19
111 53 Stockholm
Sweden
```
