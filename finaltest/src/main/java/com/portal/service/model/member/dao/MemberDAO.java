package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String userid);
    public void insertMember(MemberDTO dto);
	public void deleteMember(int id);
	public void updateMember(MemberDTO dto);
	public void cancelMember(int id);
	public boolean checkPw(int id, String passwd);
}
