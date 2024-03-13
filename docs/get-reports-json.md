### GET /reports/json

  Returns all reports in json.

* Success Response:

  * Status Code: 200 
  * Content:

  
 ```
{
  "reports" : [ {
    "id" : 1,
    "conditions" : "Hard-packed",
    "user" : "Paula Waite",
    "reportDate" : "2020-03-01"
  }, {
    "id" : 2,
    "conditions" : "Too much fresh snow. Unrideable, needs grooming.",
    "user" : "Paula Waite",
    "reportDate" : "2019-12-01"
  }, {
    "id" : 3,
    "conditions" : "2\" fresh snow, ridden in",
    "user" : "Julie Rudolph",
    "reportDate" : "2020-03-01"
  }, {
    "id" : 4,
    "conditions" : "Still holding up well after the warm-up",
    "user" : "Julie Rudolph",
    "reportDate" : "2020-03-07"
  }, {
    "id" : 5,
    "conditions" : "Like riding on concrete",
    "user" : "Julie Rudolph",
    "reportDate" : "2020-03-03"
  }, {
    "id" : 6,
    "conditions" : "A bit soft in the afternoon",
    "user" : "Joe V",
    "reportDate" : "2020-03-05"
  }, {
    "id" : 7,
    "conditions" : "Freshly groomed. Perfect conditions",
    "user" : "Cindy Storm",
    "reportDate" : "2020-02-15"
  } ]

 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/reports/json
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/reports/json
	```