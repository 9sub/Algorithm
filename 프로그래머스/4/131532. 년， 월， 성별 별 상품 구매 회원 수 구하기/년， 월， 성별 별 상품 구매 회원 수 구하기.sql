-- 코드를 입력하세요
SELECT YEAR(B.SALES_DATE) AS YEAR, MONTH(B.SALES_DATE) AS MONTH, A.GENDER, COUNT(DISTINCT B.USER_ID) AS USERS
FROM USER_INFO AS A
JOIN ONLINE_SALE AS B ON A.USER_ID = B.USER_ID
WHERE A.GENDER IS NOT NULL
GROUP BY 1,2,3
ORDER BY 1,2,3