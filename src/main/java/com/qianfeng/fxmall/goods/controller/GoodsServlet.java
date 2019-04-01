package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.impl.GoodServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@WebServlet("/good.do")
public class GoodsServlet extends BaseServlet {
    private IGoodsService goodsService = new GoodServiceImpl();
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr =  req.getParameter("page");
        try {
            pageStr = pageStr==null?"1":pageStr;
            List<WxbGood> goodList = goodsService.queryGoodByPage(Integer.parseInt(pageStr));
            req.setAttribute("goodList",goodList);
            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }*/
    public void selectGood(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pageStr = req.getParameter("page");
        pageStr = pageStr==null?"1":pageStr;
        List<WxbGood> goodList = goodsService.queryGoodByPage(Integer.parseInt(pageStr));
        req.setAttribute("goodList",goodList);
        req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
    }


    public void insertGood(HttpServletRequest req, HttpServletResponse resp){
        String goodId = UUID.randomUUID().toString().substring(0,8);
        String goodName = req.getParameter("goodName");
        String customerId = req.getParameter("customerId");
        String goodPic = req.getParameter("goodPic");
        String goodPic1 = req.getParameter("goodPic1");
        String goodPic2 = req.getParameter("goodPic2");
        String promoteDesc = req.getParameter("promoteDesc");
        String skuTitle = req.getParameter("skuTitle");
        String skuCost = req.getParameter("skuCost");
        String skuPrice = req.getParameter("skuPrice");
        String skuPmoney = req.getParameter("skuPmoney");
        String copyIds = req.getParameter("copyIds");
        String copyDesc = req.getParameter("copyDesc");
        String forwardLink = req.getParameter("forwardLink");
        String sorderNo = req.getParameter("orderNo");
        long orderNo = Long.parseLong(sorderNo);
        String typeId = req.getParameter("typeId");
        String tags = req.getParameter("tags");
        String sstate = req.getParameter("state");
        long state = Long.parseLong(sstate);
        String createTime = req.getParameter("createTime");
        String stoped = req.getParameter("toped");
        long toped = Long.parseLong(stoped);
        String srecomed = req.getParameter("recomed");
        long recomed = Long.parseLong(srecomed);
        String topedTime = req.getParameter("topedTime");
        String recomedTime = req.getParameter("recomedTime");
        String spcId = req.getParameter("spcId");
        String zonId = req.getParameter("zonId");
        String ssellNum = req.getParameter("sellNum");
        long sellNum = Long.parseLong(ssellNum);
        String website = req.getParameter("website");
        String siswxpay = req.getParameter("iswxpay");
        long iswxpay = Long.parseLong(siswxpay);
        String sisfdfk = req.getParameter("isfdfk");
        long isfdfk = Long.parseLong(sisfdfk);
        String sleixingId = req.getParameter("leixingId");
        long leixingId = Long.parseLong(sleixingId);
        String kfqq = req.getParameter("kfqq");
        WxbGood good = new WxbGood(goodId, goodName, customerId, goodPic,
                goodPic1, goodPic2, promoteDesc, skuTitle,
                skuCost, skuPrice, skuPmoney, copyIds,
                copyDesc, forwardLink,orderNo, typeId,
                tags,state, Timestamp.valueOf(createTime) , toped, recomed,
                Timestamp.valueOf(topedTime), Timestamp.valueOf(recomedTime), spcId, zonId,
                sellNum, website, iswxpay, isfdfk, leixingId, kfqq);
        //通过Service添加商品
        goodsService.insertGood(good);


    }
}
