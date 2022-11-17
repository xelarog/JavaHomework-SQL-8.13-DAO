select product_name
from orders o
join customers c on c.id = o.customer_id
where lower(c.name) = lower(:name)