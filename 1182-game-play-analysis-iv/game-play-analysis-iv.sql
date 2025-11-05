select
    round(count(distinct first_login.player_id) / (select count(distinct player_id) from Activity), 2) as fraction
from 
    (
        select player_id, min(event_date) as first_date
        from Activity 
        group by player_id
    ) as first_login
join
    Activity as next_login
on
    first_login.player_id = next_login.player_id and
    next_login.event_date = date_add(first_login.first_date, interval 1 day)