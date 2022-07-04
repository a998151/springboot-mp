package com.example.springbootmp.commandredis;

/**
 * @author BCY
 */
public interface Command<T> {

    public T exec();
}
