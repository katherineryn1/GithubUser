package com.katherineryn.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var avatar: Int? = 0,
    var name: String? = "",
    var username: String? = "",
    var location: String? = "",
    var repository: Int? = 0,
    var company: String? = "",
    var followers: Int? = 0,
    var following: Int? = 0
) : Parcelable