# StreamFlix Content Management System

## 📌 Scenario  
Welcome to **StreamFlix**!  
You're joining as a junior backend engineer, and your first task is to help manage the streaming platform's content database. StreamFlix has different content categories (Movies, Series, Documentaries, Anime) and needs to track which shows belong to which category, along with their ratings and popularity metrics.

---

## ⚙️ Setup Instructions

### **Step 1: Install PostgreSQL (or MySQL)**
- Install PostgreSQL from: https://www.postgresql.org  
or  
- Install MySQL from: https://www.mysql.com  

---

### **Step 2: Create the Database**
```sql
CREATE DATABASE streamflix;
```
<img width="1659" height="750" alt="image" src="https://github.com/user-attachments/assets/e787f0ba-d9bc-4cce-a136-6a7594384670" />


---

### **Step 3: Create Tables**

#### **Categories Table**
```sql
CREATE TABLE category (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    description TEXT
);
```
<img width="1634" height="818" alt="image" src="https://github.com/user-attachments/assets/32217aaf-f98c-491e-a677-170316ca946c" />


#### **Content Table**
```sql
CREATE TABLE content (
    content_id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    rating DECIMAL(3,1) CHECK (rating >= 0 AND rating <= 10),
    views_in_millions DECIMAL(10,2),
    release_year INTEGER,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);
```
<img width="1679" height="912" alt="image" src="https://github.com/user-attachments/assets/3018cea6-37b7-48b6-9d3a-da51cfe097c1" />


---

### **Step 4: Insert Sample Data**

#### ➤ Insert Categories
```sql
INSERT INTO category (category_name, description) VALUES
('Movies', 'Feature-length films'),
('Series', 'Multi-episode TV shows'),
('Documentaries', 'Non-fiction educational content'),
('Anime', 'Japanese animated content');
```
<img width="1691" height="964" alt="image" src="https://github.com/user-attachments/assets/730b3255-2b26-4940-8ee7-235bb81472e0" />


#### ➤ Insert Content
```sql
INSERT INTO content (title, rating, views_in_millions, release_year, category_id) VALUES
('Stranger Adventures', 8.7, 142.50, 2023, 2),
('The Cosmic Heist', 7.9, 89.30, 2024, 1),
('Planet Earth: Oceans', 9.2, 201.75, 2023, 3),
('Code Warriors', 8.1, 67.20, 2024, 2),
('Attack on Mars', 9.0, 156.80, 2023, 4),
('The Algorithm', 7.5, 45.60, 2024, 1),
('Wildlife Mysteries', 8.8, 178.90, 2024, 3),
('Cyberpunk Chronicles', 8.4, 123.45, 2023, 4);
```
<img width="1692" height="933" alt="image" src="https://github.com/user-attachments/assets/36d5d5ed-82ed-4716-9db4-682e8a59a84c" />


---

## 🧠 My Tasks

### **Query 1: Basic JOIN — Show All Content with Categories**
Display: `content_id`, `title`, `category_name`.

**Expected Output Format:**
```
content_id | title                 | category_name
---------------------------------------------------
1          | Stranger Adventures   | Series
2          | The Cosmic Heist      | Movies
...
```
```sql
SELECT con.content_id,con.title,cat.category_name from content con join category cat on
 con.content_id=cat.category_id;
```
<img width="1664" height="925" alt="image" src="https://github.com/user-attachments/assets/ec19d297-595a-4390-a7f8-a2f2f17735b0" />



---

### **Query 2: Top Performers — Sorted by Popularity**
Sort content by **views_in_millions DESC**.
```sql
 SELECT title,rating,views_in_millions FROM content
ORDER BY views_in_millions DESC;
```
<img width="1682" height="985" alt="image" src="https://github.com/user-attachments/assets/a7727640-439a-43aa-8574-6773d1f60f59" />



---

### **Query 3: Category Analytics — Average Rating per Category**
Show:
- `category_name`  
- `average_rating`

**Business Context:** Shows executives which category performs best.
```sql
SELECT cat.category_name,AVG(con.rating) AS average_rating FROM content con JOIN category cat 
ON con.category_id = cat.category_id
GROUP BY cat.category_name;
```
<img width="1662" height="947" alt="image" src="https://github.com/user-attachments/assets/497568e1-92b6-47a0-86a6-3a24a48aa696" />


---

### **Query 4: High-Rated Content with Filters**
Find content:
- rating **> 8.5**
- views **> 100 million**

Display: title, rating, views, category_name.

```sql
SELECT con.title,con.rating,con.views_in_millions,cat.category_name FROM content con JOIN category cat 
ON con.category_id = cat.category_id
WHERE con.rating > 8.5 AND con.views_in_millions > 100;
```
<img width="1664" height="945" alt="image" src="https://github.com/user-attachments/assets/dd231071-731a-4ca2-8a3a-4813a2964f3e" />


---

### **Query 5: Index Demonstration**

1.Run EXPLAIN ANALYZE on your Query 1 to see query execution time:
  ```sql
  EXPLAIN ANALYZE
  SELECT con.content_id,con.title,cat.category_name FROM content con JOIN category cat 
  ON con.category_id = cat.category_id;
  ```
  <img width="1659" height="939" alt="image" src="https://github.com/user-attachments/assets/d9669e4d-0e0a-4335-8c4c-22f70d870e97" />
  Execution time for query = Actual time = ~0.113 ms – 0.146 ms

2. Create an index:
  ```sql
   CREATE INDEX idx_category_id ON content(category_id);
  ```
  <img width="1657" height="956" alt="image" src="https://github.com/user-attachments/assets/01b0ba01-94d6-4aee-8e80-8f1e237b54f3" />

3. Run EXPLAIN ANALYZE again
  ```sql
   EXPLAIN ANALYZE
  SELECT con.title, con.rating, con.views_in_millions, cat.category_name FROM content con JOIN category cat
    ON con.category_id = cat.category_id
    WHERE con.rating > 8.5 AND con.views_in_millions > 100;
  ```
   <img width="1660" height="957" alt="image" src="https://github.com/user-attachments/assets/b2240979-22d3-4163-9c9b-436af43551e4" />

5. Write 2–3 sentences explaining performance difference.
  After creating the index on content(category_id), MySQL can quickly locate the matching rows during the JOIN operation instead of scanning the entire table. This reduces the query’s execution time, especially when the table grows larger. On small tables, the improvement may be minimal, but the index becomes very effective for larger datasets.

---

## 🧩 Concept Check — "The 3 Why's"

### **Why #1: Why do we use Foreign Keys?**
To prevent invalid category references and maintain data consistency.

---

### **Why #2: Why is ACID important for this database?**
To ensure correct view counts during simultaneous streaming by thousands of users.

---

### **Why #3: Why create an index on `category_id`?**
To speed up queries filtering by category, especially when millions of records exist.

---

---

##  Author  
Pranjali Rana  
B.Tech – Mathematics & Computing  
NIT Hamirpur

