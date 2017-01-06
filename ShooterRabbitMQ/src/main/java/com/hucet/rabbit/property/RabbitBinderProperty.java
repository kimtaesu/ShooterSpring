package com.hucet.rabbit.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taesu- on 2016-07-03.
 */
@Component
@ConfigurationProperties(locations = {"rabbitmq.yml"}, prefix = "rabbitmq")
public class RabbitBinderProperty {

    public enum EnumRabbitBinder {
        Loader(1), Example(2);

        private int type;

        EnumRabbitBinder(int i) {
            type = i;
        }
    }

    private List<PropertyBinder> binders = new ArrayList<>();

    public List<PropertyBinder> getBinders() {
        return binders;
    }

    public PropertyBinder getLoaderBinder() {
        for (PropertyBinder binder : binders) {
            if (binder.getId() == EnumRabbitBinder.Loader.type) {
                return binder;
            }
        }
        return null;
    }
}