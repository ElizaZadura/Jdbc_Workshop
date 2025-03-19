# JDBC Workshop - Implement DAO for City Table

In this workshop, you will **complete the implementation of a JDBC-based application** that interacts with the `city` table in MySQL's `world` database.

---

## 🚀 Getting Started

### 🔹 **1. Fork the Repository**
Before you begin, **fork this repository** using the link provided by your teacher.  
This will create **your own copy** of the project where you can make changes.

### 🔹 **2. Complete the TODOs**
Your task is to **implement the missing parts** in the provided files, following best practices in JDBC and DAO patterns.

### 🔹 **3. Submit Your Work**
Once you have completed the tasks:
1. Push your changes to **your forked repository**.
2. **Share the link** to your repository with your teacher via **direct message**.

---

## 📌 What You Need to Do

### 1️⃣ Complete the `City` Class (Model)
- Implement the `City` class based on the **`city` table** in the **`world`** database.

📌 **Reference:** The **TODO** comment inside `City.java` (`se.lexicon.model.City`) **guides you** on what needs to be done.

---

### 2️⃣ Review the `CityDao` Interface
- The interface (`CityDao.java`) **already exists**, but you must **implement it in `CityDaoImpl`**.
- It defines the following methods:
    - `findById(int id)`
    - `findByCode(String code)`
    - `findByName(String name)`
    - `findAll()`
    - `save(City city)`
    - `update(City city)`
    - `deleteById(int id)`

📌 **Reference:** The interface is in `se.lexicon.dao.CityDao`.

---

### 3️⃣ Implement `CityDaoImpl` (DAO Implementation)
This class **must implement `CityDao`** and handle **database interactions using JDBC**.

📌 **Tasks to Complete in `CityDaoImpl.java`:**
- **Establish Database Connection:** Use JDBC to connect to MySQL.
- **Use `PreparedStatement`** for SQL queries to prevent SQL injection.
- **Implement CRUD operations**:
    - Fetch a city by ID
    - Fetch all cities
    - Fetch by name or country code
    - Insert a new city
    - Update an existing city
    - Delete a city

📌 **Reference:** The `TODO` comment inside `CityDaoImpl.java` **guides you on what to complete**.

---

## ✅ Final Steps
✔ **Ensure your database connection works correctly** with MySQL.  
✔ **Test your methods** by calling them from a temporary `main` method.  
✔ **Push your changes and share the repository link with your teacher.**

---
