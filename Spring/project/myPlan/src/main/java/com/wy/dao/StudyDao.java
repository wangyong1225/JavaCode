package com.wy.dao;

import com.wy.domain.Study;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudyDao {
    int updateStudy(@Param("time") double time,
                    @Param("id") int id);
    int insertStudy(Study study);
    List<Study> queryStudy();
}
