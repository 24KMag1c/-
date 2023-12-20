package Manage;

import item.Bus;
import java.util.ArrayList;

public interface M_Bus {
    public abstract ArrayList<Bus> findAll();

    public abstract Bus findByLocation(String Location);

    //    新增信息
    public abstract int insert(Bus bus);

    //    修改信息
    public abstract int update(Bus bus);
}

