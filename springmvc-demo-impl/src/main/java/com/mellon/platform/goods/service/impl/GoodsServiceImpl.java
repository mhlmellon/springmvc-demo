package com.mellon.platform.goods.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.mellon.common.domain.vo.PageInfo;
import com.mellon.platform.goods.dao.GoodsPOMapper;
import com.mellon.platform.goods.service.GoodsService;
import com.mellon.common.domain.result.Result;
import com.mellon.platform.goods.domain.goods.vo.GoodsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * 服务实现
 * @author 
 * @since 2016-03-22
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	
    @Autowired
	private GoodsPOMapper goodsDAO;


    /**
    * 插入
    * @param record
    * @return
    */
    public Result<GoodsVO> insertSelective(GoodsVO record) {
        Result<GoodsVO> result = new Result<GoodsVO>();
        int insertedId=goodsDAO.insertSelective(record);
        if(insertedId>0) {
            result.setSuccess(true);
            result.setModel(record);
        }
        return result;
    }
    /**
    * 根据ID查询
    * @param goodsId
    * @return
    */
    public Result<GoodsVO> selectByPrimaryKey(Long goodsId) {
        Result<GoodsVO> result = new Result<GoodsVO>();
        GoodsVO selectedGoods = (GoodsVO) goodsDAO.selectByPrimaryKey(goodsId);
        if(selectedGoods!=null) {
            result.setSuccess(true);
            result.setModel(selectedGoods);
        }
        return result;
    }

    /**
    * 更新
    * @param record
    * @return
    */
    public Result<GoodsVO> updateByPrimaryKeySelective(GoodsVO record) {
        Result<GoodsVO> result = new Result<GoodsVO>();
        int updatedRows=goodsDAO.updateByPrimaryKeySelective(record);
        if(updatedRows>0) {
            result.setSuccess(true);
            result.setModel(record);
        }
        return result;
        
    }

    /**
    * 根据ID删除
    * @param goodsId
    * @return
    */
    public Result<GoodsVO> deleteByPrimaryKey(Long goodsId) {
        Result<GoodsVO> result = new Result<GoodsVO>();
        int deletedRows=goodsDAO.deleteByPrimaryKey(goodsId);
        if(deletedRows == 1) {
            result.setSuccess(true);
        }
        return result;
    }

    /**
    * 条件查询列表
    * @param condition
    * @return
    */
    public Result<GoodsVO> selectByCondition(GoodsVO condition) {
        Result<GoodsVO> result = new Result<GoodsVO>();
            PageHelper.startPage(condition.getPagingQuery().getPageIndex(), condition.getPagingQuery().getPageSize());
            List<GoodsVO> resultList = goodsDAO.selectByCondition(condition);
            PageInfo<GoodsVO> pageInfo = new PageInfo<>(resultList);
            result.setSuccess(true);
            result.setModels(resultList);
            result.setPaging(pageInfo);
            return result;
    }
    
}
