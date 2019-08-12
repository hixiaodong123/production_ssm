package cn.lime.entity.planprogress;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 生产计划管理实体类
 */
public class Manufacture
{
    private String manufactureSn;

    private String orderId;

    private String technologyId;

    private Integer launchQuantity;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    public String getManufactureSn()
    {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn)
    {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTechnologyId()
    {
        return technologyId;
    }

    public void setTechnologyId(String technologyId)
    {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getLaunchQuantity()
    {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity)
    {
        this.launchQuantity = launchQuantity;
    }

    public Date getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}