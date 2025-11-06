/* Step 1: Ek temporary table (CTE) banate hain jismein har product ki 
         2019-08-16 tak ki sabse latest price change ko rank 1 milega.
*/
WITH PricesOnDate AS (
    SELECT 
        product_id, 
        new_price,
        /* Har product ke group (PARTITION BY) mein, dates ko descending order (DESC) mein rank do.
         Sabse nayi date ko rank (rn) = 1 milega.
        */
        ROW_NUMBER() OVER(
            PARTITION BY product_id 
            ORDER BY change_date DESC
        ) AS rn
    FROM 
        Products
    WHERE 
        /* Sirf woh rows lo jo 2019-08-16 ko ya usse pehle ki hain.
         (Product 2 ki 2019-08-17 wali entry ignore ho jayegi)
        */
        change_date <= '2019-08-16'
),

/* Step 2: Upar wali temporary table se sirf rank 1 wali rows nikal lo.
         Yeh humein 2019-08-16 ke din ki valid price dega.
         (Product 1 = 35, Product 2 = 50)
*/
LatestPrices AS (
    SELECT product_id, new_price
    FROM PricesOnDate
    WHERE rn = 1
)

/* Step 3: Final Result.
         Hum Products table se *saare* unique product IDs (1, 2, 3) lete hain.
         Phir LEFT JOIN karte hain LatestPrices ke saath.
*/
SELECT 
    p.product_id,
    /*
     IFNULL check karta hai:
     - Agar LatestPrices.new_price available hai (JOIN successful hua), toh woh price dikhao.
     - Agar woh NULL hai (matlab Product 3 ke liye), toh default price 10 dikhao.
    */
    IFNULL(lp.new_price, 10) AS price
FROM 
    -- Pehle saari unique product IDs le lo (1, 2, 3)
    (SELECT DISTINCT product_id FROM Products) AS p
LEFT JOIN 
    -- Unhe unki latest valid price se jodo
    LatestPrices AS lp ON p.product_id = lp.product_id;