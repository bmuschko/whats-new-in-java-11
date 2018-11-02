package com.bmuschko.java11.removals.corba;

import org.omg.CORBA.ORB;

class HelloImpl {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public String sayHello() {
        return "\nHello world !!\n";
    }

    public void shutdown() {
        orb.shutdown(false);
    }
}
