# Kütüphane Yönetim Sistemi

Bu proje, bir kütüphane yönetim sistemi tasarlamayı amaçlamaktadır. Aşağıda belirtilen varlık sınıfları ve ilişkiler kullanılarak bir PostgreSQL veritabanı üzerinde uygulama geliştirilmiştir.

## Dependency'ler

Projeyi çalıştırmak için aşağıdaki Maven dependency'leri kullanılmıştır:

```xml
<dependencies>
    <!-- PostgreSQL JDBC Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.2.5</version>
    </dependency>

    <!-- Hibernate JPA -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.5.Final</version>
    </dependency>
</dependencies>
```
## Entity Sınıfları ve İlişkiler
Projede aşağıdaki entity sınıfları ve ilişkiler tanımlanmıştır:

### Kitap (Book)

- **id:** Benzersiz kitap kimliği
- **name:** Kitap adı
- **publicationYear:** Yayın yılı
- **stock:** Kütüphanedeki miktarı

**Yazar ile One-to-Many İlişkisi:**
Bir kitabın bir yazarı olabilir, bir yazarın birden fazla kitabı olabilir.

![Screenshot_1.png]



### Yazar (Author)

- **id:** Benzersiz yazar kimliği
- **name:** Yazarın adı
- **birthDate:** Yazarın doğum yılı
- **country:** Yazarın ülkesi

**Kitap ile One-to-Many İlişkisi:**
Bir yazarın birden fazla kitabı olabilir, bir kitabın bir yazarı olabilir.

![Screenshot_2.png]

### Kategoriler (Category)

- **id:** Benzersiz kategori kimliği
- **name:** Kategori adı
- **description:** Kategori tanımı

**Kitap ile Many-to-Many İlişkisi:**
Bir kategori birden fazla kitaba sahip olabilir, bir kitap birden fazla kategoriye ait olabilir.

![Screenshot_4.png]

### Yayınevi (Publisher)

- **id:** Benzersiz yayınevi kimliği
- **name:** Yayınevi ismi
- **establishmentYear:** Kuruluş yılı
- **address:** Yayınevi adresi

**Kitap ile One-to-Many İlişkisi:**
Bir kitabın bir yayınevi olabilir, bir yayınevinin birden fazla kitabı olabilir.

![Screenshot_6.png]

### Kitap Ödünç Alma (BookBorrowing)

- **id:** Benzersiz ödünç alma kimliği
- **borrowerName:** Kitap ödünç alan kişi adı soyadı
- **borrowingDate:** Kitap ödünç alma tarihi
- **returnDate:** Kitabın teslim edildiği tarih, ilk kayıtta null olacak. Kitap teslim edilince tarih güncellenecek

**Kitap ile One-to-Many İlişkisi:**
Bir kitap birden fazla ödünç alma işlemine sahip olabilir, ancak her ödünç alma işlemi yalnızca bir kitaba ait olabilir.

![Screenshot_3.png]