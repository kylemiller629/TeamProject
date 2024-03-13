### GET /reports/plain/:id

  Returns a report by id in plain text.

* Error Response:
    * Status Code: 400
    * Content `8 is a bad ID.`


* Success Response:

  * Status Code: 200 
  * Content:
	 
	 ```
	Report id=1, date=2020-03-01, conditions='Hard-packed', user='Paula Waite'
	 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/reports/plain/1
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/reports/plain/1
	```