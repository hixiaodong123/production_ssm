package cn.lime.entity.material;

import java.util.List;

public class MaterialReceiveJson {
    private long total;

    private List<MaterialReceives> rows;


    public List<MaterialReceives> getRows() {
        return rows;
    }

    public void setRows(List<MaterialReceives> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}