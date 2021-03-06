package com.portal.service.service.member;

import com.portal.service.model.member.dto.MemberDTO;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public boolean loginCheck(MemberDTO dto, HttpSession session);
    public void logout(HttpSession session);
    public MemberDTO viewMember(String userid);
    public void insertMember(MemberDTO dto);
    public void deleteMember(int id);
    public void updateMember(MemberDTO dto);
    public void cancelMember(int id);
    public boolean checkPw(int id, String passwd);
}
