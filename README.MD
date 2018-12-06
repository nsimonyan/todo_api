# TODO API

Do simple crud operations :

### Prerequisites


```
JDK 1.8
Maven 3.2+
```



### API
REQUIRED HEADER
content-type : application/json;charset=UTF-8


GET REQUESTS

Get all todos
http://localhost:9090/todos

Get not done todos
http://localhost:9090/todos/not_done

Get done todos count
http://localhost:9090/todos/done_count

Get todo by id
http://localhost:9090/todos/{id}

DELETE REQUESTS

delete by id
http://localhost:9090/todos/delete/{id}

POST REQUESTS
http://localhost:9090/todos/

Body should be json . Example :
 {"name":"Read book", "done":false}

PUT REQUESTS
http://localhost:9090/todos/update/{id}

Body should be json . Example :
 {"name":"Read book", "done":false}
Also {id}  is not required . If todo exists with id update else create

PATCH REQUESTS
http://localhost:9090/todos/update/{id}
Body should be json . Example :
 {"name":"Read book", "done":false}

 Id required

