package com.framework;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
//import io.micronaut.security.Secured;
import io.micronaut.views.View;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Secured("isAnonymous()")
@Controller("/login")
public class LoginAuthController {

    @Get("/auth")
    @View("auth")
    public Map<String, Object> auth() {
        return new HashMap<>();
    }

    @Get("/authFailed")
    @View("auth")
    public Map<String, Object> authFailed() {
        return Collections.singletonMap("errors", true);
    }
}
