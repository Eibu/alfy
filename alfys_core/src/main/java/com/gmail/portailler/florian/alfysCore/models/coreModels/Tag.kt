package com.gmail.portailler.florian.alfysCore.models.coreModels

import java.io.Serializable

class Tag(val name:String,val color:Int): Serializable{

    constructor(name:String, color:String):this(name,  color.toInt(radix = 16))
}

