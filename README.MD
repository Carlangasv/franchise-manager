## Franchise Manager

Project made by Carlos Valencia To Evalart Test

### Technology stack

Application made using SpringBoot, JPA, and Lombok.

### Database Engine

The database is hosted in [supabase](supabase.com) using postgresql.

## Endpoints

### 1. Create a Franchise

**POST** `http://localhost:8080/franchise`

**Request Body:**

```json
{
  "name": "Franchise Name"
}
```

### 2. Create a Branch for a Franchise

**POST** `http://localhost:8080/franchise/{franchiseId}/branches`

**Description:**  
Creates a new branch office under a specific franchise.

**Request Body:**

```json
{
  "name": "Branch Office Name"
}
```

**URL Parameters:**

- `franchiseId` (integer): The ID of the franchise.

### 3. Get Top Stock Products for Franchise

**GET** `http://localhost:8080/franchise/{franchiseId}/top-stock-products`

**URL Parameters:**

- `franchiseId` (integer): The ID of the franchise.

### 4. Delete Product from Branch Office

**DELETE** http://localhost:8080/branchOffice/{branchOfficeId}/products/{productId}

URL Parameters:

- `branchOfficeId` (integer): The ID of the branch office.
- `productId` (integer): The ID of the product to be deleted.

### 5. Add Product to Branch Office

**POST** `http://localhost:8080/branchOffice/{branchOfficeId}/products`

**Request Body:**

```json
{
  "name": "Product Name",
  "stockAmount": 10
}
```

**URL Parameters:**

- `branchOfficeId` (integer): The ID of the branch office.

### 6. Update Product Stock in Branch Office

**PATCH** `http://localhost:8080/branchOffice/{branchOfficeId}/products/stock`

**Request Body:**

```json
{
  "id": 0,
  "stockAmount": 100
}
```

**URL Parameters:**

- `branchOfficeId` (integer): The ID of the branch office.

### 7. Update Branch Office Name

**PATCH** `http://localhost:8080/branchOffice/1/name`

**Request Body:**

```json
{
  "name": "New name"
}
```

### 8. Update Product Name in Branch Office

**PATCH** `http://localhost:8080/branchOffice/1/products/name`

**Request Body:**

```json
{
  "id": 1,
  "name": "New product name"
}
```

### 9. Update Branch Office Name (Alternate Endpoint)

**PATCH** `http://localhost:8080/branchOffice/1/name`

**Request Body:**

```json
{
  "name": "New name"
}
```

## Proceso para iniciar la aplicacion:

Run the command `./gradlew build`

Run the command `docker compose up`
