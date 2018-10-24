package com.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Concurrency{
    Map<Integer,Product> cache = new HashMap<>();

    CompletableFuture<Product> getProduct(int id) throws InterruptedException {
        Product product= getProductLocal(id);
        if(product !=null) {
            return CompletableFuture.completedFuture(product);
        }else{
            CompletableFuture<Product> future = new CompletableFuture<>();
            product= getProductRemote(id);
            cache.put(id,product);
          if (!future.complete(product)){
              System.out.println("Future is not completed");
          }else{
              System.out.println("Future Completed "+product.id+" "+product.name);
          }
            return future;
        }
    }

   Product getProductLocal(Integer id){
        return cache.get(id);
    }

    Product getProductRemote(int id) throws InterruptedException{
        try{
        Thread.sleep(100);
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
      this.name = name;
    }
    }
}
