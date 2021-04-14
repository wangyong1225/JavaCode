package com.wy.service.impl;

import com.wy.dao.GoodsDao;
import com.wy.dao.SaleDao;
import com.wy.domain.Goods;
import com.wy.domain.Sale;
import com.wy.service.BuyGoodsService;
import com.wy.service.NotEnoughException;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public void buy(Integer goodsId, Integer amount) {
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(amount);
        saleDao.insertDao(sale);
        Goods goods = goodsDao.selectGoods(goodsId);
        if(null == goods){
            throw new NotEnoughException("无此商品");
        }
        if(amount > goods.getAmount()){
            throw new NotEnoughException("库存不够");
        }
        goods = new Goods();
        goods.setId(goodsId);
        goods.setAmount(amount);
        goodsDao.updateGoods(goods);

    }
}
