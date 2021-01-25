package com.diary.index.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diary.index.bean.Diary;
import com.diary.index.service.DiaryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.backoff.BackOff;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.List;

@Controller
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping({"","/","index"})
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("loadDiary")
    public String loadDiary(Integer index){
        if(index == null || index <= 0){
            index = 1;
        }
        PageHelper.startPage(index,10);
        List<Diary> diaryList = diaryService.getDiaryList();
        return JSON.toJSONString(diaryList);
    }

    @ResponseBody
    @RequestMapping("save")
    public void save(@RequestBody String body){
        String decode = URLDecoder.decode(body);
        decode = decode.substring(0,decode.length()-1);
        JSONObject jsonObject = JSONObject.parseObject(decode);
        Diary diary = jsonObject.toJavaObject(Diary.class);
        diaryService.save(diary);
    }

    @ResponseBody
    @RequestMapping("affirmRemind")
    public void affirmRemind(String id){

        diaryService.affirmRemind(id);
    }

    @ResponseBody
    @RequestMapping("delDiary")
    public void delDiary(String id){

        diaryService.delDiary(id);
    }

    @ResponseBody
    @RequestMapping("updateEmailRemind")
    public void updateEmailRemind(String id,String emailRemind){

        diaryService.updateEmailRemind(id,emailRemind);
    }
}
