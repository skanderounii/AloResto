
package com.aloresto.entites;


public class Route {
    
private int ref_route;
private String localisation;

    public Route() {
    }

    public Route(int ref_route, String localisation) {
        this.ref_route = ref_route;
        this.localisation = localisation;
    }

    public Route(String localisation) {
        this.localisation = localisation;
    }

    public Route(int ref_route) {
        this.ref_route = ref_route;
    }

    public int getRef_route() {
        return ref_route;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setRef_route(int ref_route) {
        this.ref_route = ref_route;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Route{" + "ref_route=" + ref_route + ", localisation=" + localisation + '}';
    }


    
}
