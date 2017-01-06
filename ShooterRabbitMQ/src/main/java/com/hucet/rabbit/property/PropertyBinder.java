package com.hucet.rabbit.property;

import java.io.Serializable;

/**
 * Created by saltfactory<saltfactory@gmail.com> on 11/21/15.
 */

public class PropertyBinder implements Serializable {
    private long id;
    private String queue;
    private String exchange;
    private String rountingKey;

    public String getQueueName() {
        return queue;
    }

    public long getId() {
        return id;
    }

    public void setRountingKey(String rountingKey) {
        this.rountingKey = rountingKey;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getExchangeName() {
        return exchange;
    }

    public String getRountingKey() {
        return rountingKey;
    }
}
