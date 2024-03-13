### GET /trails/plain/:id

  Returns data about a trail by id in plain text.

* Error Response:
    * Status Code: 400
    * Content `8 is a bad ID.`


* Success Response:

  * Status Code: 200 
  * Content:
 
	 ```
	Trail id=1, name='Big Fat Loop', length=14.0, lengthUnits='miles', description='BFL is a little bit of everything: Seeley Pass, Vortanz farm, Seeley Hills, a bit of adventure riding on two-track, finishing off with the Makwa Trail back to OO where you started', website='www.camba.org', latitude=46.1091, longitude=91.2977, reports=[
	Report id=1, date=2020-03-01, conditions='Hard-packed', user='Paula Waite']
	
	 ```

* Sample curl: 
	
	```
	curl --request GET http://localhost:8080/fbtr/services/trails/plain/1
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/trails/plain/1
	```