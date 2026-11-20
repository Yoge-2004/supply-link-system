package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplArraylist implements SupplierService {

    private static List<Supplier> supplierList = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierList;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return -1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {     

        Comparator<Supplier> supplierName = (s1, s2) -> s1.getSupplierName().compareTo(s2.getSupplierName());
        supplierList.sort(supplierName);
        return supplierList;
    }

    public void emptyArrayList() {
        supplierList = new ArrayList<>();
    }
}