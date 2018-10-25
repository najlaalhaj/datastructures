package com.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class Concurrency{
    Map<Integer,Product> cache = new HashMap<>();

    CompletableFuture<Product> getProduct(int id) throws InterruptedException {
        Product product= getProductLocal(id);
        try{
        if(product !=null) {
            return CompletableFuture.completedFuture(product);
        }else{
            return CompletableFuture.supplyAsync(() ->{
                Product product1= null;
                try {
                    product1 = getProductRemote(id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cache.put(id,product1);
                System.out.println("Product id "+cache.get(66).id+" Product name : "+cache.get(66).name);
                return product1;
            });
        }
        }catch (Exception e){
            CompletableFuture future = new CompletableFuture();
            if(future.completeExceptionally(e)){
                System.out.println("Exception");
            }
            return future;
        }
    }

   Product getProductLocal(Integer id){
        return cache.get(id);
    }

    Product getProductRemote(int id) throws InterruptedException{
        try{
        sleep(100);
        if(id==666){
            throw new RuntimeException("Bad Request");
        }
        }catch(InterruptedException ignored){
            //do nothing
        }
        return  new Product(id,"product");

    }

  private class Product {

    int id;
    String name;

    Product(int id, String string) {
      this.id = id;
      this.name = string;
    }
    }

    //Sync Completed Futures

    String returnString(){
        try{
            sleep(100);
        }catch(InterruptedException e){
            //dp nothing
        }
         return "42";
    }

    void  syncFutures(){
    CompletableFuture.supplyAsync(this::returnString)
                .thenApply(Integer::parseInt)
                .thenApply(x -> x*2)
                .thenAccept(System.out::println)
                .join();
        System.out.println("running....");
    }
}
