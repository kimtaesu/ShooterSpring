package com.hucet.batch.io;

import com.hucet.rabbit.property.RabbitBinderProperty;
import com.hucet.rabbit.writer.RabbitMQWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by taesu- on 2016-06-25.
 */
public class CodeItemWriter implements ItemWriter<String> {
    private static final Log LOGGER = LogFactory.getLog(CodeItemWriter.class);

    @Autowired
    RabbitMQWriter rabbitMQWriter;

    @Autowired
    RabbitBinderProperty rabbitBinderProperty;

    @Override
    public void write(List<? extends String> items) throws Exception {
        LOGGER.info("write " + items);
        for (String item : items) {
            rabbitMQWriter.shooting(rabbitBinderProperty.getLoaderBinder().getRountingKey(), item);
        }
    }
}
