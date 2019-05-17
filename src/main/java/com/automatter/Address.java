package com.automatter;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface Address {
    String Street();
    int no();
    String city();
    int postCode();
    String country();
}
