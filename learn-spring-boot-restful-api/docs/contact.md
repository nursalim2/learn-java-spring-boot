# Contact API Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :
- X-API-TOKEN : token (Mandatory)

Request Body :

```json
{
  "firstName" : "Nursalim",
  "lastName" : "Milasrun",
  "email" : "nursalim@mail.com",
  "phone" : "08393829"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id" : "random string",
    "firstName": "Nursalim",
    "lastName": "Milasrun",
    "email": "nursalim@mail.com",
    "phone": "08393829"
  }
}
```

Response Body (Failed) :

```json
{
  "error" : "Email format invalid, Phone format invalid"
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : token (Mandatory)

Request Body :

```json
{
  "firstName" : "Nursalim",
  "lastName" : "Milasrun",
  "email" : "nursalim@mail.com",
  "phone" : "08393829"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id" : "random string",
    "firstName": "Nursalim",
    "lastName": "Milasrun",
    "email": "nursalim@mail.com",
    "phone": "08393829"
  }
}
```

Response Body (Failed) :

```json
{
  "error" : "Email format invalid, Phone format invalid"
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id" : "random string",
    "firstName": "Nursalim",
    "lastName": "Milasrun",
    "email": "nursalim@mail.com",
    "phone": "08393829"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "error" : "Contact not found"
}
```

## Search Contact

Endpoint : GET /api/contacts

Query Param :

- name : String, contact first name or last name using like query (optional)
- phone : string, contact phone using like query (optional)
- email : contact email like query (optional)
- page : Integer, start from zero, default 0
- size : Integer, default 10

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :

```json
{
  "data" : [
    {
      "id" : "random string",
      "firstName": "Nursalim",
      "lastName": "Milasrun",
      "email": "nursalim@mail.com",
      "phone": "08393829"
    },
    {
      "id" : "random string",
      "firstName": "Nursalim",
      "lastName": "Milasrun",
      "email": "nursalim@mail.com",
      "phone": "08393829"
    }
  ],
  "paging" : {
    "currentPage" : 0,
    "totalPage" : 10,
    "size" : 10
    
  }
}
```

Response Body (Failed) :

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :

```json
{
  "data" : "success"
}
```

Response Body (Failed, 404) :

```json
{
  "error" : "Contact not found"
}
```