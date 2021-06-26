## Unit Testing Scenario
Melakukan pengujian tiap ViewModel dan LiveData

1. **MoviesViewModelTest**
    - Memuat **MOVIES**
        - Memanipulasi data ketika pemanggilan data **MOVIES** dikelas **REPOSITORY**
        - Memastikan metode di kelas **REPOSITORY** terpanggil
        - Memastikan Data **MOVIES** tidak null
        - Memastikan jumlah data **MOVIES** sesuai yang diharapkan


2. **TvShowsViewModelTest**
    - Memuat **TV SHOWS**
        - Memanipulasi data ketika pemanggilan data **TV SHOWS** dikelas **REPOSITORY**
        - Memastikan metode di kelas **REPOSITORY** terpanggil
        - Memastikan Data **TV SHOWS** tidak null
        - Memastikan jumlah data **TV SHOWS** sesuai dengan yang diharapkan 


3. **DetailMoviesViewModelTest**
    - Memuat **movies**
        - Memanipulasi data ketika pemanggilan data **MOVIES** dikelas **REPOSITORY**
        - Memastikan metode di kelas **REPOSITORY** terpanggil
        - Memastikan data **MOVIES** tidak null
        - Memastikan data **MOVIES** sesuai dengan yang diharapkan


4. **DetailTvShowsViewModelTest**
    - Memuat **TV SHOWS**
        - Memanipulasi data ketika pemanggilan data **TV SHOWS** dikelas **REPOSITORY**
        - Memastikan metode di kelas **REPOSITORY** terpanggil
        - Memastikan data **TV SHOWS** tidak null
        - Memastikan data **TV SHOWS** sesuai dengan yang diharapkan


## Instrument Test Scenario
Melakukan pengujian tiap halaman dan keseluruhan Aplikasi

1. **Menampilkan data Movies**
    - Memastikan data selesai dimuat terlebih dahulu dengan menggunakan **ESPRESSO IDLINGRESOURCE**
    - Memastikan **rv_movies** dalam keadaan tampil
    - Gulir **rv_movies** ke posisi data terakhir


2. **Menampilkan data detail Movies**
    - Memastikan data selesai dimuat terlebih dahulu dengan menggunakan **ESPRESSO IDLINGRESOURCE**
    - Memberi tindakan klik data pertama di **rv_movies**
    - Memastikan **TextView** untuk **tv_detail_title** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_rd** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_genre** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_tt** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_quote** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_txt_overview** tampil sesuai dengan yang diharapkan
    - Memastikan **ImageView** untuk **img_poster** dalam keadaan tampil
    

3. **Menampilkan data TV SHOWS**
    - Memastikan data selesai dimuat terlebih dahulu dengan menggunakan **ESPRESSO IDLINGRESOURCE**
    - Klik TabLayout dengan teks **TV SHOWS**
    - Memastikan **rv_tv_shows** dalam keadaan tampil
    - Gulir **rv_tv_shows** ke posisi terakhir
    

4. **Menampilkan data detail TV SHOWS**
    - Memastikan data selesai dimuat terlebih dahulu dengan menggunakan **ESPRESSO IDLINGRESOURCE**
    - Klik TabLayout dengan teks **TV SHOWS**
    - Memberi tindakan klik data pertama di **rv_tv_shows**
    - Memastikan **TextView** untuk **tv_detail_title_tvShows** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_network_tvShows** tampil sesuai dengan yang diharapkan 
    - Memastikan **TextView** untuk **tv_detail_genre_tvShows** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_tt_tvShows** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_quote** tampil sesuai dengan yang diharapkan
    - Memastikan **TextView** untuk **tv_detail_overview** tampil sesuai dengan yang diharapkan
    - Memastikan **ImageView** untuk **img_poster_tvShows** dalam keadaan tampil           
        