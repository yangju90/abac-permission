package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.Account;
import indi.mat.design.domain.persist.user.AccountMapper;
import indi.mat.design.dto.request.user.form.AccountForm;
import indi.mat.design.dto.request.user.query.AccountQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Account 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountForm, AccountQuery> implements IAccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper mapper;

    @Override
    protected BaseMapper<Account> mapper() {
        return mapper;
    }

    @Override
    protected Account model() {
        return new Account();
    }

}
