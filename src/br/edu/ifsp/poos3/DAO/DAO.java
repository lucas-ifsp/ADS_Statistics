package br.edu.ifsp.poos3.DAO;

import java.util.List;
import java.util.Map;

public interface DAO <T, K> {
    void export(List<T> list, String destinationPath);
    Map<K, T> importAsMap(String sourcePath);
    List<T> importAsList(String sourcePath);
}
