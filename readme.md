
# Random Quote Generator RESTful Web Service

## Overview

Many websites and applications display inspirational,
motivational, or humorous quotes to engage their users.
However, developers may not want to create and maintain
their own collection of quotes.

The Random Quote Generator RESTful Web Service provides
a centralized collection of quotes that developers can
access and incorporate into their own applications.

**This RESTful Web Service provides endpoints for
developers to retrieve, add, update, and delete quotes,
as well as generate random quotes based on categories.**

The service provides the following:

- Get a random quote
- Get all quotes
- Get a quote by its ID
- Get quotes by category
- Add a new quote
- Update an existing quote
- Delete a quote
- Get all categories
- Add a new category
- Update an existing category
- Delete a category

All responses will be returned in JSON format.

---

## Resources

#### Quote

| Property | Description | Type/Format |
|----------|-------------|-------------|
| id | Unique quote identifier | number |
| text | The quote's text | string |
| author | Person credited with the quote | string |
| categoryId | ID of the associated category | number |

#### Category

| Property | Description | Type/Format |
|----------|-------------|-------------|
| id | Unique category identifier | number |
| name | Category name, such as Motivation, Success, or Humor | string |
| description | Description of the category | string |

---

## Service Calls

### Quote Endpoints

- `GET /quotes` - Retrieve all quotes
- `GET /quotes/{id}` - Retrieve a quote by ID
- `GET /quotes/random` - Retrieve a random quote
- `GET /quotes?category={id}` - Retrieve quotes by category
- `POST /quotes` - Add a new quote
- `PUT /quotes/{id}` - Update an existing quote
- `DELETE /quotes/{id}` - Delete a quote

### Category Endpoints

- `GET /categories` - Retrieve all categories
- `GET /categories/{id}` - Retrieve a category by ID
- `POST /categories` - Add a new category
- `PUT /categories/{id}` - Update a category
- `DELETE /categories/{id}` - Delete a category

---

## Example JSON Response

GET /quotes/random

```json
{
  "id": 1,
  "text": "Small steps lead to big changes.",
  "author": "Anonymous",
  "categoryId": 1
}
```

---

## Technologies

- Java
- Jersey RESTful Web Services
- Hibernate
- MySQL
- Maven
- JUnit
- Git and GitHub
- AWS for deployment

---

## Project Objectives

- Develop a reusable RESTful web service using Java.
- Implement CRUD operations for quotes and categories.
- Use Hibernate to manage database persistence.
- Implement a relationship between quotes and categories.
- Allow developers to retrieve random quotes.
- Support filtering quotes by category.
- Return JSON responses with appropriate HTTP status codes.
- Implement unit and integration tests.
- Generate JavaDoc documentation.
- Deploy the web service to AWS.
- Publish API documentation for developers.

---

## API Documentation

Detailed endpoint documentation and example requests
will be available in the `docs/` directory.

- [API Consumer Guide](docs/api-guide.md)
- [cURL Examples](docs/curls.txt)

---

## Team

Developed by a team of three Madison College
IT Software Development students as part of
the Enterprise Java course.
