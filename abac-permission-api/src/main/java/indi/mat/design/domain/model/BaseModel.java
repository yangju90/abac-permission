package indi.mat.design.domain.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

/**
 * @author Mat
 * @version : BaseModel, v 0.1 2022-11-26 0:27 Yang
 */
public class BaseModel {
    // ID
    @TableId
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    // 逻辑删除 1 为删除 0 为正常
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean deleted = false;

    // 插入记录的用户名
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String inUser;

    // 插入记录的时间
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date inDate;

    // 最后一次修改的用户名
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String lastEditUser;

    // 最后一次修改的时间
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date lastEditDate;


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

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
