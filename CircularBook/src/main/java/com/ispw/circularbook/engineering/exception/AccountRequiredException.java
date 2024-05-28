package com.ispw.circularbook.engineering.exception;

import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;

public class AccountRequiredException extends Exception{
    public AccountRequiredException(){
        super("account required!");
    }
}
