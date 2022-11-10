# Fibabank Speed Bootcamp Projesi <br>  
>* Proje, 3 ayrı proje(mikroservis)den oluşmaktadır.
>* Üç mikroserviste aynı veritabanına bağlanmaktadır ancak her birinin kendine özel tablosu vardır<br>
>* Veritabanı teknolojisi olarak MySQL kullanılmıştır.

## Inventory
Inventory mikroservisi 8081 portu üzerinden çalışmaktadır.
![img.png](img.png) <br>
> İçerisinde ürün ve kategori işlemlerinin yapılmasını sağlamak üzere ilgili paketlerin içinde entityler, controllerlar, dtolar ve repositoryler(interface) vardır.<br>

>* ProductController sınıfındaki getProduct() metodu veritabanındaki ürünleri çekmemizi sağlamaktadır. <br>
> ![img_1.png](img_1.png) <br>
> ![img_2.png](img_2.png) <br>
> ![img_3.png](img_3.png) <br>

>* ProductController sınıfındaki getProductsByCategoryId() metodu kategoriye göre ürünleri çekmemizi sağlamaktadır. <br>
> ![img_4.png](img_4.png) <br>
> ![img_5.png](img_5.png) <br>

>* ProductController sınıfındaki getAllProducts() metodu tüm ürünleri çekmemizi sağlamaktadır. <br>
> ![img_6.png](img_6.png) <br>

>* CategoryController sınıfındaki getCategories() metodu tüm kategorileri çekmemizi sağlamaktadır. <br>
> ![img_7.png](img_7.png) <br>
> ![img_8.png](img_8.png) <br>


## Shopping
Shopping mikroservisi 8082 portu üzerinden çalışmaktadır.<br>
![img_9.png](img_9.png) <br>
>* CartController sınıfındaki createCart metodu ile sepet oluşturulabilmektedir.<br>
> ![img_10.png](img_10.png) <br>
> Onun altındaki addProductToCart metodu ile de sepete ürün eklenebilmektedir.<br>
> ![img_11.png](img_11.png) <br>
> ![img_12.png](img_12.png) <br>

CartController sınıfı içerisindeki checkout metodu ile sepet güncellenmekte ve removeProductInCart metodu ile de sepetten ürün silinebilmektedir. <br>
![img_14.png](img_14.png) <br>

## Commerce
>* 8080 portunda çalışmaktadır. <br>
>* Bu kısımda ise diğer iki kısımdaki işler bir arada yapılabilmektedir.<br>
>* Controller metotları ve bir kısım arayüz işlemleri yapılabilmektedir.<br>
>* Önceki iki mikroservisteki metotlar CategoryClient, ProductClient, CartClient (aslında controller) sınıfları ile çağırılmaktadır.<br>
> ![img_15.png](img_15.png) <br>
> Zaman darlığından dolayı sadece product ve category için index sayfası hazırlayabildim.<br>
> index.html'de category'ler görüntülenmekte ve ilgili kategoriye tıkladığımızda bize o kategoriye ait ürünleri göstermektedir.<br>
>* ![img_16.png](img_16.png) <br>
>* kategoriye tıkladığımızda ise o kategoriye ait ürünlerin olduğu sayfaya gideriz<br>
>* ![img_17.png](img_17.png) <br>
>* Yine ürünlere de tıklayınca ürünün detayının görüntülendiği sayfaya gideriz.<br>
>* ![img_18.png](img_18.png) <br>

>* Cart ve CartProduct işlemleri sadece metotları tanımlanabilmiştir.(Zaman darlığından dolayı)<br>
>* ![img_19.png](img_19.png) <br>
>* ![img_20.png](img_20.png) <br>