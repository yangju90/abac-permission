package indi.mat.design.domain.model;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Mat
 * @version : BaseModel, v 0.1 2022-11-26 0:27 Yang
 */
public class BaseModel {
    // ID
    @TableId(type = IdType.AUTO)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    // 逻辑删除 1 为删除 0 为正常
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean deleted = false;

    // 插入记录的用户名
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String inUser;

    // 插入记录的时间
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Long inDate;

    // 最后一次修改的用户名
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String lastEditUser;

    // 最后一次修改的时间
    @OrderBy
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long lastEditDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public Long getInDate() {
        return inDate;
    }

    public void setInDate(Long inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public Long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
