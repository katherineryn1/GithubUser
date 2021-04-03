package com.katherineryn.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.katherineryn.githubuser.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.tb_toolbar)
        setSupportActionBar(toolbar)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)
        binding.tvName.text = user?.name
        binding.tvUsername.text = user?.username
        binding.tvFollowers.text = user?.followers.toString()
        binding.tvFollowing.text = user?.following.toString()
        binding.tvRepository.text = user?.repository.toString()
        binding.tvLocation.text = user?.location
        binding.tvCompany.text = user?.company

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions().override(100, 100))
            .into(binding.imgUser)
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}