# E-Shop

## Prinsip Clean Code

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


