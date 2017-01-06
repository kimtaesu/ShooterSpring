package com.hucet.batch.io;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by taesu- on 2016-06-25.
 */
public class CodeItemReader implements ItemReader<String> {

    Iterator<String> iterator = Stream.of("a", "b", "c").iterator();

    @Override
    public String read() {
        while (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
