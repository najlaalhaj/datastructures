package com.automatter;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface FullName {

    String firstName();
    String fatherName();
    String grandFatherName();
    String fatherGrandFatherName();
    String marriageName();
}
