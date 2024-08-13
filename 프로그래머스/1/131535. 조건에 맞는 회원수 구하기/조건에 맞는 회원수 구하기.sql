# GENDER
# 0은 남자, 1은 여자
SELECT
COUNT(*) AS USERS
FROM USER_INFO
WHERE DATE_FORMAT(JOINED, '%Y') = 2021
AND AGE >= 20
AND AGE <= 29