package cn.lime.entity.planprogress;

import java.util.List;

/**
 * @description: 页面显示返回的Bean对象
 * @author: Lime
 * @create: 2019-08-09 13:42
 **/

public class QueryList<T>
{
    private List<T> rows;
    private Long total;

    public List<T> getRows()
    {
        return rows;
    }

    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }

    public Long getTotal()
    {
        return total;
    }

    public void setTotal(Long total)
    {
        this.total = total;
    }
}
