This is a sample application to reproduce a problem with timers. There are one stateless EJB with timers and one statful without timers. Both are injected in a servlet. 
When from the stateless EJB TimerService.getAllTimers() is called, an IllegalStateException is thrown. 

According to the EJB 3.2 specification, the TimerService.getAllTimers() method should return active timers associated with the beans in the same module in which the caller bean is packaged. 