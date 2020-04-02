package com.liuliu.goods;

import com.liuliu.pojo.goods.Brand;

import java.util.List;

public interface IBrandService {

    public List<Brand> brandList();

    public List<Brand> brandListByCondition(String name,String letter);

    public List<Brand> brandListPage(Integer pagenum,Integer pageSize);
}
