### DELETE /reports/:id

  Deletes a report by trail id.

* Error Response:
    * Status Code: 400
    * Content `There is no report with ID 19. Cannot delete.`

* Success Response:

  * Status Code: 200 
  * Content:
 ```
Report 1 deleted.
 ```

* Sample curl: 

```
curl --request DELETE http://localhost:8080/fbtr/services/reports/1
```