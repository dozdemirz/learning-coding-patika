
# DVD Rental Veritabanı Sorguları

## 1. Film tablosunda bulunan filmleri `rating` değerlerine göre gruplayınız.
```sql
SELECT rating, COUNT(*) FROM film
GROUP BY rating;
```
## 2. Film tablosunda bulunan filmleri replacement_cost sütununa göre grupladığımızda film sayısı 50'den fazla olan replacement_cost değerini ve karşılık gelen film sayısını sıralayınız.
```sql
SELECT replacement_cost, COUNT(*) as film_sayisi FROM film
GROUP BY replacement_cost
HAVING COUNT(*) > 50
ORDER BY film_sayisi DESC;
```
## 3. Customer tablosunda bulunan store_id değerlerine karşılık gelen müşteri sayılarını nelerdir?
```sql
SELECT store_id, COUNT(*) as musteri_sayisi FROM customer
GROUP BY store_id;
```
## 4. City tablosunda bulunan şehir verilerini country_id sütununa göre gruplandıktan sonra en fazla şehir sayısı barındıran country_id bilgisini ve şehir sayısını paylaşınız.
```sql
SELECT country_id, COUNT(*) as sehir_sayisi FROM city
GROUP BY country_id
ORDER BY sehir_sayisi DESC
LIMIT 1;
```