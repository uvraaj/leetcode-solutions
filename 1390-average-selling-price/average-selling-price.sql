select 
    p.product_id,
    round(coalesce(sum(us.units*p.price) / sum(us.units), 0), 2) as average_price
from 
    prices as p
left join 
    unitsSold as us 
on
    p.product_id = us.product_id and
    us.purchase_date between p.start_date and p.end_date
group by
    p.product_id
