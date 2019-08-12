package cn.lime.entity.material;

public class OperateResponse {

    private Material data;
    private String msg;
    private int status;

    public Material getData() {
        return data;
    }

    public void setData(Material data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
