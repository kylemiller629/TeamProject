### POST /trails/with-reports

  Adds a trail with one or more reports.

* Data Params

| Parameter Name | Description | Type/Format | Required/Optional |
| ---------------| ----------- | ----------- |   -------- |
| name| Trail name, for example "Big Easy" | string |  Required |
| length| Trail length. | number |Optional |
| unit| Trail length units. For example, "mi" or "km".| string | Optional |
| description| Trail description. For example, "Flat, wide loop trail groomed by the Birkie. Excellent for beginners." | string | Optional |
| website| Website url for more trail info. For example, "http://cambatrails.org". | string |  Optional |
| latitude | Latitude of the trail head. For example,  | number |  46.106941 | Optional |
| longitude | Longitude of the trail head. For example,  | number | -91.298243 | Optional |
| date*| Report date. The format must be YYYY-MM-DD, for example 2019-03-19 | string, must be in the format YYYY-MM-DD |  Required |
| conditions*| Description of the trail conditions. | string |Optional |
| user*| User making the report.| string | Optional |

*adding multiple data elements with this name results in the creation of multiple reports. For example, if two values with 
the name "date" are included, two reports will be added, one for each date. The first "date", "conditions", and "user" will 
be the first report added, the second "date", "conditions", and "user" will be the second report, etc.

* Error Response:
    * Status Code: 400
    * Content `Property 'name' is missing.`


* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
	Trail 5 created: (name = New Trail Name length = 10 units = miles description = fun trail website = camba.com latitude = 124.12 longitude = 654.78 with 2 new reports) ```

* Sample curl: 

	```
	curl --request POST --data "name=New Trail Name&length=10&units=miles&description=fun trail&website=camba.com&latitude=124.12&longitude=654.78&date=2019-03-13&conditions=fun1&user=ima fat biker1&date=2019-03-14&conditions=fun2&user=ima fat biker2" http://localhost:8080/fbtr/services/trails/with-reports
	```

