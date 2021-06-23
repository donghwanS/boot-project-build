package com.build.project.boot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;

@Getter
@RequiredArgsConstructor
public enum DateFormat {

    DATETOSTRING(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),
    STRINGTODATE(new SimpleDateFormat("yyyy-MM-dd"));

    private SimpleDateFormat format;

    DateFormat(SimpleDateFormat format) {
        this.format = format;
    }
}
