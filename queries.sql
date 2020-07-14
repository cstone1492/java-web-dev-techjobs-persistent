## Part 1: Test it with SQL

id int PK
employer varchar(255)
name varchar(255)
skills varchar(255)
employer_id int

## Part 2: Test it with SQL

SELECT * from employers
WHERE location = "St. Louis"

## Part 3: Test it with SQL

DELETE FROM jobs

## Part 4: Test it with SQL

SELECT name, description from skills
INNER JOIN jobs ON skills where jobs_skills = skills_id