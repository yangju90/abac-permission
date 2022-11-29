package indi.mat.design.domain.model.permission;

import indi.mat.design.domain.model.user.Account;
import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.domain.model.user.TrdParty;

/**
 * @author Mat
 * @version : MetaData, v 0.1 2022-11-30 0:20 Yang
 */
public class MetaData {

    private Account account;
    private TrdParty trdParty;
    private Organization organization;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TrdParty getTrdParty() {
        return trdParty;
    }

    public void setTrdParty(TrdParty trdParty) {
        this.trdParty = trdParty;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String composeApiSubString(){
        StringBuilder ans = new StringBuilder().append(account.getId());
        return ans.toString();
    }

    public String composeDomainString(){
        if(organization == null || trdParty == null) return "";
        StringBuilder ans = new StringBuilder().append(organization.getName())
                .append("::")
                .append(trdParty.getTrdPartyName());

        return ans.toString();
    }
}
