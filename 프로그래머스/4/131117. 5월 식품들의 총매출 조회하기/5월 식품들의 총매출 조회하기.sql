-- 코드를 입력하세요
SELECT a.product_id, a.product_name, sum(a.price * b.amount) as TOTAL_SALES
from food_product as a
inner join food_order as b
on a.product_id = b.product_id
where b.produce_date >='2022-05-01'
and b.produce_date < '2022-06-01'
group by a.product_id
order by 3 desc, a.product_id asc