package client

import com.google.gson.Gson

// Define a data class to represent the response
data class TextCompletionResponse(
    val id: String,
    val objects: String,
    val created: Long,
    val model: String,
    val choices: List<TextCompletionChoice>,
    val usage: TextCompletionUsage
)

data class TextCompletionChoice(
    val text: String,
    val index: Int,
    val logprobs: Any?,
    val finish_reason: Any?
)

data class TextCompletionUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)