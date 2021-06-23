package com.build.project.boot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum CardCompany {

    CARD("카드정보",
            Arrays.asList(
                    setting("01","비씨카드"), setting("02","국민카드"), setting("03","외한카드"),
                    setting("04","삼성카드"), setting("06","신한카드"), setting("07","현대카드"),
                    setting("08","롯데카드"), setting("11","시티카드"), setting("12","농협카드"),
                    setting("13","수협카드"), setting("14","평화(신협)카드"), setting("15","우리카드"),
                    setting("16","하나카드"), setting("21","광주카드"), setting("22","전북카드"),
                    setting("23","제주카드"), setting("24","산은카드"), setting("25","해외비자카드"),
                    setting("26","해외마스터카드"), setting("27","해외다이너스카드"), setting("28","해외MAX카드"),
                    setting("29","해외JCB카드"), setting("32","우체국카드"), setting("33","저축은행카드"),
                    setting("34","은련카드"), setting("35","새마을금고카드"), setting("36","KDB산업카드")
            )),
    @SuppressWarnings("unchecked")
    EMPTY("없음", Collections.EMPTY_LIST);

    private String viewName;
    private List<String[]> cardinfo;

    CardCompany(String viewName, List<String[]> cardinfo) {
        this.viewName = viewName;
        this.cardinfo = cardinfo;
    }

    public static String[] setting(String cardCode, String cardName) {
        return new String[] {cardCode, cardName};
    }

    public static CardCompany findByCard(Object param) {
        return Arrays.stream(CardCompany.values())
                .filter(info -> info.hasCardInfo(param))
                .findAny()
                .orElse(EMPTY);
    }
    public boolean hasCardInfo(Object param) {
        return cardinfo.stream()
                .anyMatch(code -> code[0].equals(param) || code[1].contains(param.toString()));
    }
}
