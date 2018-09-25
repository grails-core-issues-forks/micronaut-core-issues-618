package com.framework;

import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if ( authenticationRequest.getIdentity().equals("liwujun") &&
                authenticationRequest.getSecret().equals("123") ) {
            UserDetails userDetails = new UserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>());
            return Flowable.just(userDetails);
        }
        return Flowable.just(new AuthenticationFailed());
    }
}
