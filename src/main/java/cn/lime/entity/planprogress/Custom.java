package cn.lime.entity.planprogress;

/**
 * 客户管理实体类
 */
public class Custom {
    private String customId;

    private String customName;

    private String fullName;

    private String address;

    private String fax;

    private String email;

    private String ownerName;

    private String ownerTel;

    private Integer status;

    private String note;

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Custom{");
        sb.append("customId='").append(customId).append('\'');
        sb.append(", customName='").append(customName).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", fax='").append(fax).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", ownerName='").append(ownerName).append('\'');
        sb.append(", ownerTel='").append(ownerTel).append('\'');
        sb.append(", status=").append(status);
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}