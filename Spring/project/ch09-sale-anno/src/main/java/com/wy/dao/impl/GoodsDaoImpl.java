package com.wy.dao.impl;

import com.wy.dao.GoodsDao;
import com.wy.domain.Goods;

public class GoodsDaoImpl implements GoodsDao {

    private GoodsDao goodsDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public int updateGoods(Goods goods) {
        int num = goodsDao.updateGoods(goods);
        return num;
    }

    @Override
    public Goods selectGoods(Integer goodsId) {
        Goods goods = goodsDao.selectGoods(goodsId);
        return null;
    }
}
