SELECT U.USER_ID
,U.NICKNAME
,CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS 전체주소
,CONCAT(SUBSTRING(TLNO, 1,3), '-', SUBSTRING(TLNO, 4,4), '-', SUBSTRING(TLNO,8)) AS 전화번호
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_USER U
ON B.WRITER_ID = U.USER_ID

GROUP BY B.WRITER_ID
HAVING COUNT(B.WRITER_ID) >= 3

ORDER BY U.USER_ID DESC