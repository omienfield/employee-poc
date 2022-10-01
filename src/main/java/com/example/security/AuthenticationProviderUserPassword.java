package com.example.security;

import com.example.repository.UserRepository;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    UserRepository userRepository;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            String username = (String) authenticationRequest.getIdentity();
            String pw = (String) authenticationRequest.getSecret();

            boolean validCredentials = userRepository.getUser(username, pw) == null ? false : true;
            if (validCredentials) {
//                emitter.onNext(new UserDetails(username, accountRepository.getRolesForUser(username)));
                emitter.onNext(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}
