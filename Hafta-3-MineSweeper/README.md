# Mayın Tarlası Oyunu

## Proje Amaçları
Bu proje, Mayın Tarlası oyununu Java programlama dili kullanarak oluşturmayı amaçlar. Oyuncular bir oyun tahtasının üzerinde rastgele yerleştirilmiş mayınları açmadan tüm hücreleri açmayı hedefler.

## Kullanılan Teknolojiler
Java

## Nasıl Oynanır

Oyunu başlatmak için MineSweeper.java dosyasını çalıştırın. Oyun başladığında size bir oyun tahtası oluşturmanız için bazı seçenekler sunulacaktır.

İlk olarak, oyun tahtasının boyutunu belirleyin. Örneğin, 5x5 veya 10x10 bir tahta seçebilirsiniz. Bu oyunun zorluğunu belirleyecektir.

Oyun tahtasını oluşturduktan sonra, her hücreyi koordinatlarla açabilirsiniz. Örneğin, satır 3 sütun 2 girdisiyle bir hücre açabilirsiniz.

Bir hücre açtığınızda aşağıdaki senaryolardan biri gerçekleşebilir:

- Eğer tıkladığınız hücrede bir mayın varsa, oyunu kaybedersiniz ve "Game Over." mesajı görüntülenir.
- Eğer tıkladığınız hücrede bir mayın yoksa, hücrenin etrafındaki mayınların sayısı görüntülenir.
- Eğer etrafında hiç mayın yoksa, hücre 0 olarak işaretlenir.
  
Oyunda amaç tüm mayınsız hücreleri açarak oyunu kazanmaktır. Tüm mayınsız hücreleri açtığınızda "You won!" mesajı görüntülenir ve oyun tamamlanır.

Oyununuzu keyifle oynayın ve mayınlara dikkat edin!
