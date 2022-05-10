package ru.pashaginas.myapplication

import ru.pashaginas.myapplication.remote.MoneyRemoteItem

data class MoneyItemDataClass(val amount: String, val purpose: String?)
{
    companion object {
        fun getInstance(moneyRemoteItem: MoneyRemoteItem) : MoneyItemDataClass {
            return MoneyItemDataClass(moneyRemoteItem.price.toString(), moneyRemoteItem.name)
        }
    }
}