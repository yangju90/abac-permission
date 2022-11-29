package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * Organization Role
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@TableName("t_organization_role")
public class OrganizationRole extends BaseModel implements Serializable {

    private Long organizationId;

    private Long roleId;

    /**
     * 1: active 0: Inactive
     */
    private Integer status;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrganizationRole{" +
                "organizationId=" + organizationId +
                ", roleId=" + roleId +
                ", status=" + status +
                "}";
    }

}
