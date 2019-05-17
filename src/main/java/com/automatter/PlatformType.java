package com.automatter;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface PlatformType {
  enum Platform {
    UNKOWN,
    BACKEND,
    ANDROID
  }
}
