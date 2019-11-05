package se.rampoon.example3.beans;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * Some logging of the headers
 */
@Component
public class MessageProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(MessageProcessor.class);
    public void handleMessage(Exchange exchange) {

        // Log headers
        exchange.getIn().getHeaders().forEach( (key, value)-> {
            LOG.info("MessageProcessor.handleMessage: Header key=" + key + " value=" + value);
        });
    }
}
