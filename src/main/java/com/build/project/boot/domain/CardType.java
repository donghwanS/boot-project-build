package com.build.project.boot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum CardType {

    USEYN("useYn",
            Arrays.asList(
                    setting("Y", "2"),
                    setting("N", "1")
            )),
    USECHECK("useCheck",
            Arrays.asList(
                    setting("start", "2"),
                    setting("wait", "3"),
                    setting("end", "4")
            )),
    PAYMENTCHECK("paymentCheck",
            Arrays.asList(
                    setting("Y", "2"),
                    setting("N", "1")
            )),
    @SuppressWarnings("unchecked")
    EMPTY("empty", Collections.EMPTY_LIST);

    private String typeName;
    private List<String[]> typeValue;

    CardType(String typeName, List<String[]> typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public static String[] setting(String type1Value, String type2Value) {
        return new String[] {type1Value, type2Value};
    }

    public static CardType findByTypeValue(Object param) {
        return Arrays.stream(CardType.values())
                .filter(type -> type.hasTypeValue(param))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasTypeValue(Object param) {
        return typeValue.stream()
                .anyMatch(type -> type[0].equals(param) || type[1].equals(param));
    }
}
