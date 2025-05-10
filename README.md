# Create Spring Boot REST API with Request or Query Parameters

Sometimes the client send a request, the request url contains a query parameter, so lets see how to use @RequestParam annotation to extract query parameters from the request url


- Craete a REST API that handles query parameters in he request URL
- Create the method s a `Student` with a new method name as `studentRequestVariable` and pass `id` as a method argument

### Ref Path/ Code:

```diff
springboot-rest-api\springboot-rest-api\src\main\java\net\javaguides\springboot\controller\StudentController.java
```

```bash
    // Spring boot REST API with Request Param
    // http://localhost:8080/students?id=1
    // id=1 is the query parameter
    public Student studentRequestVariable(int id){
        
    }
```

- Return a new `Student` , pass `id` dynamically

```diff
 return new Student("John", "Doe", id)
```

```bash
    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1
    // id=1 is the query parameter
    
    public Student studentRequestVariable(int id){
        return new Student("John", "Doe", id)
    }
```

- Using `@GetMapping` annotation to map incoming http request to this method

```diff
    @GetMapping("students/query")
```

```bash 
    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1
    // id=1 is the query parameter
    @GetMapping("students/query")
    public Student studentRequestVariable(int id){
        return new Student("John", "Doe", id)
    }
```

- We need to bind the value of this query parameter `/id=1`, to the method argument `(int id)`, so we use the `@RequestParam`

```diff
studentRequestVariable(@RequestParam int id)
```

```bash
    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1
    // id=1 is the query parameter
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student("John", "Doe", id);
    }

```

- Lets see how to handle multiple query parameters in a request URL

i.e  // http://localhost:8080/students/query?id=1&firstName=Doe&lastName=John

```diff
 public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName)
```

```bash
    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Doe&lastName=John
    // id=1 is the query parameter
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(lastName, firstName, id);
    }
```

Now, we have created a REST API that can handle multiple query parameters in a request URL 


## Note 
PathVariable annotaion is used to bind the URL variable into method argument
 
While

RequestParam annotation is used to extract the value of query parameter in a request URL

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update `tests` as appropriate.

## License

***
