package com.example.e_conomiza.database

import com.example.e_conomiza.model.Lista


class FakeDatabase {

    companion object app{
        var database = mutableListOf<Lista>()
    }
}