WITH cte AS
(
    SELECT person_name, SUM(weight) OVER(ORDER BY turn ASC) AS sum
    FROM Queue
)
SELECT person_name
FROM cte
WHERE sum <= 1000
ORDER BY sum DESC
LIMIT 1;