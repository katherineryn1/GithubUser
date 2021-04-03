package com.katherineryn.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<CardViewUserAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvFollowers: TextView = itemView.findViewById(R.id.tv_followers)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_following)
        var imgUser: ImageView = itemView.findViewById(R.id.img_user)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_user, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(100, 100))
            .into(holder.imgUser)

        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.tvFollowers.text = user.followers.toString()
        holder.tvFollowing.text = user.following.toString()

        holder.itemView.setOnClickListener {
            val moveToUserDetailIntent = Intent(holder.itemView.context, UserDetailActivity::class.java)
            moveToUserDetailIntent.putExtra(UserDetailActivity.EXTRA_USER, listUser[position])
            holder.itemView.context.startActivity(moveToUserDetailIntent)

            Toast.makeText(
                holder.itemView.context,
                "Checking " + listUser[position].name + " details",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}