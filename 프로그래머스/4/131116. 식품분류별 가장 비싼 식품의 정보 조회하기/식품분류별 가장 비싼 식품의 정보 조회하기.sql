-- 코드를 입력하세요
select category, price as MAX_PRICE, product_name
from food_product
where (category, price)in (
    select category, MAX(price)
    from food_product
    group by category
    having category in ('과자','국','김치','식용유')
)
order by 2 DESC