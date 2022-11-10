package com.example.springbootmp.dynamic;

/**
 * @author BCY
 */
@LogicRepository
public interface PersonManager {

    @LogicRef(code = "guy!")
    String say();
}
