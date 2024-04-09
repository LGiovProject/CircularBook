package com.ispw.circularbook.engineering.observer.concreteSubject;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.Subject;

import java.util.ArrayList;

public class BookElementSubject extends Subject {

    private ArrayList<Observer> listObservers;

    public BookElementSubject() {

        listObservers = new ArrayList<>();

    }

    public void register(Observer newObserver) {

        listObservers.add(newObserver);
    }

    public void unregister(Observer deleteObserver) {
        int indexObserver= listObservers.indexOf(deleteObserver);
        listObservers.remove(indexObserver);
    }


    public void notifyObserver(Object object1,Object object2) {

        for(Observer observer : listObservers)
        {
            observer.update(object1,object2);
        }
    }

    public void notifyObserver(Object object) {

        for(Observer observer : listObservers)
        {
            observer.remove(object);
        }
    }


}
