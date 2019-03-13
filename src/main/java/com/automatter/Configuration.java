package com.automatter;

import io.norberg.automatter.AutoMatter;
import java.util.List;
@AutoMatter
public interface Configuration {

    int rcsFetchTime();
    String configurationAssignmentId();
    List<PropertyValue> properties();

    @AutoMatter
    interface PropertyValue{
        String name();
        String clientId();
        String componentId();
        String value();
    }
}
