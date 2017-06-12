package com.danlu.seckill.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by lenovo on 2017/6/12.
 */
public class SeckillDto implements Serializable{

    private int id;

    private int goodsId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
