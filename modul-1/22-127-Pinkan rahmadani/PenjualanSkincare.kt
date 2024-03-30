import java.util.*

object PenjualanSkincare {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val toko = SkincareToko()

        println("Selamat datang di Sistem Penjualan Skincare")
        var lanjutkan = true

        while (lanjutkan) {
            println("\nPilihan Menu:")
            println("1. Catat Penjualan")
            println("2. Lihat Total Penjualan")
            println("3. Beli Produk")
            println("4. Keluar")

            print("Masukkan pilihan Anda: ")
            val pilihan = scanner.nextInt()

            when (pilihan) {
                1 -> {
                    println("Pilihan Produk:")
                    println("1. Cleanser")
                    println("2. Moisturizer")
                    println("3. Sunscreen")
                    println("4. Serum")
                    println("5. Toner")
                    println("6. Face Mask")
                    println("7. Eye Cream")
                    println("8. Spot Treatment")
                    println("9. Exfoliator")
                    println("10. Face Oil")
                    // Tambahkan lebih banyak produk jika diperlukan

                    print("Masukkan nomor produk: ")
                    val nomorProduk = scanner.nextInt()

                    val namaProduk = when (nomorProduk) {
                        1 -> "Cleanser"
                        2 -> "Moisturizer"
                        3 -> "Sunscreen"
                        4 -> "Serum"
                        5 -> "Toner"
                        6 -> "Face Mask"
                        7 -> "Eye Cream"
                        8 -> "Spot Treatment"
                        9 -> "Exfoliator"
                        10 -> "Face Oil"
                        // Tambahkan nama produk sesuai nomor jika ditambahkan lebih banyak produk
                        else -> {
                            println("Nomor produk tidak valid.")
                            continue // Lanjutkan iterasi untuk meminta input lagi
                        }
                    }

                    print("Masukkan jumlah terjual: ")
                    val jumlahTerjual = scanner.nextInt()

                    toko.catatPenjualan(namaProduk, jumlahTerjual)
                    println("Penjualan produk $namaProduk berhasil dicatat.")
                }

                2 -> toko.tampilkanTotalPenjualan()

                3 -> {
                    println("Pilihan Produk yang Tersedia:")
                    println("1. Cleanser")
                    println("2. Moisturizer")
                    println("3. Sunscreen")
                    println("4. Serum")
                    println("5. Toner")
                    println("6. Face Mask")
                    println("7. Eye Cream")
                    println("8. Spot Treatment")
                    println("9. Exfoliator")
                    println("10. Face Oil")

                    print("Masukkan nomor produk yang ingin dibeli: ")
                    val nomorProduk = scanner.nextInt()

                    val namaProduk = when (nomorProduk) {
                        1 -> "Cleanser"
                        2 -> "Moisturizer"
                        3 -> "Sunscreen"
                        4 -> "Serum"
                        5 -> "Toner"
                        6 -> "Face Mask"
                        7 -> "Eye Cream"
                        8 -> "Spot Treatment"
                        9 -> "Exfoliator"
                        10 -> "Face Oil"
                        else -> {
                            println("Nomor produk tidak valid.")
                            continue
                        }
                    }

                    print("Masukkan jumlah yang ingin dibeli: ")
                    val jumlahBeli = scanner.nextInt()

                    val totalHarga = toko.beliProduk(namaProduk, jumlahBeli)
                    println("Anda telah membeli $jumlahBeli unit $namaProduk dengan total harga $totalHarga.")
                }

                4 -> {
                    println("Terima kasih telah menggunakan sistem penjualan.")
                    lanjutkan = false
                }

                else -> println("Pilihan tidak valid. Silakan pilih lagi.")
            }
        }
    }
}

internal class SkincareToko {
    private val hargaProduk = mapOf(
        "Cleanser" to 50,
        "Moisturizer" to 70,
        "Sunscreen" to 60,
        "Serum" to 90,
        "Toner" to 40,
        "Face Mask" to 80,
        "Eye Cream" to 75,
        "Spot Treatment" to 85,
        "Exfoliator" to 55,
        "Face Oil" to 65
    )

    private var totalPenjualan = 0

    fun catatPenjualan(namaProduk: String, jumlahTerjual: Int) {
        // Menggunakan parameter namaProduk saat mencatat penjualan
        println("Mencatat penjualan produk $namaProduk sebanyak $jumlahTerjual unit.")
        // Untuk sederhana, hanya menambahkan jumlah terjual ke total penjualan
        totalPenjualan += jumlahTerjual
    }

    fun tampilkanTotalPenjualan() {
        println("Total penjualan skincare: $totalPenjualan unit")
    }

    fun beliProduk(namaProduk: String, jumlahBeli: Int): Int {
        return if (hargaProduk.containsKey(namaProduk)) {
            val hargaSatuan = hargaProduk[namaProduk] ?: 0
            val totalHarga = hargaSatuan * jumlahBeli
            totalHarga
        } else {
            println("Produk tidak ditemukan.")
            0
        }
    }
}
