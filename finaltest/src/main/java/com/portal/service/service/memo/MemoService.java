package com.portal.service.service.memo;

import com.portal.service.model.memo.dto.MemoDTO;

import java.util.List;

public interface MemoService {
    public List<MemoDTO> list();
    public void insert(MemoDTO dto);
    public MemoDTO memo_view(int id);
    public void update(MemoDTO dto);
    public void delete(int id);
}
