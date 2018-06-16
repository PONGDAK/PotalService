package com.portal.service.service.memo;

import com.portal.service.model.memo.dao.MemoDAO;
import com.portal.service.model.memo.dto.MemoDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoDAO memoDAO;

    @Inject
    public MemoServiceImpl(MemoDAO memoDAO) {
        this.memoDAO = memoDAO;
    }

    @Override
    public List<MemoDTO> list() {
        return memoDAO.list();
    }

    @Override
    public void insert(MemoDTO dto) {
        memoDAO.insert(dto.getWriter(), dto.getMemo());
    }

    @Override
    public MemoDTO memo_view(int id) {
        return memoDAO.memo_view(id);
    }

    @Override
    public void update(MemoDTO dto) {
        memoDAO.update(dto);
    }

    @Override
    public void delete(int id) {
        memoDAO.delete(id);
    }
}
