package com.ispw.circularbook.engineering.decorator;

public abstract class Decorator implements ICLISearchBookComponent {

    private ICLISearchBookComponent icliSearchBookComponent;

    public Decorator(ICLISearchBookComponent icliSearchBookComponent)
    {
        this.icliSearchBookComponent=icliSearchBookComponent;
    }

    public void start(){}

    public void command(int i){}
}
