import client.ChatGPTClient
import client.TextCompletionResponse
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
class GPTTest {
    @Test
    fun verifyGPTResponse(){
        val gptClient = ChatGPTClient()
        val jsonResponse  = gptClient.generateStringData("Please generate 10 unique email addresses separated by semicolons.")
        val responseText = getStringDataFromGPTResponse(jsonResponse)
        Assertions.assertNotNull(responseText)
        println(responseText)
    }

    fun getStringDataFromGPTResponse(jsonResponse: String): String{
        val gson = Gson()
        val response: TextCompletionResponse = gson.fromJson(jsonResponse,TextCompletionResponse::class.java)
        return response.choices[0].text
    }
}