package com.jack.mc.cyg.retrofittestproject.model;

import com.jack.mc.cyg.retrofittestproject.base.BaseRetData;

import java.util.List;

/**
 *
 */
public class GitModel extends BaseRetData {

    private List<Item> data;

    public GitModel() {

    }

    public List<Item> getData() {
        return data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }
}