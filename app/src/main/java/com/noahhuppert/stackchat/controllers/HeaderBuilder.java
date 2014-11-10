package com.noahhuppert.stackchat.controllers;

/**
 * Created by Noah Huppert on 11/9/2014.
 */

import com.noahhuppert.stackchat.models.KVPair;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;

/**
 * A Class very similar to StringBuilder but for building HTTP headers
 */
public class HeaderBuilder {
    /**
     * The headers
     */
    private ArrayList<KVPair> headers = new ArrayList<KVPair>();

    /* Constants */
    /**
     * The MIME type for Url encoded
     */
    public static String TYPE_URL_ENCODED = "application/x-www-form-urlencoded";

    /* Actions */
    /**
     * Adds a header
     * @param key The key of the header
     * @param value The value of the header
     * @return HeaderBuilder to make chaining possible
     */
    public HeaderBuilder put(String key, Object value){
        headers.add(new KVPair(key, value));

        return this;
    }

    /**
     * Converts the headers into Url encoded format
     * @return The headers in Url encoded format
     */
    public String toUrlEncoded(){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < headers.size(); i++){//Loop through headers
            KVPair currentHeader = headers.get(i);//Get current header

            //Put header into string
            builder.append(currentHeader.getKey())
                    .append("=")
                    .append(currentHeader.getValue());

            if(i != headers.size()){//If header is not the last, add a "&" to concatenate
                builder.append("&");
            }
        }

        return builder.toString();
    }

    public RequestBody toUrlEncodedAsBody(){
        RequestBody body = RequestBody.create(MediaType.parse(TYPE_URL_ENCODED), toUrlEncoded());

        return body;
    }
}