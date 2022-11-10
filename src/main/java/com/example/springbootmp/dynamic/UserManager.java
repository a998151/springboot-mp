package com.example.springbootmp.dynamic;

/**
 * @author BCY
 */
@LogicRepository
public interface UserManager {

    @LogicRef(code = "Marry")
    String so();
}
