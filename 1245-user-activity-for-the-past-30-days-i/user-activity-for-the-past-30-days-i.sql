select 
    activity_date as day,
    count(distinct user_id) as active_users
from
    Activity
where
    activity_date <= '2019-07-27' and activity_date > date_sub('2019-07-27', interval 30 day)
group by
    activity_date