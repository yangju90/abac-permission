package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * Organization
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@TableName("t_organization")
public class Organization extends BaseModel implements Serializable {

    private Long accountId;

    private String name;

    /**
     * S: subject orgs R: Resource orgs ... 
     */
    private String type;

    /**
     * 1: active 0: Inactive
     */
    private Integer status;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Organization{" +
            "accountId=" + accountId +
            ", name=" + name +
            ", type=" + type +
            ", status=" + status +
        "}";
    }

}
