# Setup Instructions

### Prerequisites

- IntelliJ IDEA or any other Java IDE
- Docker (Ensure Docker Desktop is running)

### Installation

1. Open the project in IntelliJ IDEA:
    - Open IntelliJ IDEA and click on Open to open the project directory.
2. Run MySQL database container using Docker:
    - Open a terminal in your project directory (or use the built-in terminal in IntelliJ IDEA).
    - Run the following command to start the MySQL container using Docker:
    ```bash
      docker compose up -d
    ```
    - This will launch the MySQL container in the background using Docker Compose. The database will be available at localhost:3306.
3. Run the Spring Boot application:
    - In IntelliJ IDEA, run your Spring Boot application using the **Run** button
4. Flyway Migration:
    - Flyway will automatically apply any database migrations found in the src/main/resources/db/migration directory. I have already created the migration file **"V1__Create_books_table.sql"**.

### Example API requests and expected responses

1. POST /books 
   
   example request body*

   ```
   {
      "title": "เลิกเป็นมนุษย์ตื่นสาย กลายเป็นตื่นเช้า",
      "author": "สึคาโมโตะ เรียว",
      "publishedDate": "2568-01-21"
   }
   ```

2. GET /books?author={authorName}
   
   example params*
   
   ```
   author=โมโตะ
   ```

   example response

   ```
   [
    {
        "id": 1,
        "title": "เลิกเป็นมนุษย์ตื่นสาย กลายเป็นตื่นเช้า",
        "author": "สึคาโมโตะ เรียว",
        "publishedDate": "2568-01-21"
    }
   ]
   ```