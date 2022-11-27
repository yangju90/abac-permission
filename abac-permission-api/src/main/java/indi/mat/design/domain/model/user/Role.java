package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * Role
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
@TableName("t_role")
public class Role extends BaseModel implements Serializable {

    private String name;

    private Integer node;

    private Integer parentNode;

    private String parentName;

    private String pathString;

    /**
     * 1: active 0: Inactive
     */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public Integer getParentNode() {
        return parentNode;
    }

    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPathString() {
        return pathString;
    }

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                ", node=" + node +
                ", parentNode=" + parentNode +
                ", parentName=" + parentName +
                ", pathString=" + pathString +
                ", status=" + status +
                "}";
    }

}
