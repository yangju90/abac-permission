package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.Account;
import indi.mat.design.dto.request.user.form.AccountForm;
import indi.mat.design.dto.request.user.query.AccountQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * Account ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/account")
public class AccountController extends BaseController {

    @Autowired
    private IAccountService service;

    @GetMapping("{id}")
    public Response<Account> getById(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<Account>> getPage(AccountQuery query) {
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody @Valid AccountForm form) {
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid AccountForm form) {
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.deleteById(id));
    }


}
