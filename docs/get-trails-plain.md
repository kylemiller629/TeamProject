### GET /trails/plain

  Returns data about all trails in plain text.

* Success Response:

  * Status Code: 200 
  * Content:
  
	 ```
		Trail id=1, name='Big Fat Loop', length=14.0, lengthUnits='miles', description='BFL is a little bit of everything: Seeley Pass, Vortanz farm, Seeley Hills, a bit of adventure riding on two-track, finishing off with the Makwa Trail back to OO where you started', website='www.camba.org', latitude=46.1091, longitude=91.2977, reports=[
		Report id=1, date=2020-03-01, conditions='Hard-packed', user='Paula Waite']
		
		Trail id=2, name='Big Easy', length=4.0, lengthUnits='miles', description='Flatish and wide. Great trail for new fat bikers', website='www.camba.org', latitude=46.1091, longitude=91.2977, reports=[
		Report id=7, date=2020-02-15, conditions='Freshly groomed. Perfect conditions', user='Cindy Storm', 
		Report id=6, date=2020-03-05, conditions='A bit soft in the afternoon', user='Joe V', 
		Report id=4, date=2020-03-07, conditions='Still holding up well after the warm-up', user='Julie Rudolph']
		
		Trail id=3, name='Seeley Pass', length=10.0, lengthUnits='miles', description='Seeley Pass Description', website='www.camba.org', latitude=46.1091, longitude=91.2977, reports=[
		Report id=2, date=2019-12-01, conditions='Too much fresh snow. Unrideable, needs grooming.', user='Paula Waite', 
		Report id=3, date=2020-03-01, conditions='2" fresh snow, ridden in', user='Julie Rudolph', 
		Report id=5, date=2020-03-03, conditions='Like riding on concrete', user='Julie Rudolph']
	 ```

* Sample curl: 

	```
	curl --request GET http://localhost:8080/fbtr/services/trails/plain
	```

* Sample request in browser:

	```
	http://localhost:8080/fbtr/services/trails/plain
	```