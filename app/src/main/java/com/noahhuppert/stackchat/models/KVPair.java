package com.noahhuppert.stackchat.models;

/**
 * Created by Noah Huppert on 11/9/2014.
 */

/**
 * A Class used to store key value data
 */
public class KVPair {
    /**
     * The key of the value
     */
    private String key;

    /**
     * The value of the pair
     */
    private Object value;

    /* Constructors */

    /**
     * Creates a key value pair
     * @param key {@link KVPair#key}
     * @param value {@link KVPair@value}
     */
    public KVPair(String key, Object value){
        this.key = key;
        this.value = value;
    }

    /* Getters */

    /**
     * Gets the key
     * @return {@link KVPair#key}
     */
    public String getKey(){
        return key;
    }

    /**
     * Gets the value
     * @return {@link KVPair#value}
     */
    public Object getValue(){
        return value;
    }

    /* Setters */

    /**
     * Sets the {@link KVPair#key}
     * @param key The value to the set the {@link KVPair#key} value
     */
    public void setKey(String key){
        this.key = key;
    }

    /**
     * Sets the {@link KVPair#value}
     * @param value The value to set the {@link KVPair#value} value
     */
    public void setValue(Object value){
        this.value = value;
    }
}