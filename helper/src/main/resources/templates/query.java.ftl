package ${package.Service};

import ${package.Entity}.${entity};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public class ${entity}Query extends BaseQuery<${entity}> {
    @Override
    public void setCustomerCondition() {

    }
}
</#if>
