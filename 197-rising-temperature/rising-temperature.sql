# Write your MySQL query statement below
select w1.id
from Weather w1 inner join Weather w2

-- datediff(w1.recordDate, w2.recordDate) = 1 
-- means: "Only keep the pairs where the date in w1 is exactly one day after the date in w2."
-- So, w1 effectively becomes "Today" and w2 becomes "Yesterday".

where datediff(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature