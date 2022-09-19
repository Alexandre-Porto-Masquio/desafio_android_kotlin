package com.example.desafio_android_kotlin.Model

//import android.os.Parcelable
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

//@Entity
//@Parcelize
data class Character(
//    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    val nome: String,
    val descricao: String,
    val outro: String,
    val img: String?= "1"
) //: Parcelable