package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.permission.MetaData;
import indi.mat.design.domain.model.user.TrdParty;
import indi.mat.design.domain.persist.user.TrdPartyMapper;
import indi.mat.design.dto.request.user.form.TrdPartyForm;
import indi.mat.design.dto.request.user.query.TrdPartyQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.ITrdPartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 3rd-Party 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class TrdPartyServiceImpl extends BaseServiceImpl<TrdParty, TrdPartyForm, TrdPartyQuery> implements ITrdPartyService {

    private static final Logger logger = LoggerFactory.getLogger(TrdPartyServiceImpl.class);

    @Autowired
    private TrdPartyMapper mapper;

    @Override
    protected BaseMapper<TrdParty> mapper() {
        return mapper;
    }

    @Override
    protected TrdParty model() {
        return new TrdParty();
    }

    @Override
    public TrdParty getTrdPartyAccountId(Long accountId) {
        LambdaQueryWrapper<TrdParty> wapper = new LambdaQueryWrapper<>();
        wapper.eq(TrdParty :: getAccountId, accountId);
        TrdParty trdParty = mapper.selectOne(wapper);
        return trdParty;
    }
}
