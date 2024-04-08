package com.ispw.circularbook.engineering.observer;

public abstract class Subject {

    void register(Observer o){};
    void unregister(Observer o){};
    void notifyObserver(Object object1, Object object2){};
    void notifyObserver(Object object1, Object object2,Object object3){};
}
