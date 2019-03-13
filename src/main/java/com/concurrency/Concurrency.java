package com.concurrency;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class Concurrency{

  public static void main(String[] args){

      Supplier<List<Long>> supplyIDs =
        () -> {
        sleep(200);
        //throw new IllegalStateException("No data");
         return Arrays.asList(1L, 2L, 3L);
        };

    Function<List<Long>, List<User>> fetchedUSers =
        ids -> {
        sleep(300);
         return ids.stream().map(User:: new).collect(Collectors.toList());
    };
    Function<List<Long>,CompletableFuture<List<Email>>> fetchedEmails = ids->{
        Supplier<List<Email>> supplyEmails = () ->ids.stream().map(Email::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(supplyEmails);
      };

    Consumer<List<User>> displayUsers =
        users -> {
          users.forEach(System.out::println);
        };
    CompletableFuture<Void> start = new CompletableFuture();
    CompletableFuture<List<Long>> supply= start.thenApply(nil -> supplyIDs.get());
    CompletableFuture<List<User>> fetch = supply.thenApply(fetchedUSers);
    CompletableFuture<Void> display = fetch.thenAccept(displayUsers);
    start.complete(null);

      sleep(1_000);

      }

  private static void sleep(int millis){
      try{
          Thread.sleep(millis);
      }catch (InterruptedException e){

          throw new RuntimeException();
      }
  }
}
