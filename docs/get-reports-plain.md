
### GET /reports/plain

  Returns all reports in plain text.

* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
	Report id=1, date=2020-03-01, conditions='Hard-packed', user='Paula Waite'
	Report id=2, date=2019-12-01, conditions='Too much fresh snow. Unrideable, needs grooming.', user='Paula Waite'
	Report id=3, date=2020-03-01, conditions='2" fresh snow, ridden in', user='Julie Rudolph'
	Report id=4, date=2020-03-07, conditions='Still holding up well after the warm-up', user='Julie Rudolph'
	Report id=5, date=2020-03-03, conditions='Like riding on concrete', user='Julie Rudolph'
	Report id=6, date=2020-03-05, conditions='A bit soft in the afternoon', user='Joe V'
	Report id=7, date=2020-02-15, conditions='Freshly groomed. Perfect conditions', user='Cindy Storm'
	 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/reports/plain
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/reports/plain
	```