# API Overview

Base URL: `http://localhost:8080/api`

## Authentication
POST `/auth/login`
```json
{"username":"student1","password":"student123","role":"STUDENT"}
```

## Books
GET `/books`
POST `/books`
DELETE `/books/{id}`

## Students
GET `/students`
GET `/students/{id}`
POST `/students`
DELETE `/students/{id}`

## Borrowals
POST `/borrowals/borrow`
```json
{"studentId":1,"bookId":1}
```
POST `/borrowals/{id}/return`
GET `/borrowals`
GET `/borrowals/student/{studentId}`

## Librarian dashboard
GET `/librarian/stats`
