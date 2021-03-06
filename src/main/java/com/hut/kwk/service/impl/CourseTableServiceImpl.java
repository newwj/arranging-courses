package com.hut.kwk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hut.kwk.constant.ServerResponse;
import com.hut.kwk.model.entity.CourseTable;
import com.hut.kwk.model.entity.CourseTableQuery;
import com.hut.kwk.model.mapper.CourseTableMapper;
import com.hut.kwk.service.ICourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by kwk on 2019-04-24
 *
 * @author kwk
 */
@Service
public class CourseTableServiceImpl implements ICourseTableService {

    @Autowired
    private CourseTableMapper courseTableMapper;

    /**
     * 排课算法
     * @return
     */
    @Override
    public ServerResponse<String> arr() {

        return null;
    }

    @Override
    public ServerResponse<List<CourseTable>> findBy(String className, String teacherName) {
        CourseTableQuery query =new CourseTableQuery();
        CourseTableQuery.Criteria criteria = query.createCriteria();
        if (className!=null&&!"".equals(className)){
            criteria.andClassNameEqualTo(className);
        }
        if (teacherName!=null&&!"".equals(teacherName)){
            criteria.andTecherNameEqualTo(teacherName);
        }
        List<CourseTable> courseTables = courseTableMapper.selectByExample(query);
        return ServerResponse.createBySuccess(courseTables);
    }

    @Override
    public ServerResponse<String> add(CourseTable courseTable) {
        //todo
        return null;
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = courseTableMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> update(CourseTable courseTable) {
        //todo
        return null;
    }

    @Override
    public ServerResponse<CourseTable> find(Integer id) {
        return ServerResponse.createBySuccess(courseTableMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<PageInfo<CourseTable>> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseTable> list = courseTableMapper.selectByExample(new CourseTableQuery());
        PageInfo<CourseTable> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess(pageInfo);    }

}
