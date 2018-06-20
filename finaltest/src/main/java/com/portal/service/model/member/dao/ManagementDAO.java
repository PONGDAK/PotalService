package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;

import java.util.List;

public interface ManagementDAO {
    public List<MemberDTO> memberList();
    public void insertMember(MemberDTO dto);
    public MemberDTO viewMember(int id);
    public void deleteMember(int id);
    public void updateMember(MemberDTO dto);
//    public boolean checkPw(int id, String passwd);
}
