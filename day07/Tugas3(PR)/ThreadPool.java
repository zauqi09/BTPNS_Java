class ThreadPool implements Runnable {  
    private String message;  
    public ThreadPool(String s){  
        this.message=s;  
    }  
     public void run() {  
        System.out.println(message);  
        //processmessage();
    }  
    private void processmessage() {  
        try {  Thread.sleep(500);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}  