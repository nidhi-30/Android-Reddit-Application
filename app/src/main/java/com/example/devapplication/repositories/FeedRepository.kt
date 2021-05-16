package com.example.devapplication.repositories

import com.example.devapplication.network.FeedService

class FeedRepository constructor(private val feedService: FeedService) {
    fun getFeeds() = feedService.getFeeds()
}