### PUT /reports/

  Updates a report.

* Data Params

| Parameter Name | Description | Type/Format | Required/Optional |
| ---------------| ----------- | ----------- |   -------- |
| id | Report id. | number | Required|
| date| Report date. The format must be YYYY-MM-DD, for example 2019-03-19 | string, must be in the format YYYY-MM-DD |  Optional |
| conditions| Description of the trail conditions. | string |Optional |
| user| User making the report.| string | Optional |


* Error Response:
    * Status Code: 400
    * Content `date, conditions, and user are all empty: nothing to edit.`
    or
    * Content `There is no report with ID 55`

* Success Response:

  * Status Code: 200 
  * Content:

	 ```
	Report 3 has been updated.
	```

* Sample curl: 

	```
	curl --request PUT --data "id=3&conditions=Updated Report conditions" http://localhost:8080/fbtr/services/reports
	```
