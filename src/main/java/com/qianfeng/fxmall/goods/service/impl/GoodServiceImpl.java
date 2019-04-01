package com.qianfeng.fxmall.goods.service.impl;

import com.qianfeng.fxmall.commons.info.Constants;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactroyUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDAOImpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;

import java.util.List;

public class GoodServiceImpl implements IGoodsService {

    private IGoodsDAO goodsDAO = new GoodsDAOImpl();
    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {

        if(page <0){
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        int index = (page-1)* Constants.page.PAGE_SIZE;
        List<WxbGood> goods = goodsDAO.queryGoodsByPage(index);
        return goods;
    }

    @Override
    public void insertGood(WxbGood good) {
        if(good!=null){
            goodsDAO.insertGood(good);

        }else {
            throw new RuntimeException("请全部填写");
        }
    }

}
