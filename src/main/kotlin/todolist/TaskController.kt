package todolist

import spark.Route

class TaskController {
    fun index(): Route = Route { request, response ->
        listOf(
                Task(0, "お金を振り込む", false),
                Task(1, "電気を消す", false))
    }
}