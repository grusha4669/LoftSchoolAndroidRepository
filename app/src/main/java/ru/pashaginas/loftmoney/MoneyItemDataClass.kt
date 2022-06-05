package ru.pashaginas.loftmoney

import ru.pashaginas.loftmoney.remote.MoneyRemoteItem

data class MoneyItemDataClass(val amount: Int, val purpose: String?)
{
    companion object {
        fun getInstance(moneyRemoteItem: MoneyRemoteItem) : MoneyItemDataClass {
            return MoneyItemDataClass(moneyRemoteItem.price.toInt(), moneyRemoteItem.name)
        }
    }
}
