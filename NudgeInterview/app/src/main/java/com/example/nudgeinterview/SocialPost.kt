package com.example.nudgeinterview

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


class SocialPost {
    var posts: ArrayList<Post> = ArrayList()

    fun createPosts() {
        posts.add(Post(comment= mutableListOf("new Comment 1"), like = true, name = "Name 1"))
        posts.add(Post(comment= mutableListOf("new Comment 2"), like = true, name = "Name 2"))
        posts.add(Post(comment= mutableListOf("new Comment 3"), like = true, name = "Name 3"))
        posts.add(Post(comment= mutableListOf("new Comment 4"), like = true, name = "Name 4"))
        posts.add(Post(comment= mutableListOf("new Comment 5"), like = true, name = "Name 5"))
    }

    // This is a critical section of code so we need to handle it synchronisely
    suspend fun addNewComment(postIndex: Int, newComment: String) {
        // We will use mutex with Lock to handle this synchronizely
        val mutex = Mutex()
        mutex.withLock {
            val postIndexObject = posts[postIndex]
            val comments: List<String> = postIndexObject.comment
            comments.lastIndexOf(newComment)
        }
    }


}
data class Post(
    val comment: List<String>,
    val like: Boolean,
    val name: String // Name of the post
)