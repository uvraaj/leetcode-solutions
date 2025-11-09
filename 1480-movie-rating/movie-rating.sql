(
    select
        u.name as results
    from
        MovieRating as m
    join
        Users as u
        on m.user_id = u.user_id
    group by
        m.user_id, u.user_id
    order by
        count(m.movie_id) desc,
        u.name asc
    limit 1
)
union all
(
    select
        m.title as results
    from
        MovieRating as mr
    join 
        Movies as m
        on m.movie_id = mr.movie_id
    where
        mr.created_at like '2020-02%'
    group by
        mr.movie_id, m.title
    order by
        avg(mr.rating) desc,
        m.title asc
    limit 1
)



