package com.mellon.platform.goods.dao;

import com.mellon.platform.goods.domain.goods.po.GoodsPO;
import com.mellon.platform.goods.domain.goods.vo.GoodsVO;

import java.util.List;

public interface GoodsPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsPO record);

    int insertSelective(GoodsPO record);

    GoodsPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsPO record);

    int updateByPrimaryKey(GoodsPO record);

    List<GoodsVO> selectByCondition(GoodsVO condition);
}