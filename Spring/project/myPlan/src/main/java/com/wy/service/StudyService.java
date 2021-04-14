package com.wy.service;

import com.wy.domain.Study;

import java.util.List;

public interface StudyService {
    int addStudy(Study study);
    List<Study> queryStudy();
    int updateStudy(double time, int id);
}
