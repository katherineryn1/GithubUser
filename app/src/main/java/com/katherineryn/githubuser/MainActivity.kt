package com.katherineryn.githubuser

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.katherineryn.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    private lateinit var dataAvatar: TypedArray
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: IntArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: IntArray
    private lateinit var dataFollowing: IntArray

    private lateinit var rvUser: RecyclerView
    private var listUser = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.tb_toolbar)
        setSupportActionBar(toolbar)

        rvUser = binding.rvUser
        rvUser.setHasFixedSize(true)

        prepare()
        addItem()
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val cardViewUserAdapter = CardViewUserAdapter(listUser)
        rvUser.adapter = cardViewUserAdapter
    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getIntArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getIntArray(R.array.followers)
        dataFollowing = resources.getIntArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            listUser.add(user)
        }
    }
}