package com.common.utils;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class ThreadPoolUtil {  
  
     private volatile static ThreadPoolUtil instance;  
     private ThreadPoolUtil(){}  
     private static ExecutorService threadPool;  
       
       
     public static ThreadPoolUtil getInstance(){  
         if(instance==null){  
             synchronized (ThreadPoolUtil.class) {  
                  instance=new ThreadPoolUtil();  
                 threadPool=Executors.newCachedThreadPool();  
            }  
         }  
         return instance;  
     }  
       
    public void excute(Runnable runnable){  
        threadPool.execute(runnable);  
    }  
      
    public void shutdown(){  
        threadPool.shutdown();  
    }  
      
    public boolean isActive(){  
        if(threadPool.isTerminated()){  
            return false;  
        }  
        return true;  
    }  
}  