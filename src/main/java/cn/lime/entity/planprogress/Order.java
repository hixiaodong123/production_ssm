package cn.lime.entity.planprogress;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单管理实体类
 */
public class Order {

    /**
     * 添加的附属类
     */

    private Product product;
    private Custom custom;

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("product=").append(product);
        sb.append(", custom=").append(custom);
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append(", customId='").append(customId).append('\'');
        sb.append(", productId='").append(productId).append('\'');
        sb.append(", orderDate=").append(orderDate);
        sb.append(", requestDate=").append(requestDate);
        sb.append(", note='").append(note).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", unit='").append(unit).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", file='").append(file).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Custom getCustom()
    {
        return custom;
    }

    public void setCustom(Custom custom)
    {
        this.custom = custom;
    }

    private String orderId;

    private String customId;

    private String productId;

    private Date orderDate;

    private Date requestDate;

    private String note;

    private Integer quantity;

    private BigDecimal unitPrice;

    private String unit;

    private String image;

    private String file;

    private Integer status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}