package com.hucet.batch.io;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by taesu- on 2016-06-25.
 */
public class CodeProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) throws Exception {
        return item;
    }
}
