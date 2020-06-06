package br.com.kolibri.kolibri.airlines.route.request;

public class RouteRequest {
    private String departureTime;
    private String arrivalTime;
    private String originIcao;
    private String destinationIcao;
    private int cargo;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOriginIcao() {
        return originIcao;
    }

    public void setOriginIcao(String originIcao) {
        this.originIcao = originIcao;
    }

    public String getDestinationIcao() {
        return destinationIcao;
    }

    public void setDestinationIcao(String destinationIcao) {
        this.destinationIcao = destinationIcao;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
