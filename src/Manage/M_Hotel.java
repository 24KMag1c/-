package Manage;

import item.Hotel;

import java.util.ArrayList;

public interface M_Hotel {
    public abstract ArrayList<Hotel> findAll();

    public abstract Hotel findByLocation(String location);

    public abstract int insert(Hotel hotel);

    public abstract int update(Hotel hotel);
}

