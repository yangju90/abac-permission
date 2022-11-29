package indi.mat.design.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import indi.mat.design.domain.model.BaseModel;

import java.io.Serializable;

/**
 * <p>
 * 3rd-Party
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@TableName("t_trd_party")
public class TrdParty extends BaseModel implements Serializable {


    private Long accountId;

    private String trdPartyId;

    private String trdPartyName;

    private Integer typeId;

    private String typeName;

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
    public String getTrdPartyId() {
        return trdPartyId;
    }

    public void setTrdPartyId(String trdPartyId) {
        this.trdPartyId = trdPartyId;
    }
    public String getTrdPartyName() {
        return trdPartyName;
    }

    public void setTrdPartyName(String trdPartyName) {
        this.trdPartyName = trdPartyName;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrdParty{" +
            "accountId=" + accountId +
            ", trdPartyId=" + trdPartyId +
            ", trdPartyName=" + trdPartyName +
            ", typeId=" + typeId +
            ", typeName=" + typeName +
            ", status=" + status +
        "}";
    }

}
