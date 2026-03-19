# Fat Bike Trail Reports RESTful Web Service Demo Project

## Overview 
With the growing popularity of winter fat biking in northern regions (riding bikes with 3.5" or larger tires in the snow), riders have found themselves in need of a single place to discover and share fat bike trails and conditions. Currently, trail information is found on various social media sites and web sites, or is simply shared in email among those "in the know". The Fat Bike Trail Reports website provides a place to aggregate fat bike trail reports, however, currently users must manually enter trail info on the site. Some users already maintain their own website for their specific trail and do not want to have to keep this information in two places.  

**This RESTFul Web Service provides endpoints for developers to use to maintain fat bike trail info and condition reports in a single place.**

The service provides the following:

* Get a trail and its reports in plain text and json, given a trail id 
* Get all trails and their reports in plain text and json 
* Get all reports in plain text and json
* Get a report in plain text and json given a report id
* Add a trail 
* Add a report for a trail, given a trail id 
* Add a trail and one or more reports for that trail
* Update a trail, given a trail id
* Update a report, given a report id 
* Delete a trail and its associated reports, given a trail id 
* Delete a report, given a report id 

---
## Resources

#### Trail

| Property  | Description | Type/Format | 
| ---------------| ----------- | ----------- |   
| id| unique identifier| number|
| name| Trail name, for example "Big Easy" | string |
| length| Trail length. | number |
| unit| Trail length units. For example, "mi" or "km".| string |
| description| Trail description. For example, "Flat, wide loop trail groomed by the Birkie. Excellent for beginners." | string |
| website| Website url for more trail info. For example, "http://cambatrails.org". | string |  
| latitude | Latitude of the trail head. For example,  | number |  46.106941 | 
| longitude | Longitude of the trail head. For example,  | number | -91.298243 | 


#### Report

| Property  | Description | Type/Format | 
| ---------------| ----------- | ----------- |   
| id| unique identifier| number|
| date| Report date. The date is in the format YYYY-MM-DD, for example 2019-03-19 | String in the format YYYY-MM-DD | 
| conditions| Description of the trail conditions. | string |
| user| User making the report.| string | 


## Service Calls

* [GET /trails/json](docs/get-trails-json.md)
* [GET /trails/plain](docs/get-trails-plain.md)
* [GET /trails/json/:id](docs/get-trail-by-id-json.md)
* [GET /trails/plain/:id](docs/get-trail-by-id-plain.md)
* [GET /reports/json](docs/get-reports-json.md)
* [GET /reports/plain](docs/get-reports-plain.md)
* [GET /reports/json/:id](docs/get-reports-by-id-json.md)
* [GET /reports/plain/:id](docs/get-reports-by-id-plain.md)
* [POST /trails](docs/post-trail.md)
* [POST /reports/:id](docs/post-report.md)
* [POST /trails/with-reports](docs/post-trail-with-reports.md)
* [PUT /trails/:id](docs/put-trail.md)
* [PUT /reports/:id](docs/put-report.md)
* [DELETE /trails/:id](docs/delete-trail.md)
* [DELETE /reports/:id](docs/delete-report.md)

---
## Curl list

 [Curls for easy copy/paste](docs/curls.txt)

---
This document was motivated by https://gist.github.com/iros/3426278

---