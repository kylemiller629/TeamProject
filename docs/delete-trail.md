### DELETE /trails/:id

  Deletes a trail and its associated reports by trail id.

* Error Response:
    * Status Code: 400
    * Content `There is no trail with ID 19. Cannot delete.`

* Success Response:

  * Status Code: 200 
  * Content:
 ```
Trail 1 deleted.
 ```

* Sample curl: 

```
curl --request DELETE http://localhost:8080/fbtr/services/trails/1
```