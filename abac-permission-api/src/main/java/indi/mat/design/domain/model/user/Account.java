package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * Account
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@TableName("t_account")
public class Account extends BaseModel implements Serializable {

    private Long userId;

    private Integer appId;

    private String appName;

    /**
     * 3rd party / local / Nas Or Other
     */
    private Integer typeId;

    /**
     * name
     */
    private String typeName;

    private String avatar;

    /**
     * 1: active 0: Inactive
     */
    private Integer status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
            "userId=" + userId +
            ", appId=" + appId +
            ", appName=" + appName +
            ", typeId=" + typeId +
            ", typeName=" + typeName +
            ", avatar=" + avatar +
            ", status=" + status +
        "}";
    }

}
