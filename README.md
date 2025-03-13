# E-Shop

## Modul 1

### 1. Separation of Concerns
Kode terbagi dengan jelas ke dalam tiga lapisan utama:
- **Controller**: Menangani permintaan dari pengguna dan mengembalikan respons yang sesuai.
- **Service**: Mengelola logika bisnis aplikasi.
- **Repository**: Bertanggung jawab atas interaksi dengan database.

### 2. Penamaan yang Jelas
- Nama kelas, metode, dan variabel dibuat agar mudah dipahami.
- Struktur kode yang rapi membantu dalam pemeliharaan dan pengembangan lebih lanjut.

### 3. Komentar yang Informatif
- Komentar singkat disediakan untuk menjelaskan fungsi bagian-bagian penting dalam kode.
- Hanya menambahkan komentar yang benar-benar diperlukan untuk menjaga keterbacaan kode.

## Praktik Keamanan

### 1. Perlindungan CSRF
- Semua operasi yang mengubah data menggunakan metode **POST** untuk mengurangi risiko **Cross-Site Request Forgery (CSRF)**.

### 2. UUID untuk ID Produk
- ID setiap produk dihasilkan menggunakan **UUID**, memastikan identifikasi yang unik dan lebih aman.

### 3. Validasi Input
- Validasi dasar diterapkan pada sisi **HTML** untuk mencegah input yang tidak valid.
- Validasi tambahan dapat dilakukan di sisi server menggunakan anotasi seperti `@Valid` untuk meningkatkan keamanan dan keandalan data.

## Modul 2 

### Pertanyaan 1
Selama latihan, saya menemukan bahwa workflow GitHub Actions saya menggunakan izin token default, yang terlalu luas untuk memungkinkan pemeriksaan keamanan dan pemindaian kode (Scorecard dan CI) berhasil. Untuk mengatasi hal ini, saya menambahkan:

```yaml
permissions:
  contents: read
```
ke dalam workflow CI saya (`.github/workflows/ci.yml`) dan (`.github/workflows/scorecard.yml`). Dengan melakukan ini, saya mengikuti prinsip least privilege, memastikan workflow hanya memiliki akses minimal yang diperlukan (read), sehingga menyelesaikan masalah keamanan dan kualitas kode yang terdeteksi.

### Pertanyaan 2
Ya, saya yakin setup CI/CD saya saat ini sudah memenuhi definisi Continuous Integration dan Continuous Deployment. Berikut adalah alasannya:

1. **Continuous Integration:** Setiap push atau pull request secara otomatis memicu pengujian dan pemindaian kode. Hal ini memungkinkan deteksi dini masalah integrasi dan menjaga stabilitas kode.
2. **Continuous Deployment:** Setelah pengujian berhasil, pipeline secara otomatis menerapkan pembaruan aplikasi ke Koyeb tanpa intervensi manual, mencerminkan prinsip Continuous Deployment.
3. **End-to-End Automation:** Proses ini berjalan secara otomatis dari commit kode, pengujian, hingga deployment ke produksi. Dengan demikian, aplikasi tetap teruji, terpelihara, dan dikirimkan dengan andal.

## MODUL 3 

### **Prinsip SOLID yang Diterapkan dalam Proyek**
Dalam proyek ini, saya menerapkan prinsip SOLID untuk meningkatkan kualitas kode dan membuatnya lebih modular serta mudah dipelihara. Berikut adalah prinsip-prinsip yang diterapkan:

1. **Single Responsibility Principle (SRP)**: Setiap kelas memiliki satu tanggung jawab utama.
    - Contoh: Model seperti `Product` dan `Car` hanya berfungsi untuk merepresentasikan data, sedangkan `ProductService` dan `CarService` hanya menangani logika bisnis.

2. **Open/Closed Principle (OCP)**: Kode dapat diperluas tanpa harus mengubah kode yang sudah ada.
    - Contoh: Penggunaan kelas abstrak seperti `Item` memungkinkan pembuatan subclass seperti `Car` dan `Product` tanpa harus mengubah `Item`.

3. **Liskov Substitution Principle (LSP)**: Subclass dapat menggantikan superclass tanpa mengubah perilaku sistem.
    - Contoh: Kelas `Car` dan `Product` mewarisi `Item`, sehingga bisa digunakan di seluruh sistem tanpa mengganggu fungsionalitas yang sudah ada.

4. **Interface Segregation Principle (ISP)**: Setiap class hanya bergantung pada metode yang diperlukan.
    - Contoh: `ProductController` hanya bergantung pada metode yang dibutuhkan tanpa harus menggunakan keseluruhan fungsi dalam satu interface besar.

5. **Dependency Inversion Principle (DIP)**: Setiap layer bergantung pada abstraksi, bukan pada implementasi langsung.
    - Contoh: Spring menggunakan Inversion of Control (IoC) dan Dependency Injection sehingga `Service` tidak langsung bergantung pada `Repository`, melainkan melalui interface seperti `ProductRepository` dan `ItemService`.

## **Keuntungan Penerapan SOLID Principles**
1. **Meningkatkan Maintainability**:
    - Kode lebih mudah dipahami, diperbaiki, dan diperluas.
    - Contoh: `ProductService` hanya bertanggung jawab atas logika bisnis, sementara `ProductController` hanya menangani HTTP request.

2. **Meningkatkan Fleksibilitas dan Skalabilitas**:
    - Kelas dapat diperluas tanpa mengubah kode yang sudah ada.
    - Contoh: Untuk menambahkan jenis produk baru, cukup membuat subclass dari `Item`, tanpa harus mengubah kode inti.

3. **Meningkatkan Reusability**:
    - Subclass dapat menggantikan superclass tanpa mempengaruhi fungsi sistem.
    - Contoh: `Car` dan `Product` dapat digunakan di mana pun `Item` diperlukan, tanpa menyebabkan error atau perubahan pada implementasi lain.

## **Dampak Buruk Jika SOLID Tidak Diterapkan**

1. **Kompleksitas Kode yang Tinggi**: Tanpa SRP, kelas bisa memiliki banyak tanggung jawab, membuat kode sulit dipahami dan diperbaiki.
    - Contoh: Jika `ProductService` menangani baik logika bisnis maupun penyimpanan data, perubahan kecil dapat menyebabkan banyak error.

2. **Tight Coupling**: Tanpa OCP, kode menjadi sulit dikembangkan dan diperbaiki karena setiap perubahan memengaruhi banyak bagian lainnya.
    - Contoh: Jika `ProductRepository` langsung bergantung pada `ProductService`, perubahan kecil dapat merusak berbagai fungsi yang menggunakan repository tersebut.

## **Kesimpulan**
Penerapan prinsip SOLID sangat penting untuk menciptakan sistem yang **scalable, mudah diuji, dan mudah dipelihara**. Dengan menerapkan prinsip ini, kita dapat meningkatkan fleksibilitas dalam menambahkan fitur baru tanpa mengubah kode yang ada, mengurangi kompleksitas, serta mencegah ketergantungan yang berlebihan antar kelas. Oleh karena itu, mengikuti SOLID principles sangat direkomendasikan dalam pengembangan perangkat lunak, terutama untuk sistem yang berkembang dan membutuhkan arsitektur yang kuat.




