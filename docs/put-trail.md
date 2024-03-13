### PUT /trails/

  Updates a trail.

* Data Params

| Parameter Name | Description | Type/Format | Required/Optional |
| ---------------| ----------- | ----------- |   -------- |
| id | Trail id. | number | Required|
| name| Trail name, for example "Big Easy" | string |  Optional |
| length| Trail length. | number |Optional |
| unit| Trail length units. For example, "mi" or "km".| string | Optional |
| description| Trail description. For example, "Flat, wide loop trail groomed by the Birkie. Excellent for beginners." | string | Optional |
| website| Website url for more trail info. For example, "http://cambatrails.org". | string |  Optional |
| latitude | Latitude of the trail head. For example,  | number |  46.106941 | Optional |
| longitude | Longitude of the trail head. For example,  | number | -91.298243 | Optional |

* Error Response:
    * Status Code: 400
    * Content `name, length, units, description, website, latitude and longitude are all empty: nothing to edit.`
    or
    * Content `There is no trail with ID 55`

* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
	Trail 2 has been updated.
	```

* Sample curl: 

	```
	curl --request PUT --data "id=2&name=Updated Trail Name" http://localhost:8080/fbtr/services/trails/
	```
