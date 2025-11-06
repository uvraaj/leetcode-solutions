-- ========= HISSA 1: CHANGED PRODUCTS =========
-- Woh products dhundo jinki price 2019-08-16 tak change hui
-- aur unki sabse latest price nikalo.
SELECT
    product_id,
    new_price as price
FROM
    Products
WHERE
    (product_id, change_date) IN (
        -- Yeh Subquery har product ki 2019-08-16 tak ki
        -- sabse latest (MAX) date nikalegi
        SELECT
            product_id,
            MAX(change_date)
        FROM
            Products
        WHERE
            change_date <= '2019-08-16'
        GROUP BY
            product_id
    )

UNION

-- ========= HISSA 2: UNCHANGED PRODUCTS =========
-- Woh products dhundo jinki price 10 hai (jo 2019-08-16 tak change nahi hue)
SELECT
    product_id,
    10 AS price
FROM
    -- Pehle saare unique product IDs le lo (1, 2, 3)
    (SELECT DISTINCT product_id FROM Products) AS all_products
WHERE
    product_id NOT IN (
        -- Un sabhi products ko HATA DO (NOT IN)
        -- jinki 2019-08-16 ya usse pehle koi bhi entry hai
        SELECT DISTINCT
            product_id
        FROM
            Products
        WHERE
            change_date <= '2019-08-16'
    )
order by product_id