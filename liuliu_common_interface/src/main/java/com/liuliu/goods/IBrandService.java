package com.liuliu.goods;


import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuliu.pojo.goods.Brand;

import java.util.Map;


public interface IBrandService {

    public List<Brand> brandList();

    public List<Brand> brandListByCondition(Map<String,Object> queryMap);

    public IPage<Brand> brandListPage(Integer pagenum, Integer pageSize);

    public IPage<Brand> brandListPageCondition(Integer pagenum, Integer pageSize,Map<String,Object> queryMap);

}
