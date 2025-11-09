select
    case
        when s.id % 2 = 0 then s.id - 1
        when s.id % 2 = 1 and s.id < m.max_id then s.id + 1
        else s.id
    end as id,
    s.student
from 
    Seat as s,
    (select max(id) as max_id from Seat) as m
order by
    id