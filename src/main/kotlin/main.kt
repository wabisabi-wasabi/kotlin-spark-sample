import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import todolist.JsonTransformer
import todolist.TaskController

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskController = TaskController()

    get("/hello") { request, response ->
        val name: String? = request.queryParams("name")
        "Hello ${name ?: "world"}"
    }

    get("/task", taskController.index(), jsonTransformer)
}