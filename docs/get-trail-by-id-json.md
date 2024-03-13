### GET /trails/json/:id

  Returns data about a trail by id in json.

* Error Response:
    * Status Code: 400
    * Content `8 is a bad ID.`


* Success Response:

  * Status Code: 200 
  * Content:

  
	 ```
	{
	  "id" : 1,
	  "name" : "Big Fat Loop",
	  "length" : 14.0,
	  "lengthUnits" : "miles",
	  "description" : "BFL is a little bit of everything: Seeley Pass, Vortanz farm, Seeley Hills, a bit of adventure riding on two-track, finishing off with the Makwa Trail back to OO where you started",
	  "website" : "www.camba.org",
	  "latitude" : 46.1091,
	  "longitude" : 91.2977,
	  "reports" : [ {
	    "id" : 1,
	    "conditions" : "Hard-packed",
	    "user" : "Paula Waite",
	    "reportDate" : "2020-03-01"
	  } ]
	}
	 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/trails/json/1
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/trails/json/1
	```