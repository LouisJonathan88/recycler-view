package com.example.pahlawanindonesia

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pahlawanindonesia.model.Hero

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val ivHeroImage = findViewById<ImageView>(R.id.iv_heroImage)
        val tvHeroName = findViewById<TextView>(R.id.tv_heroName)
        val tvHeroDescription = findViewById<TextView>(R.id.tv_heroDescription)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("HERO_OBJECT", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("HERO_OBJECT")
        }

        if (hero != null){
            ivHeroImage.setImageResource(hero.photo)
            tvHeroName.text = hero.name
            tvHeroDescription.text = hero.description
        }
    }
}