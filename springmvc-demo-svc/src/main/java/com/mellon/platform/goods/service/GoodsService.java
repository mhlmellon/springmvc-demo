package com.mellon.platform.goods.service;

import java.util.Map;
import com.mellon.common.domain.result.Result;
import com.mellon.platform.goods.domain.goods.vo.GoodsVO;

/**
 * 服务
 * @author 
 * @since 2016-03-22
 */
public interface GoodsService {

    /**
    * 插入
    * @param record
    * @return
    */
    Result<GoodsVO> insertSelective(GoodsVO record);
    /**
    * 根据ID查询
    * @param goodsId
    * @return
    */
    Result<GoodsVO> selectByPrimaryKey(Long goodsId);
    /**
    * 更新
    * @param record
    * @return
    */
    Result<GoodsVO> updateByPrimaryKeySelective(GoodsVO record);
    /**
    * 根据ID删除
    * @param goodsId
    * @return
    */
    Result<GoodsVO> deleteByPrimaryKey(Long goodsId);
    /**
    * 条件查询列表
    * @param condition
    * @return
    */
    public Result<GoodsVO> selectByCondition(GoodsVO condition);
}
