# User API Spec

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
  "username": "jhon",
  "password": "secret",
  "name": "John Doe"
}
```

Response Body (Success) :
```json
{
  "data": "OK"
}
```

Response Body (Failed) :
```json
{
  "data": "Failed",
  "error": "Username must not blank"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "jhon",
  "password": "secret"
}
```

Response Body (Success) :
```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 12344 //milisecond
  }
}
```

Response Body (Failed) :
```json
{
  "error": "Username or password wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :
```json
{
  "data": {
    "username": "john",
    "name": "John Doe"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "error": "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Request Header :
- X-API-TOKEN : token (Mandatory)

Request Body :

```json
{
  "name": "Jhon Doe", // put if only want to update
  "password": "secret" // put if only want to update
}
```

Response Body (Success) :
```json
{
  "data": {
    "username": "john",
    "name": "John Doe"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "error": "Unauthorized"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :
```json
{
  "data": "Success"
}
```

