### POST /trails/

  Adds a trail.

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


* Error Response:
    * Status Code: 400
    * Content `Property 'name' is missing.`


* Success Response:

  * Status Code: 200 
  * Content:

	 ```
	Trail 4 created: (name = New Trail Name length = 10 units = miles description = fun trail website = camba.com latitude = 124.12 longitude = 654.78) ```
	```

* Sample curl: 

	```
	curl --request POST --data "name=New Trail Name&length=10&units=miles&description=fun trail&website=camba.com&latitude=124.12&longitude=654.78" http://localhost:8080/fbtr/services/trails/
	```
