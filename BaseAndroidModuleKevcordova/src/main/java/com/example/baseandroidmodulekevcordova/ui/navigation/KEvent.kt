package com.example.baseandroidmodulekevcordova.ui.navigation

/**
 * Event of either type to manage your content
 * Your main function is validate that has been handle and return your type data (content)
 *
 * @param content is either type class
 *
 * @author kevc77
 */
class KEvent <out T> (
    private val content: T
) {
    // Validate that the value is handle in the constructor
    private var hasBeenHandle = false

    /**
     * Validate the content was handle or not, and pass your value
     *
     * @return your class type or null if not is handle
     */
    fun getContentIfNotHandle(): T? = if (hasBeenHandle) {
        null
    } else {
        hasBeenHandle = true
        content
    }
}