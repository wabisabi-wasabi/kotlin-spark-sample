import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import todolist.Task

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    get("/hello") { request, response ->
        val name: String? = request.queryParams("name")
        "Hello ${name ?: "world"}"
    }

    get("/task",
            { request, response ->
                listOf(
                        Task(0, "お金を振り込む", false),
                        Task(1, "電気を消す", false))
            }, objectMapper::writeValueAsString
    )
}