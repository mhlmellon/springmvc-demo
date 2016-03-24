package com.mellon.platform.goods.controller;

import com.mellon.common.domain.result.Result;
import com.mellon.platform.goods.domain.goods.vo.GoodsVO;
import com.mellon.platform.goods.service.GoodsService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.mellon.platform.core.controller.BaseController;
import com.mellon.common.util.DateTimeUtil;
import com.mellon.platform.privilege.UserVO;
import javax.servlet.http.HttpServletRequest;
/**
 * 控制器
 * @author 
 * @since 2016-03-22
 */
@Controller
@RequestMapping("/Goods")
public class GoodsController extends BaseController {
	
	@Autowired
	private GoodsService goodsService;

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
    /**
     * 插入
     * @param goodsVO
     * @param request
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody()
    public Result<GoodsVO> insertGoods(@RequestBody GoodsVO goodsVO, HttpServletRequest request) {
        return goodsService.insertSelective(goodsVO);
    }
    
    /**
     * 更新
     * @param goodsVO
     * @param request
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody()
    public Result<GoodsVO> updateGoods(@RequestBody GoodsVO goodsVO, HttpServletRequest request) {
        return goodsService.updateByPrimaryKeySelective(goodsVO);
    }
    
    /**
     * 删除
     * @param goodsId
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody()
    public Result<GoodsVO> deleteGoods(@RequestBody Long goodsId) {
        return goodsService.deleteByPrimaryKey(goodsId);
    }
    
    /**
     * 查询单个
     * @param goodsId
     */
    @RequestMapping(value="/get/{goodsId}",method = RequestMethod.GET)
    @ResponseBody()
    public Result<GoodsVO> queryGoodsById(@PathVariable Long goodsId) {
        return goodsService.selectByPrimaryKey(goodsId);
    }


    /**
    * 条件查询列表
    * @param condition
    * @return
    */
    @RequestMapping(value="/list",method = RequestMethod.POST)
    @ResponseBody()
    public Result<GoodsVO> selectByCondition(@RequestBody GoodsVO condition) {
        return goodsService.selectByCondition(condition);
    }
}