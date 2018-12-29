package com.gmail.portailler.florian.alfysCore.models

import android.system.Os.remove
import com.gmail.portailler.florian.alfysCore.models.coreModels.Cause
import com.gmail.portailler.florian.alfysCore.models.coreModels.Tag
import com.gmail.portailler.florian.alfysCore.models.coreModels.TaskContent
import com.gmail.portailler.florian.alfysCore.models.coreModels.TaskException
import com.gmail.portailler.florian.alfysCore.models.coreModels.nodes.RawNode

class AlfyTask(id: String, family: String, private var content: TaskContent?) : RawNode(id, family) {


    private val onChangehandlers: ArrayList<(task: AlfyTask)->Unit> = arrayListOf()
    private val tags : ArrayList<Tag> = arrayListOf()


    fun addOnChangeListener(handler: (task: AlfyTask)->Unit){
        onChangehandlers.add(handler)
    }

    fun clearListeners(){
        onChangehandlers.clear()
    }

    private fun trigger(){
        onChangehandlers.forEach { handler ->
            handler(this)
        }
    }

    fun addTag(tag:Tag){
        if(tags.contains(tag)){
            throw TaskException(Cause.TAG_ALREADY_OWNED)
        }
        tags.add(tag)
        trigger()
    }

    fun updateTag(tag:Tag){
        tags.forEach {
            if(it.name == tag.name){
                tags.remove(it)
                tags.add(tag)
                trigger()
            }
        }
    }

    fun removeTag(tag:Tag): Boolean{
        if(tags.contains(tag)){
            tags.remove(tag)
            trigger()
            return true
        }
        return false
    }

    fun hasTag(tag:Tag): Boolean{
        return tags.contains(tag)
    }

    fun hasTag(tagName:String): Boolean{
        tags.forEach { tag -> if(tag.name == tagName) return true}
        return false
    }

}