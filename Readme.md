# Portfolio WEB

Author
Mauricio Cajamarca

## Total Hours
24 hours

External Tools Used
Postman - API Development Environment (Testing Docmentation)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.arc.sbtest.SBtemplateApplication class from your IDE.

Download the zip or clone the Git repository.
Unzip the zip file (if you downloaded one)
Open in your prefer IDE

```shell
mvn spring-boot:run
```


## Aplication
The application will be accessible at:
http://localhost:8080
	
http://localhost:8080/user/{id}


### URLs

To monitor and manage your application

|  URL                    |  Method      |
|-------------------------|--------------|
|`http://localhost:8080/portfolio/idPorfolio`          | GET  |
|`http://localhost:8080/portfolio/`                    | POST |
|`http://localhost:8080/portfolios/`                   | POST |
|`http://localhost:8080/user/{idPortfolio}`            | GET  |


### GET /portfolio/[idPortfolio]

Example: http://localhost:8080/portfolio/1

Request body:
```json
{
      "idPortfolio":1,
      "imageUrl":"https://pbs.twimg.com/profile_images/1117967801652617216/i8PWXebo_400x400.jpg",
      "title":"Calos Valderrama",
      "description":"Soccer Player",
      "twitterUserName":"@PibeValderrama"
   }
```

{"idPortfolio":140226157,"imageURL":"https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/4/000/165/291/1bfeabd.jpg","title":"Luis Alfonso Roca Rosero","description":"This is the result of the test","twitterUserName":"rockfield"}

### POST /portfolio/

Example: Create – POST  http://localhost:8080/portfolio/1

Request body:
```json
{
      "idPortfolio":1,
      "imageUrl":"https://pbs.twimg.com/profile_images/1117967801652617216/i8PWXebo_400x400.jpg",
      "title":"Calos Valderrama",
      "description":"Soccer Player",
      "twitterUserName":"@PibeValderrama"
   }
```

### POST /portfolios/
Example: Create – POST  http://localhost:8080/portfolios/

Request body:
```json
[
   {
      "idPortfolio":1,
      "imageUrl":"https://pbs.twimg.com/profile_images/1117967801652617216/i8PWXebo_400x400.jpg",
      "title":"Calos Valderrama",
      "description":"Soccer Player",
      "twitterUserName":"@PibeValderrama"
   },
   {
      "idPortfolio":2,
      "imageUrl":"https://pbs.twimg.com/profile_images/1117967801652617216/i8PWXebo_400x400.jpg",
      "title":"Daenerys Targaryen",
      "description":"The Mother of Dragons!!",
      "twitterUserName":"Daenerys"
   },
   {
      "idPortfolio":3,
      "imageUrl":"https://pbs.twimg.com/profile_images/668279339838935040/8sUE9d4C_400x400.jpg",
      "title":"Tyrion Lannister",
      "description":"Tyrion of House Lannister. Imp, Halfman. Never forget what you are, for surely the world will not",
      "twitterUserName":"GoT_Tyrion"
   }
]
```

