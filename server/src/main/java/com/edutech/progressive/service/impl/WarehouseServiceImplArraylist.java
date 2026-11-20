package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService {

    @Override
    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = new ArrayList<>();
        return warehouses;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> warehouses = new ArrayList<>();

        Comparator<Warehouse> capacityComparator = (w1, w2) -> Integer.compare(w1.getCapacity(), w2.getCapacity());

        warehouses.sort(capacityComparator);
        return warehouses;
    }

    public void emptyArrayList() {
        
    }

}