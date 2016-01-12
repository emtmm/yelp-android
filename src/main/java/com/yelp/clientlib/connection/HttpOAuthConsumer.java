package com.yelp.clientlib.connection;

import com.squareup.okhttp.Request;

import oauth.signpost.http.HttpRequest;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

/**
 * {@link HttpOAuthConsumer} is an {@link oauth.signpost.OAuthConsumer} implementation to sign OkHttp {@link Request}s.
 */
public class HttpOAuthConsumer extends OkHttpOAuthConsumer {

    public HttpOAuthConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    @Override
    protected HttpRequest wrap(Object request) {
        return new HttpRequestAdapter((Request) request);
    }
}