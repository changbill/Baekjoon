SELECT 
    E.EMP_NO, 
    E.EMP_NAME,
    G.GRADE,
    E.SAL * (
        CASE
            WHEN G.GRADE = 'S' THEN 0.2
            WHEN G.GRADE = 'A' THEN 0.15
            WHEN G.GRADE = 'B' THEN 0.1
            ELSE 0
        END
     ) AS BONUS
FROM HR_EMPLOYEES E
JOIN (
    SELECT 
        EMP_NO, 
        AVG(SCORE) AS SCORE,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
) G
ON E.EMP_NO = G.EMP_NO
ORDER BY E.EMP_NO










# SELECT
#     E.EMP_NO,
#     E.EMP_NAME,
#     G.GRADE,
#     E.SAL * (CASE 
#                 WHEN G.GRADE = 'S'THEN 0.2 
#                 WHEN G.GRADE = 'A' THEN 0.15 
#                 WHEN G.GRADE = 'B' THEN 0.1 
#                 ELSE 0 
#              END) AS BONUS
# FROM HR_EMPLOYEES E
# JOIN (
#     SELECT
#         EMP_NO,
#         CASE
#             WHEN AVG(SCORE) >= 96 THEN 'S'
#             WHEN AVG(SCORE) >= 90 THEN 'A'
#             WHEN AVG(SCORE) >= 80 THEN 'B'
#             ELSE 'C'
#         END AS GRADE
#     FROM HR_GRADE
#     GROUP BY EMP_NO
# ) G
# ON E.EMP_NO = G.EMP_NO
# JOIN HR_DEPARTMENT D
# ON E.DEPT_ID = D.DEPT_ID