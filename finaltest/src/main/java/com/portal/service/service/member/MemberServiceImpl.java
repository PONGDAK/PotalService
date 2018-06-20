package com.portal.service.service.member;

import com.portal.service.model.member.dao.MemberDAO;
import com.portal.service.model.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDao;

    @Inject
    public MemberServiceImpl(MemberDAO memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public boolean loginCheck(MemberDTO dto, HttpSession session) {
        boolean result = memberDao.loginCheck(dto);
        if (result) { //로그인 성공
            //세션변수에 값 저장
            MemberDTO dto2 = viewMember(dto.getUserid());
            //setAttribute(변수명,값)
            session.setAttribute("userid", dto.getUserid());
            session.setAttribute("id", dto2.getId());
            session.setAttribute("name", dto2.getName());
            System.out.println(session.getAttribute("id"));
            System.out.println(session.getAttribute("userid"));
            System.out.println(session.getAttribute("name"));
        }
        return result;
    }

    @Override
    public void logout(HttpSession session) {
        //세션 초기화
        session.invalidate();
    }

    @Override
    public MemberDTO viewMember(String userid) {
        return memberDao.viewMember(userid);
    }

    @Override
    public void insertMember(MemberDTO dto) {
        memberDao.insertMember(dto);
    }

    @Override
    public void deleteMember(int id) {
        memberDao.deleteMember(id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        memberDao.updateMember(dto);
    }

    @Override
    public void cancelMember(int id) {
        memberDao.cancelMember(id);
    }

    @Override
    public boolean checkPw(int id, String passwd) {
        return memberDao.checkPw(id, passwd);
    }
}





