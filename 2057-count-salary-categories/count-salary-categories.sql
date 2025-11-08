with salary_count as(
    select
        sum(case when income < 20000 then 1 else 0 end) as low_count,
        sum(case when income >= 20000 and income <= 50000 then 1 else 0 end) as avg_count,
        sum(case when income > 50000 then 1 else 0 end) as high_count
    from Accounts
)

select 
    "Low Salary" as category,
    low_count as accounts_count
from salary_count
union all
select
    "Average Salary" as category,
    avg_count as accounts_count
from salary_count
union all
select
    "High Salary" as category,
    high_count as accounts_count
from salary_count
order by
    accounts_count desc;




