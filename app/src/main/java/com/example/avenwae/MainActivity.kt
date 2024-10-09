package com.example.avenwae

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.avenwae.ui.theme.Artwork
import com.example.avenwae.ui.theme.AvenWaeTheme

//hallo semuanya ini bagian fungsi pertama dari aplikasih saya,
// pertama kita mulai membbuat kelas utama yaitu MainActivity dan componenActivitynya
//componenAcivity ini untuk mendeklarasikan kelas turunan dari Activity
// seperti kelas activity jectpack compos untuk menyediakan fungsi fungsi dasar mengelolah siklus hidup activity dan menampilkan UI
// overide fun oncreate (savedInstanceSate: Bundle?)
// overide fun oncreate fungsi activity pertama keli saat activity di buat, bagian dari siklus hidup activity
// savedInstanceSate: Bundle? ini berisi data yang disimpan saat activity di rotasi atau dihentikan (misalnya ketika orintasi layar berubah)

//super.onCreate(savedInstanceState) funsi ini untuk memanggil onCreate dari kelas induk (Activity)
//setContent, fungsi ini digunakan untuk mendefenisikan UI dari activity yang mengunakan jetpack compose.
// kode didalam setconten akan menentukan bagimana ui akan didesain dan akan di tampilkan.
// AvenWaeTheme { ... }:
//AvenWaeTheme: Ini kemungkinan adalah Composable function yang Kakak definisikan untuk menerapkan tema aplikasi Kakak.
//Tema ini dapat mencakup warna, tipografi, dan gaya visual lainnya.
//AvenWaeApp():
//AvenWaeApp: Ini adalah Composable function utama yang Kakak definisikan untuk membangun UI aplikasi Kakak.
// Fungsi ini akan dipanggil di dalam AvenWaeTheme untuk menampilkan konten aplikasi.
// Ringkasan Secara sederhana, kode tersebut mendefinisikan Activity utama aplikasi Kakak (MainActivity) yang menggunakan Jetpack Compose untuk menampilkan UI.
// Saat Activity dibuat, fungsi onCreate akan dipanggil, dan di dalam fungsi tersebut, UI aplikasi akan didefinisikan menggunakan setContent dan Composable functions seperti AvenWaeTheme dan AvenWaeApp.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvenWaeTheme {
                AvenWaeApp()

            }
        }
    }
}

// sekarang kita masuk ke fungsi AvenWaeApp()
// Fungsi ini adalah inti dari UI aplikasi, bertanggung jawab untuk menampilkan dan mengelola tampilan aplikasi.
// @SuppressLint("AutoboxingStateCreation"): Menekan peringatan tentang pembuatan objek State secara otomatis.
// @OptIn(ExperimentalMaterial3Api::class): Menandakan penggunaan API Material 3 eksperimental.
// @Composable: Menandai fungsi ini sebagai pembangun UI di Jetpack Compose.

