package com.gmail.portailler.florian.alfysCore.models.coreModels

class TaskException(private val causeDef: Cause) : Exception(causeDef.name.toLowerCase().capitalize().replace('_',' ')) {

}

enum class Cause(val code:Int){
    TASK_ALREADY_EXISTS(1),
    CONTENT_UNDEFINED(10),
    TAG_ALREADY_OWNED(20)

}