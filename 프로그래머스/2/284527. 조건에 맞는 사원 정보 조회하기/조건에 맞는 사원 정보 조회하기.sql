WITH RANKED_SCORE AS (SELECT
    SUM(G.SCORE) AS SCORE,
    E.EMP_NO,
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL,
    RANK() OVER (ORDER BY SUM(G.SCORE) DESC) AS RANKING
FROM HR_EMPLOYEES E
JOIN HR_GRADE G
ON E.EMP_NO = G.EMP_NO
WHERE G.YEAR = 2022
GROUP BY E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
)
SELECT SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL
FROM RANKED_SCORE
WHERE RANKING = 1