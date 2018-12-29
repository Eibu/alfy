package com.gmail.portailler.florian.alfysCore.models.coreModels

import java.io.Serializable

class TaskContent(val id:String): Serializable {

    constructor(id:String, title: String, content: String):this(id){
        this.title = title
        this.content = content
    }

    lateinit var title: String
    lateinit var content: String

}