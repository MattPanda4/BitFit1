package com.matt.bitfit1

import android.app.Application


class MyApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}