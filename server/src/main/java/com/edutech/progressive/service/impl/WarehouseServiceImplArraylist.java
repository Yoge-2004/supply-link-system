package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService {

    private static List<Warehouse> warehouseList = new ArrayList<>();

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseList;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> sortedWarehouseList = new ArrayList<>(warehouseList);
        Comparator<Warehouse> capacityComparator = (w1, w2) -> Integer.compare(w1.getCapacity(), w2.getCapacity());

        sortedWarehouseList.sort(capacityComparator);
        return sortedWarehouseList;
    }

    public void emptyArrayList() {
        warehouseList = new ArrayList<>();     
    }

}