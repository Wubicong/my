package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.Constants;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactroyUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GoodsDAOImpl implements IGoodsDAO {
    SqlSession session = MyBatisSessionFactroyUtils.getSession();
    GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page)  {

        List<WxbGood> goods = goodsMapper.queryGoodByPage(page, Constants.page.PAGE_SIZE);
        return goods;
    }

    @Override
    public void insertGood(WxbGood good) {
        goodsMapper.insertGood(good);
        session.commit();
    }
}
