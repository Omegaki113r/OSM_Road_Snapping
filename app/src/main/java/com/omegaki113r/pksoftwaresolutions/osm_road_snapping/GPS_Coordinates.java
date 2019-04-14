package com.omegaki113r.pksoftwaresolutions.osm_road_snapping;

public class GPS_Coordinates {

    private double lattitude,longitude;

    GPS_Coordinates(double lat,double lng){
        lattitude = lat;
        longitude = lng;
    }

    double getLattitude(){
        return lattitude;
    }

    double getLongitude(){
        return longitude;
    }

    void setLattitude(double lat){
        lattitude = lat;
    }

    void setLongitude(double lng){
        longitude = lng;
    }

    @Override
    public String toString() {
        return String.valueOf(lattitude)+","+String.valueOf(longitude);
    }
}
