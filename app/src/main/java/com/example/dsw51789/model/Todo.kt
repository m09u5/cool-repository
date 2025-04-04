package com.example.dsw51789.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
class Todo (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var createdAt: Date
)