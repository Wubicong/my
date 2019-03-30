package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.io.IOException;
import java.util.List;

public interface IGoodsDAO {
    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;

}
