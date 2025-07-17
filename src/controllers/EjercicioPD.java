package controllers;
import java.util.Map;
import java.util.HashMap;

public class EjercicioPD {
    private Map<Integer,Integer> map;
    public EjercicioPD(){
        this.map = new HashMap<>();
    }
    public long getFibonacci(int n){
        if (n<=1) return n;
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
    public long getFibonacciPD(int n){
        Map<Integer,Long> cache = new HashMap<>();
        if (n<=1) return n;
        cache.put(0,1L);
        return getFibonacciPDHelper(n, cache);
    }
    public long getFibonacciPDHelper(int n, Map<Integer,Long> cache){
        if(n<=1) return n;
        if(cache.containsKey(n)) return cache.get(n);
        long result = getFibonacciPDHelper(n-1, cache) + getFibonacciPDHelper(n-2, cache);
        cache.put(n, result);
        return result;
    }
}