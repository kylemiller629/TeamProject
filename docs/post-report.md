### POST /reports/:id

  Adds a report to the trail with the given id.

* Data Params

| Parameter Name | Description | Type/Format | Required/Optional |
| ---------------| ----------- | ----------- |   -------- |
| date| Report date. The format must be YYYY-MM-DD, for example 2019-03-19 | string, must be in the format YYYY-MM-DD |  Required |
| conditions| Description of the trail conditions. | string |Optional |
| user| User making the report.| string | Optional |

* Error Response:
    * Status Code: 400
    * Content `Property 'date' is missing.`


* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
	Report 8 created: (date = 2019-03-13 conditions = fun user = ima fat biker)
	 ```

* Sample curl: 

	```
	curl --request POST --data "date=2019-03-13&conditions=fun&user=ima fat biker" http://localhost:8080/fbtr/services/reports/2
	
	```