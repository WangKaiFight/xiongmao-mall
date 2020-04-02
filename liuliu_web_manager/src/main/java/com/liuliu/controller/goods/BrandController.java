package com.liuliu.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuliu.config.entity.ResponseData;
import com.liuliu.goods.IBrandService;
import com.liuliu.pojo.goods.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品品牌管理接口")
public class BrandController {

    @Reference
    private IBrandService brandService;

    @GetMapping("/brandList")
    @ApiOperation(value = "品牌列表",notes = "获取品牌列表")
    public ResponseData<Brand> brandList(){
        List<Brand> brands = brandService.brandList();
        if (brands != null){
            return ResponseData.success().putDataVule("brandList", brands);
        }else {
            return ResponseData.serverInternalError();
        }
    }

    @PostMapping("/brandCondition")
    @ApiOperation(value = "条件查询品牌列表",notes = "根据条件查询品牌列表信息")
    @ApiImplicitParam(value = "查询条件",name = "queryMap",required = false,dataType = "Map",paramType = "body")
    public ResponseData<Brand> brandConditions(@RequestBody Map<String,Object> queryMap){
        List<Brand> brands = brandService.brandListByCondition(queryMap);
        if (brands != null){
            return ResponseData.success().putDataVule("brandList",brands );
        }else {
            return ResponseData.serverInternalError();
        }
    }

    @GetMapping("/brandPage")
    @ApiOperation(value = "分页查询",notes = "分页查询所有品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数",name = "pagenum",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "每页条数",name = "pagesize",required = false,dataType = "Integet",paramType = "query")
    })
    public ResponseData<Brand> brandPage(@RequestParam Integer pagenum,@RequestParam Integer pagesize){
        IPage<Brand> brandIPage = brandService.brandListPage(pagenum, pagesize);
        return ResponseData.success().putDataVule("total",brandIPage.getTotal() )
                                      .putDataVule("pages",brandIPage.getPages() )
                                      .putDataVule("brandList",brandIPage.getRecords() );
    }

    @PostMapping("/brandPageCondition")
    @ApiOperation(value = "分页条件查询",notes = "根据条件分页查询品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数",name = "pagenum",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "每页条数",name = "pagesize",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "查询条件",name = "queryMap",required = false,dataType = "Map",paramType = "body")

    })
    public ResponseData<Brand> brandPageCondition(@RequestParam Integer pagenum,@RequestParam Integer pagesize,@RequestBody Map<String,Object> queryMap){
        IPage<Brand> brandIPage = brandService.brandListPageCondition(pagenum, pagesize, queryMap);
        return ResponseData.success().putDataVule("total",brandIPage.getTotal() )
                .putDataVule("pages",brandIPage.getPages() )
                .putDataVule("brandList",brandIPage.getRecords() );
    }
}
