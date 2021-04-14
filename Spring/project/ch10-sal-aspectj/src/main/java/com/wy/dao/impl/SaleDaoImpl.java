package com.wy.dao.impl;

import com.wy.dao.SaleDao;
import com.wy.domain.Sale;

public class SaleDaoImpl implements SaleDao {

    private SaleDao saleDao;

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public int insertDao(Sale sale) {
        int num = saleDao.insertDao(sale);
        return num;
    }
}
