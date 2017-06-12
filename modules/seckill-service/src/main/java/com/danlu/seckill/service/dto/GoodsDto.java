package com.danlu.seckill.service.dto;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/6/12.
 */
public class GoodsDto implements Serializable {

    private int id;

    private String title;

    private String name;

    private String summary;

    private boolean putaway;

    private boolean seckill;

    private SeckillDto seckillDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPutaway() {
        return putaway;
    }

    public void setPutaway(boolean putaway) {
        this.putaway = putaway;
    }

    public boolean isSeckill() {
        return seckill;
    }

    public void setSeckill(boolean seckill) {
        this.seckill = seckill;
    }

    public SeckillDto getSeckillDto() {
        return seckillDto;
    }

    public void setSeckillDto(SeckillDto seckillDto) {
        this.seckillDto = seckillDto;
    }
}
