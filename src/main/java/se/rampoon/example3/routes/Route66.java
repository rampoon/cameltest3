package se.rampoon.example3.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Route66 extends RouteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(Route66.class);

    @Override
    public void configure() throws Exception {
        from("file:/home/matjav/apps/cameltest3/files/inbox?move=./done")
                .log(LoggingLevel.INFO, LOG, "Route66 starting...")
               // .bean(new MyTransformer2(), "TransformContent")
                .bean("messageProcessor", "handleMessage")
                .to("file:/home/matjav/apps/cameltest3/files/outbox");
    }
}

