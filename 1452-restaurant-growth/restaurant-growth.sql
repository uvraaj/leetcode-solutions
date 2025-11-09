with CTE_daily_sales as (
    select visited_on, sum(amount) as daily_amount
    from Customer
    group by visited_on 
), 
CTE_window_data as(
    select
        visited_on,
        sum(daily_amount) over (order by visited_on rows between 6 preceding and current row) as weekly_sum,
        round(sum(daily_amount) over (order by visited_on rows between 6 preceding and current row) / 7.0, 2) as average_amount,
        lag(visited_on, 6) over (order by visited_on) as lag_date
    from CTE_daily_sales
)

select
    visited_on,
    weekly_sum as amount,
    average_amount
from 
    CTE_window_data
where 
    lag_date is not null
order by
    visited_on;