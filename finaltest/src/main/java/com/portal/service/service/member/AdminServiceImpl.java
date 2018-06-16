package com.portal.service.service.member;


import com.portal.service.model.member.dao.AdminDAO;
import com.portal.service.model.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminDAO adminDao;

	@Inject
	public AdminServiceImpl(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String loginCheck(MemberDTO dto) {
		return adminDao.loginCheck(dto);
	}

}




