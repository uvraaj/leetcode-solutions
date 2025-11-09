with cte as (
    (
        select requester_id as id, count(requester_id) as partial_count
        from RequestAccepted
        group by requester_id
    )
    union all
    (
        select accepter_id as id, count(accepter_id) as partial_count
        from RequestAccepted
        group by accepter_id
    )
)

select id, sum(partial_count) as num
from cte
group by id
order by num desc
limit 1;
