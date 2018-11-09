package com.nhnent.edu.dispatcher.model;

import com.fasterxml.jackson.annotation.JsonValue;

// TODO: 1. MemberType enum 선언
// TODO: 1. MemberType enum宣言
public enum MemberType {
    GUEST, MEMBER;


    @Override
    @JsonValue
    public String toString() {
        return super.name().toLowerCase();
    }

}
