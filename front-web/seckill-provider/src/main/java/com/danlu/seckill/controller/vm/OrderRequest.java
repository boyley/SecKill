package com.danlu.seckill.controller.vm;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/6/19.
 */
public class OrderRequest implements Serializable {

    private int goodsId;
    private int num;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
