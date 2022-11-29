package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * Application Info
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@TableName("t_application")
public class Application extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
            "name=" + name +
            ", status=" + status +
        "}";
    }

}
