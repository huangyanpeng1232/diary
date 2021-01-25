package com.diary.index.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diary.index.bean.Diary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DiaryDao extends BaseMapper<Diary> {

    @Select("SELECT * FROM diary WHERE `status` = '1' ORDER BY top DESC, CASE WHEN (remind = 1 and TIMESTAMPDIFF(DAY, DATE_FORMAT(now(),'%Y-%m-%d'), remindTime) <= 0) THEN 0 ELSE 1 END, updateTime DESC")
    List<Diary> selectDiaryList();

    @Update("update diary set remind = '2' where id = #{id}")
    void affirmRemind(@Param("id") String id);

    @Update("update diary set status = '0' where id = #{id}")
    void delDiary(@Param("id") String id);

    @Update("update diary set emailRemind = #{emailRemind} where id = #{id}")
    void updateEmailRemind(@Param("id") String id,@Param("emailRemind") String emailRemind);

    @Select("SELECT * FROM diary WHERE `status` = '1' and remind = '1'")
    List<Diary> selectSendEmailDiary();
}
