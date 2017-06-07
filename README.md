# Spring Boot - Example of Async rest controller

##### This project demonstrates three ways to return result into browser. 

* Blocking result (BlockingUserController) - Synchronous long running task. The task must be end before return results.
* Async result (CallableUserController) - Asynchronous task. Spring runs the task defined in Callable in another Thread. In first step controller return empty results, client is still waiting for requested data, next server returns values after end the long running task.
* Async result (DeferredUserController) - Asynchronous task. It is very similar to Callable but in addiction we can manage the thread.