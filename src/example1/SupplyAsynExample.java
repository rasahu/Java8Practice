package example1;

/*package whatever //do not write package name here */

import java.util.concurrent.*; 
  
class SupplyAsynExample { 
    public static void main(String[] args) throws Exception 
    { 
        CompletableFuture<String> helloFuture 
            = CompletableFuture.supplyAsync(() -> "Hello"); 
        CompletableFuture<String> greetingFuture 
            = CompletableFuture.supplyAsync(() -> "World"); 
  
        CompletableFuture<String> combinedFuture 
            = helloFuture.thenCombine( 
                greetingFuture, (m1, m2) -> m1 + " " + m2); 
  
        System.out.println(combinedFuture.get()); 
    } 
}