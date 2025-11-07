with cte as(
    select 
        person_name,
        SUM(weight) over (order by turn asc) as sum 
    from
        Queue
)

select person_name
from cte
where sum <= 1000 
order by sum desc 
limit 1; 