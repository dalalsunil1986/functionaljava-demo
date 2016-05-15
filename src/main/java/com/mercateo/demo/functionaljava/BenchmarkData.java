package com.mercateo.demo.functionaljava;

import fj.Ord;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@State(Scope.Benchmark)
public class BenchmarkData {

    private final fj.data.Array<Integer> functionalJavaArray;
    private final javaslang.collection.Array<Integer> javaSlangArray;
    private final ArrayList<Integer> arrayList;
    private final javaslang.collection.List<Integer> javaSlangList;
    private final javaslang.collection.HashMap<String, Integer> javaSlangMap;
    private final fj.data.List<Integer> functionalJavaList;
    private final fj.data.HashMap<String, Integer> functionalJavaHashMap;
    private final fj.data.TreeMap<String, Integer> functionalJavaTreeMap;
    private final LinkedList<Integer> linkedList;
    private final HashMap<String, Integer> hashMap;
    private final ConcurrentHashMap<String, Integer> concurrentHashMap;


    public BenchmarkData() {
        final int size = 1000;
        final int maximum = 100;
        final int minimum = -100;

        final Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {

            Random rn = new Random();
            int range = maximum - minimum + 1;
            data[i] = rn.nextInt(range) + minimum;
        }

        final List<Integer> dataList = Arrays.asList(data);
        arrayList = new ArrayList<>(dataList);
        linkedList = new LinkedList<>(dataList);
        hashMap = new HashMap<>();
        concurrentHashMap = new ConcurrentHashMap<>();

        functionalJavaArray = fj.data.Array.array(data);
        functionalJavaList = fj.data.List.list(data);
        functionalJavaHashMap = fj.data.HashMap.hashMap();
        functionalJavaTreeMap = fj.data.TreeMap.treeMap(Ord.<String>hashOrd());

        javaSlangArray = javaslang.collection.Array.of(data);
        javaSlangList = javaslang.collection.List.of(data);
        javaSlangMap = javaslang.collection.HashMap.empty();
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public ConcurrentHashMap<String, Integer> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public fj.data.Array<Integer> getFunctionalJavaArray() {
        return functionalJavaArray;
    }

    public fj.data.List<Integer> getFunctionalJavaList() {
        return functionalJavaList;
    }

    public fj.data.HashMap<String, Integer> getFunctionalJavaHashMap() {
        return functionalJavaHashMap;
    }

    public fj.data.TreeMap<String, Integer> getFunctionalJavaTreeMap() {
        return functionalJavaTreeMap;
    }

    public javaslang.collection.Array<Integer> getJavaSlangArray() {
        return javaSlangArray;
    }

    public javaslang.collection.List<Integer> getJavaSlangList() {
        return javaSlangList;
    }

    public javaslang.collection.HashMap<String, Integer> getJavaSlangMap() {
        return javaSlangMap;
    }
}
