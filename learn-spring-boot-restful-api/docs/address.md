# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContacts}/addresses

Request Header :

- X-API-TOKEN : token (Mandatory)

Request Body :

```json
{
  "street" : "Jalan jalan",
  "city" : "kota kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12345"
}
```

Response Body (Success):

```json
{
  "data": {
    "id" : "random string",
    "street" : "Jalan jalan",
    "city" : "kota kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12345"
  }
}
```

Response Body (Failed):

```json
{
  "error": "Contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContacts}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token (Mandatory)

Request Body :

```json
{
  "street" : "Jalan jalan",
  "city" : "kota kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12345"
}
```

Response Body (Success):

```json
{
  "data": {
    "id" : "random string",
    "street" : "Jalan jalan",
    "city" : "kota kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12345"
  }
}
```

Response Body (Failed):
```json
{
  "errors" : "Address not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{contactsId}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token (Mandatory)


Response Body (Success):

```json
{
  "data": {
    "id" : "random string",
    "street" : "Jalan jalan",
    "city" : "kota kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12345"
  }
}
```

Response Body (Failed):

```json
{
  "errors" : "Address not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{contactsId}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token (Mandatory)

Response Body (Success):
```json
{
  "data" : "success"
}
```

Response Body (Failed):
```json
{
  "errors" : "address not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContacts}/addresses

Request Header :

- X-API-TOKEN : token (Mandatory)


Response Body (Success):
```json
{
  "data": [
    {
        "id" : "random string",
        "street" : "Jalan jalan",
        "city" : "kota kota",
        "province" : "provinsi",
        "country" : "negara",
        "postalCode" : "12345"
    },

    {
      "id" : "random string",
      "street" : "Jalan jalan",
      "city" : "kota kota",
      "province" : "provinsi",
      "country" : "negara",
      "postalCode" : "12345"
    }
  ]
}
```

Response Body (Failed):
```json
{
  "errors" : "contact not found "
}
```