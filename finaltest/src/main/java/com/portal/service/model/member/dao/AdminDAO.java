package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;

public interface AdminDAO {
	public String loginCheck(MemberDTO dto);
}
