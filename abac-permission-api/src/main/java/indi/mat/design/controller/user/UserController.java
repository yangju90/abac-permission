package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.User;
import indi.mat.design.dto.request.user.form.UserForm;
import indi.mat.design.dto.request.user.query.UserQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * User ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public Response<User> getById(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<User>> getPage(UserQuery query) {
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody @Valid UserForm form) {
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid UserForm form) {
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.deleteById(id));
    }


}
