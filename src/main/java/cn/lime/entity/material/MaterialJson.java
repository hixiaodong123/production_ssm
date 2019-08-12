package cn.lime.entity.material;

import java.util.List;

public class MaterialJson {
    private long total;

    private List<Material> rows;


    public List<Material> getRows() {
        return rows;
    }

    public void setRows(List<Material> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}