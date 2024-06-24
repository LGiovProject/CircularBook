package com.ispw.circularbook.engineering.decorator;

import com.ispw.circularbook.view.cli.CLISearchBookView;

public class CLISearchBookDecorator extends Decorator{

    private CLISearchBookView cliSearchBookView;

    public CLISearchBookDecorator(ICLISearchBookComponent icliSearchBookComponent)
    {
        super(icliSearchBookComponent);
    }

    @Override
    public void start()
    {

    }

    public void command(int i)
    {
        if(i>=0)
        {

        }
        else
        {

        }
    }
}
