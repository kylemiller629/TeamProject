### GET /reports/json/:id

  Returns a report by id in json.

* Error Response:
    * Status Code: 400
    * Content `8 is a bad ID.`


* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
	{
	  "id" : 1,
	  "conditions" : "Hard-packed",
	  "user" : "Paula Waite",
	  "reportDate" : "2020-03-01"
	}
	 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/reports/json/1
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/reports/json/1
	```