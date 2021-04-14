package com.wy.service.impl;

import com.wy.dao.StudyDao;
import com.wy.domain.Study;
import com.wy.service.StudyService;

import java.util.List;

public class StudyServiceImpl implements StudyService {

    private StudyDao studyDao;

    public StudyDao getStudyDao() {
        return studyDao;
    }

    public void setStudyDao(StudyDao studyDao) {
        this.studyDao = studyDao;
    }

    @Override
    public int addStudy(Study study) {
        int num = studyDao.insertStudy(study);
        return num;
    }

    @Override
    public List<Study> queryStudy() {
        List<Study> studies = studyDao.queryStudy();
        return studies;
    }

    @Override
    public int updateStudy(double time, int id) {
        int num = studyDao.updateStudy(time, id);
        return num;
    }
}
