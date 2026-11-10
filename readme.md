
# Random Quote Generator RESTful Web Service

## Overview

Many websites and applications display inspirational, motivational, or humorous quotes to engage users. However, developers may not want to maintain their own collection of quotes or integrate multiple quote services into their applications.

Our Random Quote Generator RESTful Web Service provides a centralized way for developers to retrieve quotes based on specific categories.

**What makes our service different is its ability to combine locally stored quotes with quotes retrieved from an external API, while providing category-based filtering through a single service.**

The service will provide the following:

- Retrieve all locally stored quotes
- Retrieve a quote by ID
- Generate a random quote
- Generate a random quote by category
- Retrieve quotes from an external API
- Return consistent JSON responses
- Use locally stored quotes when the external service is unavailable

---

## Resources

### Quote

| Property | Description | Type/Format |
|----------|-------------|-------------|
| id | Unique quote identifier | number |
| text | The quote's text | string |
| author | Person credited with the quote | string |
| categoryId | ID of the associated category | number |

### Category

| Property | Description | Type/Format |
|----------|-------------|-------------|
| id | Unique category identifier | number |
| name | Category name, such as Motivation, Success, or Humor | string |
| description | Description of the category | string |

---

## Service Calls

### Quote Endpoints

- `GET /quotes` - Retrieve all locally stored quotes
- `GET /quotes/{id}` - Retrieve a quote by ID
- `GET /quotes/random` - Retrieve a random quote
- `GET /quotes/random?category={id}` - Retrieve a random quote by category
- `GET /quotes/external` - Retrieve a quote from an external service

### Category Endpoints

- `GET /categories` - Retrieve all categories
- `GET /categories/{id}` - Retrieve a category by ID

---

## Example JSON Response

`GET /quotes/random`

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
- Jersey Client for external API integration
- Jackson for JSON processing
- Hibernate
- MySQL
- Maven
- JUnit
- Git and GitHub
- AWS for deployment

---

## Project Objectives

- Develop a reusable RESTful web service using Java.
- Integrate an external quote API using Jersey Client.
- Store quotes and categories using Hibernate and MySQL.
- Implement a relationship between quotes and categories.
- Allow developers to retrieve random quotes.
- Support category-based quote filtering.
- Provide consistent JSON responses with appropriate HTTP status codes.
- Handle external API errors and unavailable services.
- Use locally stored quotes as a fallback when the external service is unavailable.
- Implement unit and integration tests.
- Generate HTML JavaDoc documentation.
- Deploy the web service to AWS.
- Publish API documentation for developers.

---

## API Documentation

Detailed endpoint documentation and example requests will be available in the `docs/` directory.

- [API Consumer Guide](docs/api-guide.md)
- [cURL Examples](docs/curls.txt)

---

## Team

Developed by a team of three Madison College IT Software Development students as part of the Enterprise Java course.
