package com.dev.nguyenvantung.fg_app.data.model.hoatdong;


import com.dev.nguyenvantung.fg_app.data.model.hocky.HocKy;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoatDong {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("from_date")
    @Expose
    private Date fromDate;
    @SerializedName("end_date")
    @Expose
    private Date endDate;
    @SerializedName("hoc_ky")
    @Expose
    private HocKy hocKy;
    @SerializedName("hoatdong_type")
    @Expose
    private HoatDongType hoatdongType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HocKy getHocKy() {
        return hocKy;
    }

    public void setHocKy(HocKy hocKy) {
        this.hocKy = hocKy;
    }

    public Object getHoatdongType() {
        return hoatdongType;
    }

    public void setHoatdongType(HoatDongType hoatdongType) {
        this.hoatdongType = hoatdongType;
    }

}
