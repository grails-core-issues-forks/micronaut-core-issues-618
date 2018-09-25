package com.framework;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
//import io.micronaut.security.Secured;
import io.micronaut.views.ModelAndView;

import javax.annotation.Nullable;
import java.util.Date;

@Secured("isAnonymous()")
@Controller(value = "/demo")
public class DemoController {

    @Get(value = "/demo1")
    ModelAndView demo1() {
        return new ModelAndView("/login", CollectionUtils.mapOf("name", "lwj", "date", new Date()));
    }

    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Post(value = "/demo1")
    ModelAndView postDemo1(@Nullable @Body LoginCommand command) {
        return new ModelAndView("login", CollectionUtils.mapOf("date", new Date()));
    }

}
