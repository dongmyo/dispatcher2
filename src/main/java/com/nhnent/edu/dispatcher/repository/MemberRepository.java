package com.nhnent.edu.dispatcher.repository;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.model.MemberType;

import java.util.List;

public interface MemberRepository {
    Member exists(String id, String password);

    List<Member> list();

    // TODO: 3. MemberType이 일치하는 멤버 목록을 가져오는 메서드 추가
    // TODO: 3. MemberTypeが一致するメンバーのリストを取得するメソッドを追加
    List<Member> list(MemberType memberType);

}
