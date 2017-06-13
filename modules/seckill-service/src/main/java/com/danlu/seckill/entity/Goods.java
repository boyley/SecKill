package com.danlu.seckill.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品表
 * Created by lenovo on 2017/6/11.
 */
@Entity
public class Goods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20)
    private String title;

    @Column(length = 20)
    private String name;

    @Column(length = 50)
    private String summary;

    @Column
    private boolean putaway;

    @Column
    private boolean seckill;

    @Transient
    private Seckill seckilled;

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

    public Seckill getSeckilled() {
        return seckilled;
    }

    public void setSeckilled(Seckill seckilled) {
        this.seckilled = seckilled;
    }
}
