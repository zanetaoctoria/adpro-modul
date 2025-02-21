# E-Shop

## Modul 1 : Prinsip Clean Code

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

Dengan pendekatan ini, saya dapat memastikan keamanan, stabilitas, dan efisiensi dalam pengembangan dan penerapan aplikasi saya.




