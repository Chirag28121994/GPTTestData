package client

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class ChatGPTClient {
    private val client = OkHttpClient()
    private val mediaType = "application/json; charset=utf-8".toMediaType()
    private val apiKey: String = "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";

    fun generateStringData(prompt: String): String {
        val url = "https://api.openai.com/v1/engines/davinci/completions"
        val json = """
            {
                "prompt": "$prompt",
                "max_tokens": 60,
                "temperature": 0.5,
                "n": 1,
                "stop": "."
            }
        """.trimIndent()
        val requestBody = json.toRequestBody(mediaType)
        val request = Request.Builder()
            .url(url)
            .header("Authorization", "Bearer $apiKey")
            .post(requestBody)
            .build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: throw Exception("Empty response")
    }
}