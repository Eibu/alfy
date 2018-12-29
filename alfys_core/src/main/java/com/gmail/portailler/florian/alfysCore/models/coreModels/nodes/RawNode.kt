package com.gmail.portailler.florian.alfysCore.models.coreModels.nodes

import java.io.Serializable

open class RawNode(val id:String, val family:String): Serializable{

    var hasParents:Boolean = false
    val parents : ArrayList<RawNode> = arrayListOf()
    var hasChildren: Boolean = false
    val children : ArrayList<RawNode> = arrayListOf()


    fun addParent(parent: RawNode):Int{
        if(parent.family != family){
            throw NodeException(Cause.DIFFERENT_FAMILY)
        }
        if(children.contains(parent)){
            throw NodeException(Cause.ALREADY_A_CHILD)
        }
        if(parents.contains(parent)){
            throw NodeException(Cause.ALREADY_A_PARENT)
        }
        parents.add(parent)
        hasParents = parents.size>0
        return parents.size
    }

    fun removeParent(parent: RawNode):Boolean{
        val result = parents.remove(parent)
        hasParents = parents.size>0
        return result
    }


    fun addChild(child: RawNode):Int{
        if(child.family != family){
            throw NodeException(Cause.DIFFERENT_FAMILY)
        }
        if(parents.contains(child)){
            throw NodeException(Cause.ALREADY_A_PARENT)
        }
        if(children.contains(child)){
            throw NodeException(Cause.ALREADY_A_CHILD)
        }
        children.add(child)
        hasChildren = children.size>0
        return children.size
    }

    fun removeChild(child: RawNode):Boolean{
        val result = parents.remove(child)
        hasChildren = children.size>0
        return result
    }



}
