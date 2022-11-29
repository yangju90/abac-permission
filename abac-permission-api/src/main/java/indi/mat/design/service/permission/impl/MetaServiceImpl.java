package indi.mat.design.service.permission.impl;

import com.mysql.cj.xdevapi.ExprUnparser;
import indi.mat.design.domain.model.permission.MetaData;
import indi.mat.design.domain.model.user.Account;
import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.domain.model.user.TrdParty;
import indi.mat.design.service.permission.IMetaService;
import indi.mat.design.service.user.IAccountService;
import indi.mat.design.service.user.IOrganizationService;
import indi.mat.design.service.user.ITrdPartyService;
import org.apache.ibatis.ognl.MemberAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mat
 * @version : MetaServiceImpl, v 0.1 2022-11-30 0:12 Yang
 */

@Service
public class MetaServiceImpl implements IMetaService {

    @Autowired
    IAccountService accountService;

    @Autowired
    IOrganizationService organizationService;

    @Autowired
    ITrdPartyService trdPartyService;

    @Override
    public MetaData getMetaDataByAccountId(Long accountId) {
        MetaData metaData = new MetaData();
        Account account = accountService.selectById(accountId);
        if (account == null) throw new RuntimeException("Account Id " + accountId + "Not Exists!");

        metaData.setAccount(account);

        Organization organization = organizationService.getOrganizationByAccountId(accountId);
        metaData.setOrganization(organization);

        TrdParty trdParty = trdPartyService.getTrdPartyAccountId(accountId);
        metaData.setTrdParty(trdParty);

        return metaData;
    }
}
