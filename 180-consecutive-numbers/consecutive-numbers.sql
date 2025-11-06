select distinct num as ConsecutiveNums
from (
    select
        num,
        lead(num, 1) over(order by id) as next_num_1,
        lead(num, 2) over(order by id) as next_num_2
    from 
        Logs
) as temp
where
    num = next_num_1 and num = next_num_2;