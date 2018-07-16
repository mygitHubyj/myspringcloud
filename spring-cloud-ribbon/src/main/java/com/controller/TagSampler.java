package com.controller;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;

public class TagSampler implements Sampler {

    private String tag;

    public TagSampler(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean isSampled(Span span) {
        return span.tags().get(tag) != null;
    }
}
