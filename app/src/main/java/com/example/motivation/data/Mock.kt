package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

class Phrase(val description:String,val categoryId:Int)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val sunny = MotivationConstants.FILTER.SUNNY
    private val happy = MotivationConstants.FILTER.HAPPY

   private val mListPhrase = listOf<Phrase>(
        Phrase("Bom dia 1",sunny),
        Phrase("Bom dia 2 ",sunny),
        Phrase("Bom dia 3",sunny),
        Phrase("Bom dia 4",sunny),
        Phrase("Bom dia 5",sunny),
        Phrase("Bom dia 6",happy),
        Phrase("Bom dia 7",happy),
        Phrase("Bom dia 8",happy),
        Phrase("Bom dia 9",happy),
        Phrase("Bom dia 10",happy),
    )
    fun getPhrase(value: Int):String{

        val filtered = mListPhrase.filter { it.categoryId == value || value == all}
        return filtered[Random.nextInt(filtered.size)].description

    }
}