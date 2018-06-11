package com.portal.service.service;

import com.portal.service.model.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    public List<MemberDTO> memberList();
    public void insertMember(MemberDTO dto);
    public MemberDTO viewMember(Integer id);
    public void deleteMember(Integer id);
    public void updateMember(MemberDTO dto);
    public boolean checkPw(Integer id, String passwd);
}
