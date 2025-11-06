select
    m.employee_id,
    m.name,
    count(e.employee_id) as reports_count,
    round(avg(e.age)) as average_age
from 
    Employees as e
join
    Employees as m
on
    e.reports_to = m.employee_id
group by
    m.employee_id, m.name
order by
    m.employee_id;