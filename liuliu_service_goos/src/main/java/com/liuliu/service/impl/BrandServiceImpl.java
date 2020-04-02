package com.liuliu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuliu.goods.IBrandService;
import com.liuliu.mapper.BrandMapper;
import com.liuliu.pojo.goods.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> brandList() {
        return brandMapper.selectList(null);
    }

    private QueryWrapper<Brand> queryWrapper(Map<String,Object> queryMap){
        // 查询条件
        QueryWrapper<Brand> queryWrapper = null;
        if (queryMap != null){
            queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(queryMap.get("name"))){
                queryWrapper.like("name",queryMap.get("name") );
            }
            if (!StringUtils.isEmpty(queryMap.get("letter"))){
                queryWrapper.eq("letter",queryMap.get("letter") );
            }
        }
        return queryWrapper;
    }

    @Override
    public List<Brand> brandListByCondition(Map<String,Object> queryMap) {
        return brandMapper.selectList(queryWrapper(queryMap));
    }

    @Override
    public IPage<Brand> brandListPage(Integer pagenum, Integer pageSize) {
        IPage<Brand> page = new Page<>(pagenum,pageSize);
        page = brandMapper.selectPage(page, queryWrapper(null));
        return page;
    }

    @Override
    public IPage<Brand> brandListPageCondition(Integer pagenum, Integer pageSize, Map<String, Object> queryMap) {
        IPage<Brand> page = new Page<>(pagenum,pageSize);
        page = brandMapper.selectPage(page, queryWrapper(queryMap));
        return page;
    }
}
