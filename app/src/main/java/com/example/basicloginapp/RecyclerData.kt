package com.example.basicloginapp

data class RecyclerList(var items: ArrayList<RecyclerData>)
data class RecyclerData(var name: String , var description: String, var owner: Owner)
data class Owner(var avatar_url: String)

