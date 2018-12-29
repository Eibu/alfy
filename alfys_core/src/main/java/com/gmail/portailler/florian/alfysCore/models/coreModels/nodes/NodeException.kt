package com.gmail.portailler.florian.alfysCore.models.coreModels.nodes

class NodeException(val causeDef: Cause, message: String?) : Exception(message) {

    constructor(causeDef: Cause): this(causeDef,causeDef.name.toLowerCase().capitalize().replace('_',' '))
    constructor(causeCode:Int):this(Cause.values()[causeCode])
}

enum class Cause(val code:Int){
    // From 0 to 9 system errors
    UNDEFINED(0),
    // From 10 to 20 binding errors
    DIFFERENT_FAMILY(10),
    ALREADY_A_PARENT(11),
    ALREADY_A_CHILD(12),
    CIRCULAR_FAMILY(13)
    //
}