// sekarang kita masuk ke bagian data class artwork.
// currentArtworkIndex: Variabel yang menyimpan indeks gambar yang sedang ditampilkan, diinisialisasi dengan 0.
//remember: Memastikan nilai currentArtworkIndex dipertahankan selama recomposition.
//mutableStateOf: Membuat objek State yang dapat diubah, memicu recomposition saat diubah.
//artworks: Daftar objek Artwork yang berisi data gambar (resource ID, judul, artis, tahun)
@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvenWaeApp() {
    var currentArtworkIndex by remember { mutableStateOf(0) }
    val artworks = listOf(
        Artwork(R.drawable.gambar1, "Rumah Adat Waerebo", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar2, "Pantai Labuan Bajo", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar3, "Danau Tiga Warna", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar4, "Air Panas Soa", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar5, "Pulau Komodo", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar6, "Rumah Adat Bena", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar7, "Alam Sumba", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar8, "Pantai Pink", "Aven Meo", "2024"),
        Artwork(R.drawable.gambar9, "Labuan Bajo View", "Aven Meo", "2024")
        // tambahkan gambar jika perlu.
    )

//oke sekarang kita masuk ke bagian Background Image Composble
//@Composable: Menandai fungsi ini sebagai pembangun UI di Jetpack Compose.
//fun BackgroundImage(imageResId: Int): Fungsi yang menerima ID resource gambar sebagai parameter.
//Image: Menampilkan gambar menggunakan painterResource dengan ID yang diberikan.
//contentDescription = null: Deskripsi konten untuk aksesibilitas, di sini diset null.
//modifier = Modifier.fillMaxSize(): Mengisi seluruh layar dengan gambar.
//contentScale = ContentScale.Crop: Memotong gambar agar sesuai dengan ukuran layar. Scaffold dan TopAppBar
//Scaffold: Menyediakan struktur dasar layout aplikasi (TopAppBar, BottomAppBar, FAB, Drawer).
//topBar: Mendefinisikan TopAppBar.
//CenterAlignedTopAppBar: Membuat TopAppBar dengan judul di tengah.
//title: Menampilkan teks "WISATA NUSA TENGGARA TIMUR" sebagai judul.
//fontWeight = FontWeight.Bold: Menebalkan teks judul.
//color = Color.White: Memberi warna putih pada teks judul.
//colors: Menentukan warna TopAppBar, di sini hijau (0xFF008000). Box, Column, dan Row
//Box: Wadah untuk menumpuk elemen, di sini digunakan untuk menempatkan BackgroundImage di belakang konten lainnya.
//BackgroundImage: Memanggil fungsi BackgroundImage untuk menampilkan gambar latar belakang.
//Column: Menyusun elemen secara vertikal.
//ArtworkDisplay: Menampilkan gambar dan informasi karya seni.
//Spacer: Menambahkan ruang kosong vertikal.
//Row: Menyusun elemen secara horizontal.
//Button: Tombol "Previous" dan "Next" untuk navigasi. Navigasi
//onClick: Menentukan aksi saat tombol diklik.
//(currentArtworkIndex - 1 + artworks.size) % artworks.size: Logika untuk menampilkan gambar sebelumnya.
//(currentArtworkIndex + 1) % artworks.size: Logika untuk menampilkan gambar berikutnya. Ringkasan Kode ini membangun UI aplikasi dengan gambar latar belakang, TopAppBar, dan konten yang menampilkan gambar dan informasi karya seni. Tombol "Previous" dan "Next" digunakan untuk navigasi antar gambar
    @Composable
    fun BackgroundImage(imageResId: Int) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Sesuaikan dengan kebutuhan
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "WISATA NUSA TENGGARA TIMUR",// judul pada tollbar
                        fontWeight = FontWeight.Bold, // Menebalkan huruf
                        color = Color.White // Memberi warna putih pada huruf
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF008000) // Memberi warna hijau pada TopAppBar
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            BackgroundImage(imageResId = R.drawable.background_image)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ArtworkDisplay(artwork = artworks[currentArtworkIndex])

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = {
                        currentArtworkIndex =
                            (currentArtworkIndex - 1 + artworks.size) % artworks.size
                    }) {
                        Text("Previous")
                    }

                    Button(onClick = {
                        currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
                    }) {
                        Text("Next")
                    }
                }
            }
        }
    }
}

// sekarang kita berada di bagian modif ArworkDisplay Composeble
//@Composable: Menandai fungsi ini sebagai pembangun UI di Jetpack Compose.
//fun ArtworkDisplay(artwork: Artwork): Fungsi yang menerima objek Artwork sebagai parameter. Objek Artwork berisi data gambar, judul, artis, dan tahun.
//Column: Menyusun elemen secara vertikal.
//modifier: Modifier yang diterapkan pada Column.
//.fillMaxWidth(): Membuat Column mengisi lebar layar.
//.padding(16.dp): Menambahkan padding 16.dp di sekitar Column.
//.offset(y = (-60).dp): Menggeser Column ke atas sebesar 60.dp.
//horizontalAlignment = Alignment.CenterHorizontally: Menyelaraskan elemen-elemen di dalam Column secara horizontal di tengah.
//verticalArrangement = Arrangement.Top: Menyusun elemen-elemen di dalam Column secara vertikal dari atas.
//Image: Menampilkan gambar.
//painter = painterResource(id = artwork.imageResourceId): Menggunakan painterResource untuk memuat gambar dari resource ID yang terdapat di objek artwork.
//contentDescription = null: Deskripsi konten untuk aksesibilitas, di sini diset null.
//modifier: Modifier yang diterapkan pada Image.
//.fillMaxWidth(): Membuat gambar mengisi lebar layar.
//.height(250.dp): Menetapkan tinggi gambar menjadi 250.dp.
//.clip(RoundedCornerShape(16.dp)): Memotong gambar dengan bentuk sudut melengkung dengan radius 16.dp.
//contentScale = ContentScale.Crop: Memotong gambar agar sesuai dengan ukuran yang ditentukan.
//Spacer: Menambahkan ruang kosong vertikal.
//modifier = Modifier.height(16.dp): Menetapkan tinggi ruang kosong menjadi 16.dp.
//Text: Menampilkan teks.
//text: Teks yang akan ditampilkan, diambil dari data di objek artwork.
//style: Gaya teks, menggunakan tipografi Material Theme.
//fontWeight = FontWeight.Bold: Menebalkan teks.
//textAlign = TextAlign.Center: Menyelaraskan teks di tengah.
@Composable
fun ArtworkDisplay(artwork: Artwork) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(y = (-60).dp),// menggeser gambar ke atas

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Image(
            painter = painterResource(id = artwork.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)// ukuran gambar
                .clip(RoundedCornerShape(16.dp)), // sudut gambar melengkung
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = artwork.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "by ${artwork.artist}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = artwork.year,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

