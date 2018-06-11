package com.portal.service.service;

import com.portal.service.model.dao.MemberDAO;
import com.portal.service.model.dto.MemberDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    // mybatis 객체를 자동으로 생성하여 주입시키는 어노테이션
    @Inject
    MemberDAO memberDAO;

    @Override
    public List<MemberDTO> memberList() {
        return memberDAO.memberList();
    }

    @Override
    public void insertMember(MemberDTO dto) {
        memberDAO.insertMember(dto);
    }

    @Override
    public MemberDTO viewMember(Integer id) {
        return memberDAO.viewMember(id);
    }

    @Override
    public void deleteMember(Integer id) {
        memberDAO.deleteMember(id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        memberDAO.updateMember(dto);
    }

    @Override
    public boolean checkPw(Integer id, String passwd) {
        return memberDAO.checkPw(id, passwd);
    }
}
