package com.example.libraryManagement.service;

import java.io.OutputStream;
import java.util.List;

public interface IWriteEcxelService<T> {
    void writeExcelFile(List<T> list, OutputStream excelOutputStream, Class<T> tClass);
}
