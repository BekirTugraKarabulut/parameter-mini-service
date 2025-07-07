package com.example.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    PARAMETRE_YOK("111","Parametre yoktur!"),
    PARAMETRELER_YOK("222","Parametrele yoktur!"),
    CODE_DEGERİ_EKSİ_HATASI("333","Code değeri eksili olamaz!");

    private String message;
    private String code;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
