package com.ispw.circularbook.engineering.decorator;

public abstract class Decorator implements SignInComponent {

    private SignInComponent signInComponent;

//    protected Decorator(SignInComponent signInComponent){this.signInComponent = signInComponent;}

    @Override
    public String getInfo() {
        return "";
    }
}
