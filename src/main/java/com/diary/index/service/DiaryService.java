package com.diary.index.service;

import com.diary.index.bean.Diary;
import com.diary.index.dao.DiaryDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {
    @Autowired
    DiaryDao diaryDao;

    public List<Diary> getDiaryList(){
        return diaryDao.selectDiaryList();
    }

    public void save(Diary diary) {
        diaryDao.insert(diary);
    }

    public void affirmRemind(String id) {
        diaryDao.affirmRemind(id);
    }

    public void delDiary(String id) {
        diaryDao.delDiary(id);
    }

    public void updateEmailRemind(String id,String emailRemind) {
        diaryDao.updateEmailRemind(id,emailRemind);
    }
}
