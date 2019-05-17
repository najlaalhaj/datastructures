package com.automatter;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface Value<T> {

    T value();
}
