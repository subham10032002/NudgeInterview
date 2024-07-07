package com.example.nudgeinterview

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DebounceTechnique {

    fun <T> debounce(waitInMs: Long, scope: CoroutineScope, destinationFunction: (T) -> Unit): (T) -> Unit {

        var debounceJob: Job? = null

        return { param: T ->
            debounceJob?.cancel()
            debounceJob = scope.launch {
                delay(waitInMs)
                destinationFunction(param)
            }
        }

    }

    fun main() {
        val mainScope = CoroutineScope(Dispatchers.Main)

        val logMessage: (String) -> Unit = {
            println("Log message : $it")
        }

        val debounceLogMessage = debounce(1000, mainScope, logMessage)

        listOf("1st", "2nd", "3rd").forEach {
            debounce(1000, mainScope, logMessage)
            Thread.sleep(100)
        }
    }
}