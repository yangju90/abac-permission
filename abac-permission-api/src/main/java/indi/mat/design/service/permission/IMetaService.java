package indi.mat.design.service.permission;

import indi.mat.design.domain.model.permission.MetaData;

/**
 * @author Mat
 * @version : IMetaService, v 0.1 2022-11-30 0:12 Yang
 */
public interface IMetaService {
     MetaData getMetaDataByAccountId(Long accountId);
}
